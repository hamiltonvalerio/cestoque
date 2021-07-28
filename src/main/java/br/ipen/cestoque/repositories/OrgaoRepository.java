package br.ipen.cestoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Orgao;

@Repository
public interface OrgaoRepository extends JpaRepository<Orgao, Integer>{

	List<Orgao> findAllByOrderByNomeAsc();

}
