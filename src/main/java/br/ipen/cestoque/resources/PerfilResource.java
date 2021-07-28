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

import br.ipen.cestoque.domain.Perfil;
import br.ipen.cestoque.dto.PerfilDTO;
import br.ipen.cestoque.dto.PerfilNewDTO;
import br.ipen.cestoque.services.PerfilService;


@RestController
@RequestMapping(value="/perfis")
public class PerfilResource {

	@Autowired
	private PerfilService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Perfil> find(@PathVariable Integer id){
		Perfil perfil;
		perfil = service.find(id);
		return ResponseEntity.ok().body(perfil);
	}
	
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody PerfilNewDTO objDto){
		Perfil obj = service.fromDTO(objDto);
		if(obj != null) {
			if(obj.getNome() != "") {
				String upper = obj.getNome().toUpperCase();
				obj.setNome(upper);
			}
		}
		obj = service.insert(obj); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody PerfilDTO objDto, @PathVariable Integer id){
		Perfil obj = service.fromDTO(objDto);
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
	public ResponseEntity<List<PerfilDTO> > findAll(){
		List<Perfil> list = service.findAll();
		List<PerfilDTO> listDto = list.stream().map(obj -> new PerfilDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<PerfilDTO> > findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){
		Page<Perfil> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<PerfilDTO> listDto = list.map(obj -> new PerfilDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/buscaperfispornomepagina",method=RequestMethod.GET)
	public ResponseEntity<List<Perfil>> find(@RequestParam(value="value") String nomepagina){
		List<Perfil> list = service.findAllByNomePagina(nomepagina);
		return ResponseEntity.ok().body(list);
	}
	
	
}
