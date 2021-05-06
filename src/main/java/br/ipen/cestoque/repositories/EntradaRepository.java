package br.ipen.cestoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ipen.cestoque.domain.Entrada;

@Repository
public interface EntradaRepository extends JpaRepository<Entrada, Integer>{
	
	public List<Entrada> findAllByOrderByDataEntradaDesc();

	@Transactional(readOnly=true)
	@Query("SELECT coalesce(max(e.id), 0) FROM Entrada e")
	public Integer findMaxId();

	
	public List<Entrada> findAllByOrderByIdDesc();
	
	
}
