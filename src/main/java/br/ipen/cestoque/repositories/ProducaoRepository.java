package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Producao;

@Repository
public interface ProducaoRepository extends JpaRepository<Producao, Integer>{

}
