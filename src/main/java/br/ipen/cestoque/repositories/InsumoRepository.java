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

@Repository
public interface InsumoRepository extends JpaRepository<Insumo, Integer>{

	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Insumo obj INNER JOIN obj.categorias"
			+ " cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Insumo> search(@Param("nome") String nome, @Param("categorias") List<Categoria> categorias, Pageable pageRequest);

}
