package br.ipen.cestoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ipen.cestoque.domain.Fornecedor;

@Repository
public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer>{

	public List<Fornecedor> findByNomeContains(String nome);
	
	public List<Fornecedor> findByNomeContainingIgnoreCase(String nome);
	
	@Transactional(readOnly=true)
	@Query("SELECT f FROM Fornecedor f WHERE f.nome LIKE %:nome% ORDER BY f.nome ASC")
	public List<Fornecedor> findByNomeFormatado(@Param("nome") String nome);
}
