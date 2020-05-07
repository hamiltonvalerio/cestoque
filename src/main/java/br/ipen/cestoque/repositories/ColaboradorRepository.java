package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Colaborador;

@Repository
public interface ColaboradorRepository extends JpaRepository<Colaborador, Integer>{

}