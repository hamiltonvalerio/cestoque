package br.ipen.cestoque.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ipen.cestoque.domain.Categoria;
import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.InsumoLocalizacao;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Integer>{

	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Insumo obj "
			+ "INNER JOIN obj.categorias cat "
			+ "WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Insumo> search(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);

	public List<Insumo> findAllByOrderByNomeAsc();

	
	@Transactional(readOnly=true)
	@Query("SELECT  i "
			+ "FROM Insumo i "
			+ "INNER JOIN InsumoLocalizacao ie ON (ie.insumo.id = i.id) "
			+ "WHERE ie.localizacao.id = :localizacao_id")
	Page<Insumo> findByLocalizacaoId(@Param("localizacao_id") Integer localizacao_id, Pageable  pageRequest);

	
	@Transactional(readOnly=true)
	@Query("SELECT  i "
			+ "FROM Insumo i "
			+ "INNER JOIN InsumoLocalizacao ie ON (ie.insumo.id = i.id) "
			+ "WHERE ie.localizacao.id = :localizacao_id "
			+ "ORDER BY i.nome ASC")
	public List<Insumo> buscaporlocalizacaonopage(@Param("localizacao_id") Integer localizacao_id);
	
	@Transactional(readOnly=true)
	@Query("SELECT  il "
			+ "FROM InsumoLocalizacao il "
			+ "WHERE il.localizacao.id = :localizacao_id "
			+ "ORDER BY il.insumo.nome ASC")
	public List<Insumo> buscaTodosPorLocalizacao(@Param("localizacao_id") Integer localizacao_id);




}
//, u, ie.id.localizacao.nome as insumolocalizacao, ie.quantidade as quantlocalizacao 