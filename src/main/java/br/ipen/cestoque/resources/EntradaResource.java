package br.ipen.cestoque.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ipen.cestoque.domain.Entrada;
import br.ipen.cestoque.dto.EntradaDTO;
import br.ipen.cestoque.services.EntradaService;


@RestController
@RequestMapping(value="/entradas")
public class EntradaResource {

	@Autowired
	private EntradaService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Entrada> find(@PathVariable Integer id){
		Entrada entrada;
		entrada = service.find(id);
		return ResponseEntity.ok().body(entrada);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Entrada obj){
		System.out.println("obj: "+obj.getNumLIA());
		obj = service.insert(obj); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EntradaDTO> > findAll(){
		List<Entrada> list = service.findAll();
		/*
		 * for (Entrada e : list) { System.out.println(e.getNumRequisicao()); }
		 */
		List<EntradaDTO> listDto = list.stream().map(obj -> new EntradaDTO(obj)).collect(Collectors.toList());
		/*
		 * for (EntradaDTO eDTO : listDto) {
		 * System.out.println("AQUI: "+eDTO.getNumRequisicao()); }
		 */
		return ResponseEntity.ok().body(listDto);
	}
	
	
}
