package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Categoria;
import br.ipen.cestoque.domain.ItemProduto;

@Repository
public interface ItemProdutoRepository extends JpaRepository<ItemProduto, Integer>{

}
