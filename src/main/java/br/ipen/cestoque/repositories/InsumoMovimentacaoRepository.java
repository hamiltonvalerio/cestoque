package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.InsumoMovimentacao;

@Repository
public interface InsumoMovimentacaoRepository extends JpaRepository<InsumoMovimentacao, Integer>{

		

}
