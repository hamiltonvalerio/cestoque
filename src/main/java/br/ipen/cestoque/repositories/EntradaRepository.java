package br.ipen.cestoque.repositories;

import javax.transaction.Transactional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Colaborador;
import br.ipen.cestoque.domain.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Integer>{
	
	@Transactional
	Page<Entrada> findByColaborador(Colaborador colaborador, Pageable pageRequest);
	
	
}
