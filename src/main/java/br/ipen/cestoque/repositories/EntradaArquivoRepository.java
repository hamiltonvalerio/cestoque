package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.EntradaArquivo;

@Repository
public interface EntradaArquivoRepository extends JpaRepository<EntradaArquivo, Integer>{

}
