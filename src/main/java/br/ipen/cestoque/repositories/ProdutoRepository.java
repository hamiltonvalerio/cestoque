package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Insumo;

@Repository
public interface ProdutoRepository extends JpaRepository<Insumo, Integer>{

}
