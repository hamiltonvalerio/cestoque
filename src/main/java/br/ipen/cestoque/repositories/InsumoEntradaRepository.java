package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.InsumoEntrada;

@Repository
public interface InsumoEntradaRepository extends JpaRepository<InsumoEntrada, Integer>{

}
