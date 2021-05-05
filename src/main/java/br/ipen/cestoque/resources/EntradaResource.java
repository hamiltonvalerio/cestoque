package br.ipen.cestoque.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.ipen.cestoque.domain.Entrada;
import br.ipen.cestoque.dto.EntradaDTO;
import br.ipen.cestoque.resources.utils.GeraLoteRecebimentoCR;
import br.ipen.cestoque.services.EntradaService;


@RestController
@RequestMapping(value="/entradas")
public class EntradaResource {

	@Autowired
	private EntradaService service;
	
	
	@Autowired
	private GeraLoteRecebimentoCR gera;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Entrada> find(@PathVariable Integer id){
		Entrada entrada;
		entrada = service.find(id);
		return ResponseEntity.ok().body(entrada);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Entrada obj){
		System.out.println("obj: "+obj.getNumLIA());
		String loterecebimento = gera.gerarLote(obj.getDataEntrada());
		obj.setLoteRecebimento(loterecebimento);
		obj = service.insert(obj); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value="/inserarquivos",method = RequestMethod.POST)
	public ResponseEntity<Void> insertarquivos(
			@RequestParam(name="files") MultipartFile[] files,
			@RequestParam(name="identrada") String entrada) 
			
	{	
		
		return ResponseEntity.created(null).build();
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<List<EntradaDTO> > findAll(){
		List<Entrada> list = service.findAllOrderById();
		List<EntradaDTO> listDto = list.stream().map(obj -> new EntradaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}
	
	
}
