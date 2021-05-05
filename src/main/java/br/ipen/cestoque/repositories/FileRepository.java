package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Arquivo;

@Repository
public interface FileRepository extends JpaRepository<Arquivo, Integer>{

}
