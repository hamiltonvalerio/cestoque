package br.ipen.cestoque.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.dto.InsumoDTO;
import br.ipen.cestoque.dto.InsumoNewDTO;
import br.ipen.cestoque.resources.utils.URL;
import br.ipen.cestoque.services.InsumoService;


@RestController
@RequestMapping(value="/insumos")
public class InsumoResource {

	@Autowired
	private InsumoService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Insumo> find(@PathVariable Integer id){
		Insumo insumo;
		insumo = service.find(id);
		return ResponseEntity.ok().body(insumo);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<InsumoDTO> > findAll(){
		List<Insumo> list = service.findAll();
		List<InsumoDTO> listDto = list.stream().map(obj -> new InsumoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	/*@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<InsumoDTO> > findPage(
			@RequestParam(value = "nome", defaultValue = "0") String nome, 
			@RequestParam(value = "categorias", defaultValue = "0") String categorias, 
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){
	    List<Integer> ids = URL.decodeIntList(categorias);
	    String nomeDecoded = URL.decodeParam(nome);
		Page<Insumo> list = service.search(nomeDecoded, ids, page, linesPerPage, orderBy, direction);
		Page<InsumoDTO> listDto = list.map(obj -> new InsumoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}*/
	
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<InsumoDTO> > findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "30") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){

		Page<Insumo> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<InsumoDTO> listDto = list.map(obj -> new InsumoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody InsumoNewDTO objDto){
		Insumo obj = service.fromDTO(objDto);
		obj = service.insert(obj); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
}
