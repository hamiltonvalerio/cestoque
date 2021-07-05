package br.ipen.cestoque.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer>{

	
	@Transactional
	Colaborador findByEmail(String email);

	List<Colaborador> findAllByOrderByNomeAsc();
	
	
}
