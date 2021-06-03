package br.ipen.cestoque.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ipen.cestoque.domain.InsumoMovimentacao;
import br.ipen.cestoque.domain.Movimentacao;
import br.ipen.cestoque.dto.MovimentacaoDTO;
import br.ipen.cestoque.services.MovimentacaoService;


@RestController
@RequestMapping(value="/movimentacoes")
public class MovimentacaoResource {

	@Autowired
	private MovimentacaoService service;
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Movimentacao>> findAll(){
		
		List<Movimentacao> list = service.findAll();
		
		//List<MovimentacaoDTO> listaDTO =  MovimentacaoMapper.INSTANCE.tolistmovimentacaoDTO(list);
		
		return ResponseEntity.ok().body(list);
		
	}
	
	
	/*@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Page<MovimentacaoDTO> > findAll(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "30") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "datamovimentacao") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){

		Page<Movimentacao> list = service.findPage(page, linesPerPage, orderBy, direction);
		//System.out.println(list.getSize());
		
		Page<MovimentacaoDTO> listDto = list.map(obj -> new MovimentacaoDTO(obj));
		//System.out.println(listDto.getSize());
		return ResponseEntity.ok().body(listDto);
	}*/
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody Movimentacao obj){
		obj.getItens().removeIf(im -> im.getQuantidadeMovimentada() == 0);
		if(!obj.getItens().isEmpty()) {
			obj = service.insert(obj); 
			URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
			return ResponseEntity.created(uri).build();
		}else {
			return ResponseEntity.created(null).build();
		}
		
	}
	
	@RequestMapping(value="/page", method=RequestMethod.GET)
	public ResponseEntity<Page<Movimentacao> > findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "30") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "datamovimentacao") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){

		Page<Movimentacao> list = service.findPage(page, linesPerPage, orderBy, direction);
		//System.out.println(list.getSize());
		//Page<InsumoDTO> listDto = list.map(obj -> new InsumoDTO(obj));
		//System.out.println(listDto.getSize());
		return ResponseEntity.ok().body(list);
	}
	
}
