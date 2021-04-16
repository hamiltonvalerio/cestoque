package br.ipen.cestoque.repositories;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.InsumoLocalizacao;
import br.ipen.cestoque.domain.Localizacao;

@Repository
public interface InsumoLocalizacaoRepository extends JpaRepository<InsumoLocalizacao, Integer> {

	/*@Query("SELECT il FROM InsumoLocalizacao il "
			+ "WHERE il.localizacao_id =:localizacao_id "
			+ "AND il.insumo =:insumo "
			+ "AND (:loteFornecedor is null or il.lote_fornecedor = :loteFornecedor) "
			+ "AND (:dataValidade is null or il.data_validade = :dataValidade) "
			+ "AND (:dataIrradiacao is null or il.data_irradiacao = :dataIrradiacao) ")
	public InsumoLocalizacao findDuplicado(
			@Param("localizacao_id") Integer localizacao_id,
			@Param("insumo") Insumo insumo, 
			@Param("loteFornecedor") String loteFornecedor,
			@Param("dataValidade") Date dataValidade, 
			@Param("dataIrradiacao") Date dataIrradiacao);*/
	
	@Query("SELECT il FROM InsumoLocalizacao il "
			+ "WHERE il.localizacao =:localizacao "
			+ "AND il.insumo =:insumo "
			+ "AND (:loteFornecedor is null or il.loteFornecedor = :loteFornecedor) "
			+ "AND (cast(:dataValidade as date) is null or il.dataValidade = :dataValidade) "
			+ "AND (cast(:dataIrradiacao as date) is null or il.dataIrradiacao = :dataIrradiacao) ")
	public InsumoLocalizacao findDuplicado2(
			@Param("insumo") Insumo insumo, 
			@Param("localizacao") Localizacao localizacao,
			@Param("loteFornecedor") String loteFornecedor,
			@Param("dataValidade") Date dataValidade, 
			@Param("dataIrradiacao") Date dataIrradiacao);
	
	@Query("SELECT il FROM InsumoLocalizacao il "
			+ "WHERE il.localizacao =:localizacao "
			+ "AND il.insumo =:insumo "
			+ "AND (:loteFornecedor is null or il.loteFornecedor = :loteFornecedor) "
			+ "AND (cast(:dataValidade as date) is null or il.dataValidade = :dataValidade) "
			+ "AND (cast(:dataIrradiacao as date) is null or il.dataIrradiacao = :dataIrradiacao) ")
	public InsumoLocalizacao findDuplicado(
			@Param("insumo") Insumo insumo, 
			@Param("localizacao") Localizacao localizacao,
			@Param("loteFornecedor") String loteFornecedor,
			@Param("dataValidade") Date dataValidade, 
			@Param("dataIrradiacao") Date dataIrradiacao);

	@Transactional(readOnly = true)
	@Query("SELECT il FROM InsumoLocalizacao il WHERE il.localizacao.id =:localizacao_id "
			+ "AND il.quantidade != 0 "
			+ "ORDER BY il.insumo.nome ASC")
	Page<InsumoLocalizacao> buscaTodosPorLocalizacao(@Param("localizacao_id") Integer localizacao_id,
			Pageable pageRequest);

	@Transactional
	@Modifying
	@Query("UPDATE InsumoLocalizacao " + "	SET quantidademinima =:quantidademinima "
			+ "	WHERE id =:insumolocalizacao_id")
	public void update(@Param("insumolocalizacao_id") int insumolocalizacao_id,
			@Param("quantidademinima") double quantidademinima);

	public List<InsumoLocalizacao> findAllByLocalizacao_id(Integer localizacao_id);

	@Query("SELECT il FROM InsumoLocalizacao il "
			+ "WHERE il.localizacao =:localizacao "
			+ "AND il.insumo =:insumo "
			+ "AND (:loteFornecedor is null or il.loteFornecedor = :loteFornecedor) "
			+ "AND (cast(:dataValidade as date) is null or il.dataValidade = :dataValidade) "
			+ "AND (cast(:dataIrradiacao as date) is null or il.dataIrradiacao = :dataIrradiacao) ")
	public List<InsumoLocalizacao> findTodosDuplicado(
			@Param("insumo") Insumo insumo, 
			@Param("localizacao") Localizacao localizacao,
			@Param("loteFornecedor") String loteFornecedor,
			@Param("dataValidade") LocalDate dataValidade, 
			@Param("dataIrradiacao") LocalDate dataIrradiacao);
	
	
}
