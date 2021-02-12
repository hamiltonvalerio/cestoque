package br.ipen.cestoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Movimentacao;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer>{

	@Query("SELECT to_char(mov.datamovimentacao, 'DD/MM/YYYY') FROM Movimentacao mov ")
	List<String> findString();

	@Query("SELECT mov FROM Movimentacao mov ")
	List<Movimentacao> findTodos();
	
	/*@Transactional
	@Query("SELECT mov FROM Movimentacao mov ")
	public List<Movimentacao> findTeste();*/
	
}
