package br.ipen.cestoque.repositories;

import java.time.LocalDate;
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
	Page<InsumoLocalizacao> buscaTodosPorLocalizacaoSemVazio(@Param("localizacao_id") Integer localizacao_id,
			Pageable pageRequest);
		
	@Transactional(readOnly = true)
	@Query("SELECT il FROM InsumoLocalizacao il WHERE il.localizacao.id =:localizacao_id "
			+ "AND il.quantidade != 0"
			+ "ORDER BY il.insumo.nome ASC")
	public List<InsumoLocalizacao> buscaTodosPorLocalizacaoList(@Param("localizacao_id") Integer localizacao_id);
	
	@Transactional(readOnly = true)
	@Query(value = "SELECT il.* "
			+ "	FROM insumolocalizacao il "
			+ "	ORDER BY il.quarentena = true DESC NULLS LAST, il.datalt DESC ", nativeQuery = true)
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
	
	@Query("SELECT il FROM InsumoLocalizacao il "
			+ "WHERE il.localizacao =:localizacao "
			+ "AND il.insumo = :insumo "
			+ "AND il.loteLEI = :loteLEI ")
	public InsumoLocalizacao findDuplicadoLoteLei(
			@Param("insumo") Insumo insumo, 
			@Param("localizacao") Localizacao localizacao,
			@Param("loteLEI") String loteLEI);
	
	@Query(value = "SELECT DISTINCT on (lotelei) lotelei, * FROM public.insumolocalizacao ", nativeQuery = true)
	public List<InsumoLocalizacao> findLotesLEIInsumosLocalizacoes();
	
	@Transactional
	@Modifying
	@Query("UPDATE InsumoLocalizacao " + "	SET quantidade =:quantidade "
			+ "	WHERE id =:insumolocalizacao_id")
	public void updateAjusteQuantidade(@Param("insumolocalizacao_id") int insumolocalizacao_id,
			@Param("quantidade") double quantidade);

	@Transactional
	@Modifying
	@Query("UPDATE InsumoLocalizacao " + "	SET aprovado =:aprovado,  quarentena =:quarentena "
			+ "	WHERE lotelei LIKE :lotelei")
	public void updateAprovacaoPorLoteLEI(
			@Param("aprovado") boolean aprovado, 
			@Param("lotelei") String lotelei,
			@Param("quarentena") boolean quarentena);
	
	@Transactional
	@Modifying
	@Query("UPDATE InsumoLocalizacao " + "	SET quarentena =:quarentena "
			+ "	WHERE lotelei LIKE :lotelei")
	public void updateQuarentenaPorLoteLEI( 
			@Param("lotelei") String lotelei,
			@Param("quarentena") boolean quarentena);

	@Transactional(readOnly = true)
	@Query("SELECT il FROM InsumoLocalizacao il "
			+ "WHERE lotelei LIKE :lotelei "
			+ "ORDER BY id ASC")
	public List<InsumoLocalizacao> findInsumosLocalizacoesByLoteLEI(@Param("lotelei") String loteLEI);
	
	@Query("SELECT DISTINCT(il.subloteLEI) FROM InsumoLocalizacao il "
			+ "WHERE loteLEI LIKE :lotelei ")
	public String buscaDistinctLotePaiByLoteLei(@Param("lotelei") String loteLEI);

	@Transactional
	@Modifying
	@Query("UPDATE InsumoLocalizacao " + "	SET usuariorecebidonocontrole =:usecont, recebidonocontrole =:reccont, datarecebidonocontrole =:datacont "
			+ "	WHERE id =:insumolocalizacao_id")
	public void updateRecebimento(
			@Param("insumolocalizacao_id") int insumolocalizacao_id, 
			@Param("usecont") String usuariorecebidonocontrole, 
			@Param("reccont") Boolean recebidonocontrole, 
			@Param("datacont") Date datarecebidonocontrole);
	
	
	@Transactional
	@Modifying
	@Query("UPDATE InsumoLocalizacao " + "	SET dataPrevisaoControle =:dataPrevisaoControle, datalt =:datalt, usualt =:usualt "
			+ "	WHERE id =:insumolocalizacao_id")
	public void updatePrevisaoControle(
			@Param("insumolocalizacao_id") int insumolocalizacao_id, 
			@Param("dataPrevisaoControle") Date date, 
			@Param("datalt") Date datalt,
			@Param("usualt") String usualt);

	
	@Transactional(readOnly = true)
	@Query("SELECT il FROM InsumoLocalizacao il WHERE il.localizacao.id =:localizacao_id "
			+ "AND il.insumo.nome like upper(concat('%', :nome,'%')) "
			+ "ORDER BY il.insumo.nome ASC")
	public List<InsumoLocalizacao> findInsumoLocalizacaoByNome(
			@Param("localizacao_id") int localizacao_id, 
			@Param("nome") String nome);

	@Transactional(readOnly = true)
	@Query("SELECT il FROM InsumoLocalizacao il WHERE il.localizacao.id =:localizacao_id "
			+ "AND il.insumo.codigoalmox like :codalmox "
			+ "ORDER BY il.insumo.nome ASC")
	public List<InsumoLocalizacao> findInsumoLocalizacaoByCodalmox(
			@Param("localizacao_id") int localizacao_id, 
			@Param("codalmox") String codalmox);

	@Transactional(readOnly = true)
	@Query("SELECT il FROM InsumoLocalizacao il WHERE il.localizacao.id =:localizacao_id "
			+ "AND il.loteLEI LIKE :lotelei "
			+ "ORDER BY il.insumo.nome ASC")
	public List<InsumoLocalizacao> findInsumoLocalizacaoByLotelei(
			@Param("localizacao_id") int localizacao_id, 
			@Param("lotelei") String lotelei);

	@Transactional(readOnly = true)
	@Query("SELECT il FROM InsumoLocalizacao il WHERE il.localizacao.id =:localizacao_id "
			+ "AND il.subloteLEI like :sublotelei "
			+ "ORDER BY il.insumo.nome ASC")
	public List<InsumoLocalizacao> findInsumoLocalizacaoBySublotelei(
			@Param("localizacao_id") int localizacao_id, 
			@Param("sublotelei") String sublotelei);
	
	@Transactional
	@Modifying
	@Query("UPDATE InsumoLocalizacao " + "	SET irradiado =:irradiado,  quarentena =:quarentena "
			+ "	WHERE lotelei LIKE :lotelei")
	public void updateIrradiacaoPorLoteLEI(
			@Param("irradiado") boolean irradiado, 
			@Param("lotelei") String lotelei,
			@Param("quarentena") boolean quarentena);


	
}
