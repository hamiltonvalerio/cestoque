package br.ipen.cestoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer>{

	List<Perfil> findAllByOrderByNomeAsc();

	@Query(value="SELECT p.* "
			+ " FROM perfil p "
			+ " INNER JOIN paginaperfil pp on (pp.perfil_id = p.id) "
			+ " INNER JOIN pagina pa on (pa.id = pp.pagina_id) "
			+ " WHERE pa.nome = :nomepagina ",nativeQuery = true)
	List<Perfil> findAllByNomePagina(@Param("nomepagina") String nomepagina);

}
