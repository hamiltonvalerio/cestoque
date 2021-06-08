package br.ipen.cestoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.InsumoAjuste;

@Repository
public interface InsumoAjusteRepository extends JpaRepository<InsumoAjuste, Integer>{

	@Query(value="SELECT ia.* FROM insumoajuste ia "
			+ "	WHERE "
			+ "	ia.localizacao_id =:localizacao_id "
			+ " and TO_CHAR(ia.data_ajuste, 'dd-MM-YYYY') =:data_ajuste", 
			nativeQuery = true)
	public List<InsumoAjuste> findAjustesByDataELocalizacao(
			@Param("localizacao_id") int localizacao_id, 
			@Param("data_ajuste") String data_ajuste);
	
	@Query(value="SELECT true FROM insumoajuste ia "
			+ "	WHERE "
			+ "	ia.localizacao_id =:localizacao_id "
			+ " and TO_CHAR(ia.data_ajuste, 'dd-MM-YYYY') =:data_ajuste", 
			nativeQuery = true)
	public Boolean findAjustesByDataELocalizacao2(
			@Param("localizacao_id") int localizacao_id, 
			@Param("data_ajuste") String data_ajuste);

}
