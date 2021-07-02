package br.ipen.cestoque.resources;

import java.net.URI;
import java.util.Date;
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

import br.ipen.cestoque.domain.Pagina;
import br.ipen.cestoque.dto.PaginaDTO;
import br.ipen.cestoque.dto.PaginaNewDTO;
import br.ipen.cestoque.services.PaginaService;


@RestController
@RequestMapping(value="/paginas")
public class PaginaResource {

	@Autowired
	private PaginaService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Pagina> find(@PathVariable Integer id){
		Pagina Pagina;
		Pagina = service.find(id);
		return ResponseEntity.ok().body(Pagina);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PaginaNewDTO objDto){
		Pagina obj = service.fromDTO(objDto);
		obj.setDatalt(new Date(System.currentTimeMillis()));
		obj.setUsualt(obj.getNome());
		obj = service.insert(obj); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PaginaDTO objDto, @PathVariable Integer id){
		Pagina obj = service.fromDTO(objDto);
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
	
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<PaginaDTO> > findAll(){
		List<Pagina> list = service.findAll();
		List<PaginaDTO> listDto = list.stream().map(obj -> new PaginaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<PaginaDTO> > findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){
		Page<Pagina> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<PaginaDTO> listDto = list.map(obj -> new PaginaDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
}
