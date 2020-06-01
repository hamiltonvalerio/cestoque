package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Saida;

@Repository
public interface SaidaRepository extends JpaRepository<Saida, Integer>{
	
	
	
}
