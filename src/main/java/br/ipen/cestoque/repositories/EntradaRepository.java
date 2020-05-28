package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Integer>{
	
	
	
}
