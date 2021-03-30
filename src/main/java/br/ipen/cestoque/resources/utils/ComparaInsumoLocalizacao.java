package br.ipen.cestoque.resources.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.common.collect.ComparisonChain;
import com.google.common.collect.Ordering;

import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.InsumoLocalizacao;
import br.ipen.cestoque.domain.Localizacao;
import br.ipen.cestoque.repositories.InsumoLocalizacaoRepository;

@Component
public class ComparaInsumoLocalizacao {

	@Autowired
	private InsumoLocalizacaoRepository insumoLocalizacaoRepository;
	
	private InsumoLocalizacao retorno = new InsumoLocalizacao();
	
	List<InsumoLocalizacao> listaIL = new ArrayList<>();

	public InsumoLocalizacao compara(Insumo insumo, Localizacao localizacao, String loteFornecedor,
			LocalDate dataValidade, LocalDateTime dataIrradiacao) {

		listaIL = insumoLocalizacaoRepository.findTodosDuplicado(insumo, localizacao,
				loteFornecedor, dataValidade, dataIrradiacao);

		if(listaIL.size() == 1) {
			
			retorno = listaIL.get(0);
			int comp1 = ComparisonChain.start()
					.compare(insumo.getId(), listaIL.get(0).getInsumo().getId())
					.compare(localizacao.getId(), listaIL.get(0).getLocalizacao().getId())
					.compare(loteFornecedor, listaIL.get(0).getLoteFornecedor(), Ordering.natural().nullsFirst())
					.compare(dataValidade, listaIL.get(0).getDataValidade(), Ordering.natural().nullsFirst())
					.compare(dataIrradiacao, listaIL.get(0).getDataIrradiacao(), Ordering.natural().nullsFirst()).result();
			if(comp1 == 0) {
				retorno = listaIL.get(0);
			}else if(comp1 == -1){
				retorno = null;
			}
			
			
			
		}else if(listaIL.size() > 1) {				
			for (InsumoLocalizacao lo : listaIL) {
				int comp = ComparisonChain.start()
						.compare(insumo.getId(), lo.getInsumo().getId())
						.compare(localizacao.getId(), lo.getLocalizacao().getId())
						.compare(loteFornecedor, lo.getLoteFornecedor(), Ordering.natural().nullsFirst())
						.compare(dataValidade, lo.getDataValidade(), Ordering.natural().nullsFirst())
						.compare(dataIrradiacao, lo.getDataIrradiacao(), Ordering.natural().nullsFirst()).result();
				if(comp == 0) {
					retorno = lo;
					break;
				}else if(comp == -1){
					retorno = null;
				}
			}
		}else {
			retorno = null;
		}
		
		return retorno;
	}
	
	
}
