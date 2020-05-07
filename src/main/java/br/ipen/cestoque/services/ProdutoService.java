package br.ipen.cestoque.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.domain.Produto;
import br.ipen.cestoque.repositories.ProdutoRepository;
import br.ipen.cestoque.services.exception.ObjectNotFoundException;


@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
		
	public Produto find(Integer id) throws ObjectNotFoundException {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
}
