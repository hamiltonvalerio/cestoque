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
import br.ipen.cestoque.domain.InsumoLocalizacao;
import br.ipen.cestoque.dto.InsumoDTO;
import br.ipen.cestoque.dto.InsumoNewDTO;
import br.ipen.cestoque.repositories.InsumoLocalizacaoRepository;
import br.ipen.cestoque.services.InsumoService;


@RestController
@RequestMapping(value="/insumos")
public class InsumoResource {

	@Autowired
	private InsumoService service;
	
	@Autowired
	private InsumoLocalizacaoRepository ilrepo;
	
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
	
	@RequestMapping(value="/totalcadastrados",method=RequestMethod.GET)
	public ResponseEntity<Long> findTotalCadastrados(){
		
		Long total = service.findTotalCadastrados();

		return ResponseEntity.ok().body(total);
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
		System.out.println(list.getSize());
		Page<InsumoDTO> listDto = list.map(obj -> new InsumoDTO(obj));
		System.out.println(listDto.getSize());
		return ResponseEntity.ok().body(listDto);
	}
	
	/*@RequestMapping(value="/buscaporlocalizacao2", method=RequestMethod.GET)
	public ResponseEntity<Page<InsumoDTO> > findByLocalizacao2(
			@RequestParam(value = "localizacao_id") String localizacao_id,
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "30") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){

		Page<Insumo> list = service.findByLocalizacao(Integer.parseInt(localizacao_id), page, linesPerPage, orderBy, direction);
		//System.out.println(list.getSize());
		Page<InsumoDTO> listDto = list.map(obj -> new InsumoDTO(obj));
		//System.out.println(listDto.getSize());
		return ResponseEntity.ok().body(listDto);
		//return ResponseEntity.ok().body(list);
	
	}*/
	
	@RequestMapping(value="/buscaporlocalizacao", method=RequestMethod.GET)
	public ResponseEntity<Page<Insumo> > findByLocalizacao(
			@RequestParam(value = "localizacao_id") String localizacao_id,
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "30") Integer linesPerPage, 
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy, 
			@RequestParam(value = "direction", defaultValue = "ASC") String direction
			){

		Page<Insumo> list = service.findByLocalizacao(Integer.parseInt(localizacao_id), page, linesPerPage, orderBy, direction);
		//System.out.println(list.getSize());
		/*
		 * for (Insumo insumo : list) { for (InsumoLocalizacao il :
		 * insumo.getLocalizacoes()) {
		 * if(il.getLocalizacao().getId().equals(Integer.parseInt(localizacao_id))) {
		 * insumo.setQuantidade(il.getQuantidade());
		 * insumo.setQuantidademinima(il.getQuantidademinima());
		 * insumo.setCodlocalizacaoIE(il.getLocalizacao().getId());
		 * //insumo.setInsumoLocalizacao(il);
		 * //insumo.setInsumoLocalizacaoPK(il.getId()); } } }
		 */
		
		//Page<InsumoDTO> listDto = list.map(obj -> new InsumoDTO(obj));
		//System.out.println(listDto.getSize());
		return ResponseEntity.ok().body(list);
		//return ResponseEntity.ok().body(list);
	
	}
	
	@RequestMapping(value="/buscainsumolocalizacaoporlocalizacao", method=RequestMethod.GET)
	public ResponseEntity<Page<InsumoLocalizacao> > findInsumoLocalizacaoByLocalizacao(
			@RequestParam(value = "localizacao_id") String localizacao_id,
			@RequestParam(value = "page", defaultValue = "0") Integer page, 
			@RequestParam(value = "linesPerPage", defaultValue = "30") Integer linesPerPage){

		
		Page<InsumoLocalizacao> list = service.findInsumoLocalizacaoByLocalizacao(Integer.parseInt(localizacao_id), page, linesPerPage);

		return ResponseEntity.ok().body(list);
		
	
	}
	
		
	
	@RequestMapping(value="/buscaporlocalizacaonopage", method=RequestMethod.GET)
	public ResponseEntity<List<InsumoLocalizacao> > buscaporlocalizacaonopage(
			@RequestParam(value = "localizacao_id") String localizacao_id){
		
		List<InsumoLocalizacao> ils = service.buscatodosporlocalizacaonopage(Integer.parseInt(localizacao_id)); 
		
		
		//List<Insumo> list = service.buscaporlocalizacaonopage(Integer.parseInt(localizacao_id));
		
		/*List<Insumo> list = new ArrayList<>();
		
		for(InsumoLocalizacao il : ils) {
			Insumo i = new Insumo();
			
			list.add(new Insumo())
		}*/
		
		
		/*for (Insumo insumo : list) {
			for (InsumoLocalizacao il : insumo.getLocalizacoes()) {
				if(il.getLocalizacao().getId().equals(Integer.parseInt(localizacao_id))) {
					insumo.setQuantidade(il.getQuantidade());
					insumo.setNomecodalmox(il.getInsumo().getNome()+" - "+il.getInsumo().getCodigoalmox());
					
				}
			}
		}*/
		return ResponseEntity.ok().body(ils);
	}
	
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody InsumoNewDTO objDto){
		Insumo obj = service.fromDTO(objDto);
		obj = service.insert(obj); 
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@RequestMapping(value = "/updateQuantidadeMinima", method = RequestMethod.POST)
	public ResponseEntity<Void> updateQuantidadeMinima(
			@RequestParam(value = "insumolocalizacao_id") String insumolocalizacao_id,
			@RequestParam(value = "quantidademinima") String quantidademinima){
		ilrepo.update(Integer.parseInt(insumolocalizacao_id),Double.parseDouble(quantidademinima));
		return ResponseEntity.noContent().build();
	}
	
}
