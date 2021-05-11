package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.InsumoAjuste;

@Repository
public interface InsumoAjusteRepository extends JpaRepository<InsumoAjuste, Integer>{

}
