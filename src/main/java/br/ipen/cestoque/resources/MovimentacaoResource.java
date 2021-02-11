package br.ipen.cestoque.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ipen.cestoque.domain.Movimentacao;
import br.ipen.cestoque.services.MovimentacaoService;


@RestController
@RequestMapping(value="/movimentacoes")
public class MovimentacaoResource {

	@Autowired
	private MovimentacaoService service;
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Movimentacao>> findAll(){
		List<Movimentacao> list = service.findAll();
		return ResponseEntity.ok().body(list);
		
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Movimentacao obj){
		
		System.out.println("obj: "+obj);
		
		
		obj = service.insert(obj); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
