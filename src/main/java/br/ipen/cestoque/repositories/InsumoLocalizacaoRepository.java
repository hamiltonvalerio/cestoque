package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.InsumoLocalizacao;
import br.ipen.cestoque.domain.InsumoLocalizacaoPK;
import br.ipen.cestoque.domain.Localizacao;

@Repository
public interface InsumoLocalizacaoRepository extends JpaRepository<InsumoLocalizacao, InsumoLocalizacaoPK>{

	InsumoLocalizacao findByIdLocalizacaoAndIdInsumo(Localizacao localizacao, Insumo insumo);

	//InsumoLocalizacao findByIdLocalizacao(Localizacao localizacao);

	

}
