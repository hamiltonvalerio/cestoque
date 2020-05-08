package br.ipen.cestoque.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ipen.cestoque.domain.Colaborador;
import br.ipen.cestoque.services.ClienteService;


@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Colaborador> find(@PathVariable Integer id){
		Colaborador Cliente;
		Cliente = service.find(id);
		return ResponseEntity.ok().body(Cliente);
	}
	
	
}
