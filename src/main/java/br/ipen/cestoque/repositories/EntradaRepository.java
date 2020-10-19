package br.ipen.cestoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Integer>{
	
	public List<Entrada> findAllByOrderByDataEntradaDesc();
	
}
