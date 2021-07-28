package br.ipen.cestoque.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ipen.cestoque.domain.Orgao;
import br.ipen.cestoque.services.OrgaoService;

@RestController
@RequestMapping(value="/orgaos")
public class OrgaoResource {
	
	@Autowired
	private OrgaoService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Orgao> find(@PathVariable Integer id){
		Orgao orgao;
		orgao = service.find(id);
		return ResponseEntity.ok().body(orgao);
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Orgao objDto){
		if(objDto != null) {
			if(objDto.getNome() != "") {
				String upper = objDto.getNome().toUpperCase();
				objDto.setNome(upper);
			}
		}
		objDto = service.insert(objDto); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	} 
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<Orgao> > findAll(){
		List<Orgao> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
}
