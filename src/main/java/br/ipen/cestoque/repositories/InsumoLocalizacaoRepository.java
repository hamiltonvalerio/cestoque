package br.ipen.cestoque.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.InsumoLocalizacao;
import br.ipen.cestoque.domain.InsumoLocalizacaoPK;
import br.ipen.cestoque.domain.Localizacao;

@Repository
public interface InsumoLocalizacaoRepository extends JpaRepository<InsumoLocalizacao, InsumoLocalizacaoPK>{

	InsumoLocalizacao findByIdLocalizacaoAndIdInsumo(Localizacao localizacao, Insumo insumo);

	@Transactional
	@Modifying
	@Query("UPDATE InsumoLocalizacao "
			+ "	SET quantidademinima =:quantidademinima "
			+ "	WHERE insumo_id =:insumo_id AND localizacao_id =:localizacao_id")
	public void update(@Param("insumo_id") int insumo_id, @Param("localizacao_id") int localizacao_id, @Param("quantidademinima") double quantidademinima);

	

	//InsumoLocalizacao findByIdLocalizacao(Localizacao localizacao);

	

}
