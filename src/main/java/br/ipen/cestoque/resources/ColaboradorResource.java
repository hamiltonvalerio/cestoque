package br.ipen.cestoque.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ipen.cestoque.domain.Colaborador;
import br.ipen.cestoque.dto.ColaboradorDTO;
import br.ipen.cestoque.dto.ColaboradorNewDTO;
import br.ipen.cestoque.services.ColaboradorService;


@RestController
@RequestMapping(value="/colaboradores")
public class ColaboradorResource {

	@Autowired
	private ColaboradorService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Colaborador> find(@PathVariable Integer id){
		Colaborador Cliente;
		Cliente = service.find(id);
		return ResponseEntity.ok().body(Cliente);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody ColaboradorNewDTO objDto){
		Colaborador obj = service.fromDTO(objDto);
		obj = service.insert(obj); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ColaboradorDTO objDto, @PathVariable Integer id){
		Colaborador obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<ColaboradorDTO> > findAll(){
		List<Colaborador> list = service.findAll();
		List<ColaboradorDTO> listDto = list.stream().map(obj -> new ColaboradorDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<ColaboradorDTO> > findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){
		Page<Colaborador> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<ColaboradorDTO> listDto = list.map(obj -> new ColaboradorDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
}
