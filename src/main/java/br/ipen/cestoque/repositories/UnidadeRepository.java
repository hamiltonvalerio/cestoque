package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Unidade;

@Repository
public interface UnidadeRepository extends JpaRepository<Unidade, Integer>{

}
