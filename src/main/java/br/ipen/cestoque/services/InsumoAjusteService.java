package br.ipen.cestoque.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.domain.InsumoAjuste;
import br.ipen.cestoque.domain.InsumoLocalizacao;
import br.ipen.cestoque.repositories.InsumoAjusteRepository;
import br.ipen.cestoque.repositories.InsumoLocalizacaoRepository;
import br.ipen.cestoque.repositories.InsumoRepository;
import br.ipen.cestoque.resources.utils.ComparaInsumoLocalizacao;

@Service
public class InsumoAjusteService {
	
	@Autowired
	private InsumoRepository insumoRepository;
	
	@Autowired
	private InsumoLocalizacaoRepository insumoLocalizacaoRepository;
	
	@Autowired
	private InsumoAjusteRepository insumoAjusteRepository;
	
	@Autowired
	private ComparaInsumoLocalizacao comparaInsumoLocalizacao;
	
	@Transactional
	public InsumoAjuste insert(InsumoAjuste insumoAjuste) {
		
		InsumoLocalizacao insumoLocalizacao = new InsumoLocalizacao();
		
		insumoLocalizacao = comparaInsumoLocalizacao.compara(insumoAjuste.getInsumo(), insumoAjuste.getLocalizacao(), insumoAjuste.getLoteFornecedor(), insumoAjuste.getDataValidade(), insumoAjuste.getDataIrradiacao());
		
		if(insumoLocalizacao == null) {
		
			insumoLocalizacao = new InsumoLocalizacao();
			insumoLocalizacao.setInsumo(insumoAjuste.getInsumo());
			insumoLocalizacao.setLocalizacao(insumoAjuste.getLocalizacao());
			insumoLocalizacao.setQuantidade(insumoAjuste.getQuantidade());
			insumoLocalizacao.setLoteFornecedor(insumoAjuste.getLoteFornecedor());
			insumoLocalizacao.setLoteCR(insumoAjuste.getLoteCR());
			insumoLocalizacao.setDataIrradiacao(insumoAjuste.getDataIrradiacao());
			insumoLocalizacao.setDataValidade(insumoAjuste.getDataValidade());
			insumoLocalizacao.setLoteRecebimento(insumoAjuste.getLoteRecebimento());
			insumoLocalizacao.setDataFabricacao(insumoAjuste.getDataFabricacao());
			insumoLocalizacao.setLoteARM(insumoAjuste.getLoteARM());
			
			insumoLocalizacaoRepository.save(insumoLocalizacao);
		}else {

			insumoLocalizacaoRepository.updateAjusteQuantidade(insumoLocalizacao.getId(), insumoLocalizacao.getQuantidade());
	
		}
		
		insumoAjuste = insumoAjusteRepository.save(insumoAjuste);
		return insumoAjuste;
	}

	public List<InsumoAjuste> findAjustesByDataELocalizacao(int localizacao_id, Date dataAjuste) {
		DateTime dt = new DateTime(dataAjuste);
		DateTimeFormatter dtf = DateTimeFormat.forPattern("dd-MM-yyyy");
		//Boolean bol = insumoAjusteRepository.findAjustesByDataELocalizacao2(localizacao_id, dt.toString(dtf));
		List<InsumoAjuste> lista = insumoAjusteRepository.findAjustesByDataELocalizacao(localizacao_id, dt.toString(dtf));
		return lista;
	}

	public List<InsumoAjuste> montaAjusterPorLocalizacao(Integer localizacao_id) {
		// TODO Auto-generated method stub
		List<InsumoLocalizacao> listaInsumosLocalizacao = insumoLocalizacaoRepository.buscaTodosPorLocalizacaoList(localizacao_id);
		return this.converteListaInsumoLocalizacaoParaInsumoAjuste(listaInsumosLocalizacao);
	}
	
	public List<InsumoAjuste> converteListaInsumoLocalizacaoParaInsumoAjuste(List<InsumoLocalizacao>  listaInsumosLocalizacao){
		List<InsumoAjuste> listaInsumoAjuste = new ArrayList<>();
		//aqui ta a mágica
		
		for(InsumoLocalizacao lista : listaInsumosLocalizacao) {
			listaInsumoAjuste.add(new InsumoAjuste(lista));
		}
		
		return listaInsumoAjuste;
	}
	
}
