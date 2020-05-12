package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Localizacao;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer>{

}
