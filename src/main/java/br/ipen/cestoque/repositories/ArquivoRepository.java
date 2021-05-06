package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Arquivo;

@Repository
public interface ArquivoRepository extends JpaRepository<Arquivo, Integer>{

}
