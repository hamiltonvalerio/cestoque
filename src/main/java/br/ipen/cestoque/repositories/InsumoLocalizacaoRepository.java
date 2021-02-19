package br.ipen.cestoque.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.Temporal;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.InsumoLocalizacao;

@Repository
public interface InsumoLocalizacaoRepository extends JpaRepository<InsumoLocalizacao, Integer>{

	@Query("SELECT il FROM InsumoLocalizacao il "
			+ "WHERE localizacao_id =:localizacao_id "
			+ "AND insumo =:insumo "
			+ "AND loteFornecedor =:loteFornecedor "
			+ "AND cast(:dataValidade as date) IS NULL OR dataValidade =:dataValidade "
			+ "AND dataIrradiacao =:dataIrradiacao ")
	public InsumoLocalizacao findDuplicado(
			@Param("localizacao_id") Integer localizacao_id, 
			@Param("insumo") Insumo insumo, 
			@Param("loteFornecedor") String loteFornecedor, 
			@Param("dataValidade") Date dataValidade,
			@Param("dataIrradiacao") Date dataIrradiacao);
	
	@Query("SELECT il FROM InsumoLocalizacao il "
			+ "WHERE localizacao_id =:localizacao_id "
			+ "AND insumo =:insumo "
			+ "AND lote_fornecedor =:loteFornecedor "
			+ "AND cast(:dataValidade as date) IS NULL OR data_validade =:dataValidade ")
	public InsumoLocalizacao findDuplicadoDataIrradiacaoNull(
			@Param("localizacao_id") Integer localizacao_id, 
			@Param("insumo") Insumo insumo,
			@Param("loteFornecedor") String loteFornecedor,
			@Param("dataValidade") Date dataValidade);
	
	@Query("SELECT il FROM InsumoLocalizacao il "
			+ "WHERE localizacao_id =:localizacao_id "
			+ "AND insumo =:insumo ")
	public InsumoLocalizacao findDuplicadoLocalizacaoInsumo(
			@Param("localizacao_id") Integer localizacao_id, 
			@Param("insumo") Insumo insumo);
	
	
	
	@Transactional(readOnly=true)
	@Query("SELECT il "
			+ "FROM InsumoLocalizacao il "
			+ "WHERE il.localizacao.id =:localizacao_id "
			+ "ORDER BY il.insumo.nome ASC")
	Page<InsumoLocalizacao> buscaTodosPorLocalizacao(@Param("localizacao_id") Integer localizacao_id, Pageable pageRequest);

	



	
	
	//InsumoLocalizacao findByIdLocalizacaoAndIdInsumo(Localizacao localizacao, Insumo insumo);

	@Transactional
	@Modifying
	@Query("UPDATE InsumoLocalizacao "
			+ "	SET quantidademinima =:quantidademinima "
			+ "	WHERE id =:insumolocalizacao_id")
	public void update(@Param("insumolocalizacao_id") int insumolocalizacao_id, @Param("quantidademinima") double quantidademinima);

	
	
	
	public List<InsumoLocalizacao> findAllByLocalizacao_id(Integer localizacao_id);

		

	//InsumoLocalizacao findByIdLocalizacao(Localizacao localizacao);

	

}
