package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Movimentacao;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, Integer>{

	
	
}
