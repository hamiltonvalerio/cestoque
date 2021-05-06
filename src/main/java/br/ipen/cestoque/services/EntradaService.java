package br.ipen.cestoque.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.domain.Entrada;
import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.InsumoEntrada;
import br.ipen.cestoque.domain.InsumoLocalizacao;
import br.ipen.cestoque.domain.Localizacao;
import br.ipen.cestoque.repositories.EntradaRepository;
import br.ipen.cestoque.repositories.InsumoEntradaRepository;
import br.ipen.cestoque.repositories.InsumoLocalizacaoRepository;
import br.ipen.cestoque.repositories.InsumoRepository;
import br.ipen.cestoque.resources.utils.ComparaInsumoLocalizacao;
import br.ipen.cestoque.services.exception.ObjectNotFoundException;


@Service
public class EntradaService {

	@Autowired
	private EntradaRepository repo;
	
	@Autowired
	private InsumoEntradaRepository insumoEntradaRepository;
	
	@Autowired
	private InsumoRepository insumoRepository;
	
	@Autowired
	private InsumoLocalizacaoRepository insumoLocalizacaoRepository;
	
	@Autowired
	private InsumoService insumoService;
	
	@Autowired
	private ComparaInsumoLocalizacao comparaInsumoLocalizacao; 
	
	@SuppressWarnings("unused")
	@Autowired
	private ColaboradorService colaboradorService;
		
	public Entrada find(Integer id) throws ObjectNotFoundException {
		Optional<Entrada> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Entrada.class.getName()));
	}

	@Transactional
	public Entrada insert(Entrada entrada) {
		List<Insumo> insumos = new ArrayList<>();
		List<InsumoLocalizacao> insumosLocalizacoes = new ArrayList<>();
		Insumo insumo;
		Double quant;
		
		Localizacao localizacao = new Localizacao();
		InsumoLocalizacao insumoLocalizacao;
		localizacao = entrada.getLocalizacao();
		
		entrada.setId(null);
		entrada.setUsualt(UserService.authenticated().getUsername());
		entrada.setDatalt(new Date(System.currentTimeMillis()));
		entrada = repo.save(entrada);
		
		for(InsumoEntrada ie : entrada.getItens()) {
			insumo = new Insumo();
			insumo = insumoService.find(ie.getInsumo().getId());
			insumo.setUnidade(ie.getInsumo().getUnidade());
			insumo.setValor(ie.getValor());
			quant = ie.getQuantidade();
			ie.setInsumo(insumo);
			ie.setQuantidade(quant);
			ie.setLoteRecebimento(entrada.getLoteRecebimento());
			//insumo.setId(ie.getInsumo().getId());
			if(ie.getInsumo().getQuantidade() == null) {
				ie.getInsumo().setQuantidade(0.0);
			}
			/*insumo.setQuantidade(ie.getInsumo().getQuantidade() + quant);
			 * Tirei o somatório do insumo e vou deixar nas localizações*/
			insumo.setQuantidade(ie.getInsumo().getQuantidade());
			insumos.add(insumo);
			
			//verificar se tem insumos nesta localização, se sim, somar os as quantidades
			insumoLocalizacao = new InsumoLocalizacao();
			//insumoLocalizacao = insumoLocalizacaoRepository.findDuplicado(insumo, localizacao, ie.getLoteFornecedor(), ie.getDataValidade(), ie.getDataIrradiacao());
			insumoLocalizacao = comparaInsumoLocalizacao.compara(insumo, localizacao, ie.getLoteFornecedor(), ie.getDataValidade(), ie.getDataIrradiacao());
			
			if(insumoLocalizacao == null) {
				insumoLocalizacao = new InsumoLocalizacao();
				insumoLocalizacao.setInsumo(insumo);
				insumoLocalizacao.setLocalizacao(entrada.getLocalizacao());
				insumoLocalizacao.setQuantidade(quant);
				insumoLocalizacao.setLoteFornecedor(ie.getLoteFornecedor());
				insumoLocalizacao.setLoteCR(ie.getLoteCR());
				insumoLocalizacao.setDataIrradiacao(ie.getDataIrradiacao());
				insumoLocalizacao.setDataValidade(ie.getDataValidade());
				insumoLocalizacao.setLoteRecebimento(entrada.getLoteRecebimento());
				insumosLocalizacoes.add(insumoLocalizacao);
			}else {
				Double novaQuantidade = insumoLocalizacao.getQuantidade() + quant;
				insumoLocalizacao.setQuantidade(novaQuantidade);
				insumoLocalizacao.setLoteRecebimento(entrada.getLoteRecebimento());
				insumosLocalizacoes.add(insumoLocalizacao);
			}
			
			//testar acima local
			
			
			
			//ie.setValor(ie.getInsumo().getValor());
			ie.setEntrada(entrada);
		}
		insumoLocalizacaoRepository.saveAll(insumosLocalizacoes);
		insumoEntradaRepository.saveAll(entrada.getItens());
		insumoRepository.saveAll(insumos);
		return entrada;
	}
	
	public List<Entrada> findAll() {
		// TODO Auto-generated method stub
		//return repo.findAll();
		
		return repo.findAllByOrderByDataEntradaDesc();
		
	}
	
	
	public List<Entrada> findAllOrderById() {
		try {
			return repo.findAllByOrderByIdDesc();
		} catch (Exception e) {
			// TODO: handle exception
			return null;
		}
	
	}

	public Integer findMaxId() {
		// TODO Auto-generated method stub
		
		return repo.findMaxId();
	}
}
