package br.ipen.cestoque.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.InsumoLocalizacao;
import br.ipen.cestoque.domain.InsumoMovimentacao;
import br.ipen.cestoque.domain.Localizacao;
import br.ipen.cestoque.domain.Movimentacao;
import br.ipen.cestoque.repositories.InsumoLocalizacaoRepository;
import br.ipen.cestoque.repositories.InsumoMovimentacaoRepository;
import br.ipen.cestoque.repositories.InsumoRepository;
import br.ipen.cestoque.repositories.MovimentacaoRepository;


@Service
public class MovimentacaoService {

	@Autowired
	private MovimentacaoRepository repo;
	//private EntradaRepository repo;
	
	@Autowired
	private InsumoMovimentacaoRepository insumoMovimentacaoRepository; 
	
	@Autowired
	private InsumoRepository insumoRepository;
	
	@Autowired
	private InsumoLocalizacaoRepository insumoLocalizacaoRepository;
	
	@Autowired
	private InsumoService insumoService;
	
	
	@Transactional
	public Movimentacao insert(Movimentacao obj) {
		List<Insumo> insumos = new ArrayList<>();
		List<InsumoLocalizacao> insumosLocalizacoesDestino = new ArrayList<>();
		List<InsumoLocalizacao> insumosLocalizacoesOrigem = new ArrayList<>();
		Insumo insumo;
		Double quant;
		
		Localizacao localizacaoOrigem = new Localizacao();
		InsumoLocalizacao insumoLocalizacaoOrigem;
		localizacaoOrigem = obj.getLocalizacaoOrigem();
		
		Localizacao localizacaoDestino = new Localizacao();
		InsumoLocalizacao insumoLocalizacaoDestino;
		localizacaoDestino = obj.getLocalizacaoDestino();
		
		obj.setId(null);
		obj.setUsualt(UserService.authenticated().getUsername());
		obj.setDatalt(new Date(System.currentTimeMillis()));
		obj = repo.save(obj);
		
		for(InsumoMovimentacao im : obj.getItens()) {
			insumo = new Insumo();
			insumo = insumoService.find(im.getInsumo().getId());
			insumo.setUnidade(im.getInsumo().getUnidade());
			insumo.setValor(im.getInsumo().getValor());
			quant = im.getQuantidadeMovimentada();
			im.setInsumo(insumo);
			//im.setQuantidadeMovimentada(quant);
			if(im.getInsumo().getQuantidade() == null) {
				im.getInsumo().setQuantidade(0.0);
			}
			insumo.setQuantidade(im.getInsumo().getQuantidade());
			insumos.add(insumo);
			
			//verificar se tem insumos nesta localização, se sim, somar os as quantidades
			insumoLocalizacaoDestino = new InsumoLocalizacao();
			
			insumoLocalizacaoDestino = insumoLocalizacaoRepository.findByIdLocalizacaoAndIdInsumo(localizacaoDestino, insumo);
			
			if(insumoLocalizacaoDestino == null) {
				insumoLocalizacaoDestino = new InsumoLocalizacao();
				insumoLocalizacaoDestino.setInsumo(insumo);
				insumoLocalizacaoDestino.setLocalizacao(obj.getLocalizacaoDestino());
				insumosLocalizacoesDestino.add(insumoLocalizacaoDestino);
				insumoLocalizacaoDestino.setQuantidade(quant);
			}else {
				Double novaQuantidade = insumoLocalizacaoDestino.getQuantidade() + quant;
				insumoLocalizacaoDestino.setQuantidade(novaQuantidade);
				insumosLocalizacoesDestino.add(insumoLocalizacaoDestino);
			}
			
			//verificar se tem insumos nesta localização ORIGEM, se sim, subtrair as quantidades
			insumoLocalizacaoOrigem = new InsumoLocalizacao();
			
			insumoLocalizacaoOrigem = insumoLocalizacaoRepository.findByIdLocalizacaoAndIdInsumo(localizacaoOrigem, insumo);
			Double novaQuantidade = insumoLocalizacaoOrigem.getQuantidade() - quant;
			insumoLocalizacaoOrigem.setQuantidade(novaQuantidade);
			insumosLocalizacoesOrigem.add(insumoLocalizacaoOrigem);
			
			im.setMovimentacao(obj);

		}
		
			insumoLocalizacaoRepository.saveAll(insumosLocalizacoesDestino);
			insumoLocalizacaoRepository.saveAll(insumosLocalizacoesOrigem);
			insumoMovimentacaoRepository.saveAll(obj.getItens());
			insumoRepository.saveAll(insumos);
			return obj;
	}
	
	public List<Movimentacao> findAll() {
		// TODO Auto-generated method stub
		//return repo.findAll();
		return repo.findAll();
		
	}
}
