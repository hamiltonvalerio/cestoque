package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.InsumoSaida;

@Repository
public interface InsumoSaidaRepository extends JpaRepository<InsumoSaida, Integer>{

}
