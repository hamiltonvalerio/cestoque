package br.ipen.cestoque.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ipen.cestoque.domain.Localizacao;
import br.ipen.cestoque.dto.LocalizacaoDTO;
import br.ipen.cestoque.dto.LocalizacaoNewDTO;
import br.ipen.cestoque.services.LocalizacaoService;


@RestController
@RequestMapping(value="/localizacoes")
public class LocalizacaoResource {

	@Autowired
	private LocalizacaoService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Localizacao> find(@PathVariable Integer id){
		Localizacao Cliente;
		Cliente = service.find(id);
		return ResponseEntity.ok().body(Cliente);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insert(@Valid @RequestBody LocalizacaoNewDTO objDto){
		Localizacao obj = service.fromDTO(objDto);
		obj = service.insert(obj); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody LocalizacaoDTO objDto, @PathVariable Integer id){
		Localizacao obj = service.fromDTO(objDto);
		obj.setId(id);
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(value="/{id}",method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<LocalizacaoDTO> > findAll(){
		List<Localizacao> list = service.findAll();
		List<LocalizacaoDTO> listDto = list.stream().map(obj -> new LocalizacaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/findAllInsumoLocalizacao", method=RequestMethod.GET)
	public ResponseEntity<List<LocalizacaoDTO>> findAllInsumoLocalizacao(){
		List<Localizacao> list = service.findAllInsumoLocalizacao();
		List<LocalizacaoDTO> listDto = list.stream().map(obj -> new LocalizacaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<LocalizacaoDTO> > findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){
		Page<Localizacao> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<LocalizacaoDTO> listDto = list.map(obj -> new LocalizacaoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
	
	
}
