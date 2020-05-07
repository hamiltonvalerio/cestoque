package br.ipen.cestoque.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ipen.cestoque.domain.Produto;
import br.ipen.cestoque.services.ProdutoService;
import br.ipen.cestoque.services.exception.ObjectNotFoundException;


@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id){
		Produto produto;
		produto = service.find(id);
		return ResponseEntity.ok().body(produto);
	}
	
	
}
