package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Pagina;

@Repository
public interface PaginaRepository extends JpaRepository<Pagina, Integer>{

	Pagina findByNomeLike(String nomepagina);

	
	
}
