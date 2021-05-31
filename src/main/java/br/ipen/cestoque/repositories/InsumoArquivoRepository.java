package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.InsumoArquivo;

@Repository
public interface InsumoArquivoRepository extends JpaRepository<InsumoArquivo, Integer>{

}
