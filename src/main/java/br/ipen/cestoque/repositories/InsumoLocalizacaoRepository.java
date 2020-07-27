package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.InsumoLocalizacao;

@Repository
public interface InsumoLocalizacaoRepository extends JpaRepository<InsumoLocalizacao, Integer>{

}
