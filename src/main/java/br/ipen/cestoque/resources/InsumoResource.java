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

import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.InsumoEntrada;
import br.ipen.cestoque.domain.InsumoLocalizacao;
import br.ipen.cestoque.dto.InsumoDTO;
import br.ipen.cestoque.dto.InsumoEntradaDTO;
import br.ipen.cestoque.dto.InsumoNewDTO;
import br.ipen.cestoque.repositories.InsumoLocalizacaoRepository;
import br.ipen.cestoque.services.InsumoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Insumos")
@RestController
@RequestMapping(value = "/insumos")
public class InsumoResource {

	@Autowired
	private InsumoService service;

	@Autowired
	private InsumoLocalizacaoRepository ilrepo;

	

	@ApiOperation(value = "Retorna insumo por ID")
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Insumo> find(@PathVariable String id) {
		Insumo insumo;
		insumo = service.find(Integer.parseInt(id));
		return ResponseEntity.ok().body(insumo);
	}

	@ApiOperation(value = "Retorna insumo por ID")
	@RequestMapping(value = "/findbyid", method = RequestMethod.GET)
	public ResponseEntity<Insumo> findById(@RequestParam(value = "insumo_id") String insumo_id) {
		Insumo insumo;
		insumo = service.find(Integer.parseInt(insumo_id));
		return ResponseEntity.ok().body(insumo);
	}

	@ApiOperation(value = "Busca todos os insumos")
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<InsumoDTO>> findAll() {
		List<Insumo> list = service.findAll();
		List<InsumoDTO> listDto = list.stream().map(obj -> new InsumoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	@ApiOperation(value = "Retorna Total de insumos cadastrados")
	@RequestMapping(value = "/totalcadastrados", method = RequestMethod.GET)
	public ResponseEntity<Long> findTotalCadastrados() {

		Long total = service.findTotalCadastrados();

		return ResponseEntity.ok().body(total);
	}

	/*
	 * @RequestMapping(value="/page", method=RequestMethod.GET) public
	 * ResponseEntity<Page<InsumoDTO> > findPage(
	 * 
	 * @RequestParam(value = "nome", defaultValue = "0") String nome,
	 * 
	 * @RequestParam(value = "categorias", defaultValue = "0") String categorias,
	 * 
	 * @RequestParam(value = "page", defaultValue = "0") Integer page,
	 * 
	 * @RequestParam(value = "linesPerPage", defaultValue = "24") Integer
	 * linesPerPage,
	 * 
	 * @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
	 * 
	 * @RequestParam(value = "direction", defaultValue = "ASC") String direction ){
	 * List<Integer> ids = URL.decodeIntList(categorias); String nomeDecoded =
	 * URL.decodeParam(nome); Page<Insumo> list = service.search(nomeDecoded, ids,
	 * page, linesPerPage, orderBy, direction); Page<InsumoDTO> listDto =
	 * list.map(obj -> new InsumoDTO(obj)); return
	 * ResponseEntity.ok().body(listDto); }
	 */

	@ApiOperation(value = "Retorna Insumos paginados e ordenados")
	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<InsumoDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "30") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<Insumo> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<InsumoDTO> listDto = list.map(obj -> new InsumoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}

	/*
	 * @RequestMapping(value="/buscaporlocalizacao2", method=RequestMethod.GET)
	 * public ResponseEntity<Page<InsumoDTO> > findByLocalizacao2(
	 * 
	 * @RequestParam(value = "localizacao_id") String localizacao_id,
	 * 
	 * @RequestParam(value = "page", defaultValue = "0") Integer page,
	 * 
	 * @RequestParam(value = "linesPerPage", defaultValue = "30") Integer
	 * linesPerPage,
	 * 
	 * @RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
	 * 
	 * @RequestParam(value = "direction", defaultValue = "ASC") String direction ){
	 * 
	 * Page<Insumo> list =
	 * service.findByLocalizacao(Integer.parseInt(localizacao_id), page,
	 * linesPerPage, orderBy, direction); //System.out.println(list.getSize());
	 * Page<InsumoDTO> listDto = list.map(obj -> new InsumoDTO(obj));
	 * //System.out.println(listDto.getSize()); return
	 * ResponseEntity.ok().body(listDto); //return ResponseEntity.ok().body(list);
	 * 
	 * }
	 */

	@ApiOperation(value = "Busca insumos por Localização")
	@RequestMapping(value = "/buscaporlocalizacao", method = RequestMethod.GET)
	public ResponseEntity<Page<Insumo>> findByLocalizacao(@RequestParam(value = "localizacao_id") String localizacao_id,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "30") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {

		Page<Insumo> list = service.findByLocalizacao(Integer.parseInt(localizacao_id), page, linesPerPage, orderBy,
				direction);
		// System.out.println(list.getSize());
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

		// Page<InsumoDTO> listDto = list.map(obj -> new InsumoDTO(obj));
		// System.out.println(listDto.getSize());
		return ResponseEntity.ok().body(list);
		// return ResponseEntity.ok().body(list);

	}

	@RequestMapping(value = "/buscainsumolocalizacaoporlocalizacao", method = RequestMethod.GET)
	public ResponseEntity<Page<InsumoLocalizacao>> findInsumoLocalizacaoByLocalizacao(
			@RequestParam(value = "localizacao_id") String localizacao_id,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "30") Integer linesPerPage) {

		Page<InsumoLocalizacao> list = service.findInsumoLocalizacaoByLocalizacao(Integer.parseInt(localizacao_id),
				page, linesPerPage);

		for (InsumoLocalizacao insumoLocalizacao : list) {
			insumoLocalizacao.setCodigoalmoxarifado(insumoLocalizacao.getInsumo().getCodigoalmox());
		}

		return ResponseEntity.ok().body(list);

	}

	@RequestMapping(value = "/buscainsumolocalizacaoporlocalizacaoSemVazio", method = RequestMethod.GET)
	public ResponseEntity<Page<InsumoLocalizacao>> findInsumoLocalizacaoByLocalizacaoSemVazio(
			@RequestParam(value = "localizacao_id") String localizacao_id,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "30") Integer linesPerPage) {

		Page<InsumoLocalizacao> list = service
				.findInsumoLocalizacaoByLocalizacaoSemVazio(Integer.parseInt(localizacao_id), page, linesPerPage);

		
		//list.stream().forEach(e -> e.setCodigoalmoxarifado(e.getInsumo().getCodigoalmox()));
		
		for (InsumoLocalizacao insumoLocalizacao : list) {
			insumoLocalizacao.setCodigoalmoxarifado(insumoLocalizacao.getInsumo().getCodigoalmox());
		}

		return ResponseEntity.ok().body(list);

	}

	@RequestMapping(value = "/buscaporlocalizacaonopage", method = RequestMethod.GET)
	public ResponseEntity<List<InsumoLocalizacao>> buscaporlocalizacaonopage(
			@RequestParam(value = "localizacao_id") String localizacao_id) {

		List<InsumoLocalizacao> ils = service.buscatodosporlocalizacaonopage(Integer.parseInt(localizacao_id));

		for (InsumoLocalizacao il : ils) {
			il.setNomedoinsumo(il.getInsumo().getNome());
		}

		return ResponseEntity.ok().body(ils);
	}
	
	@RequestMapping(value = "/buscaTodosPorLocalizacao", method = RequestMethod.GET)
	public ResponseEntity<Page<InsumoLocalizacao>> buscaTodosPorLocalizacao(
			@RequestParam(value = "localizacao_id") String localizacao_id,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "30") Integer linesPerPage) {

		Page<InsumoLocalizacao> list = service
				.findInsumoLocalizacaoByLocalizacao(Integer.parseInt(localizacao_id), page, linesPerPage);

		for (InsumoLocalizacao insumoLocalizacao : list) {
			insumoLocalizacao.setCodigoalmoxarifado(insumoLocalizacao.getInsumo().getCodigoalmox());
		}

		return ResponseEntity.ok().body(list);

	}

	/*@ApiOperation(value = "Insere novo insumo")
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insert(@RequestBody InsumoNewDTO objDto) {
		Insumo obj = service.fromDTO(objDto);
		if(obj.getEssencial() == null) {
			obj.setEssencial(false);
		}
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}*/
	
	@ApiOperation(value = "Insere novo insumo")
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insert(@RequestBody Insumo obj) {
		//Insumo obj = service.fromDTO(objDto);
		if(obj.getEssencial() == null) {
			obj.setEssencial(false);
		}
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@ApiOperation(value = "Atualiza a quantidade mínima aceitável por insumo")
	@RequestMapping(value = "/updateQuantidadeMinima", method = RequestMethod.POST)
	public ResponseEntity<Void> updateQuantidadeMinima(
			@RequestParam(value = "insumolocalizacao_id") String insumolocalizacao_id,
			@RequestParam(value = "quantidademinima") String quantidademinima) {
		ilrepo.update(Integer.parseInt(insumolocalizacao_id), Double.parseDouble(quantidademinima));
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> update(@Valid @RequestBody InsumoDTO objDto) {
		Insumo obj = service.fromDTO(objDto);
		
		obj = service.update(obj);
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Retorna LotesLEI cadastrados")
	@RequestMapping(value = "/findLotesLEIInsumosLocalizacoes", method = RequestMethod.GET)
	public ResponseEntity<List<InsumoLocalizacao>> findLotesLEIInsumosLocalizacoes() {
		List<InsumoLocalizacao> lista = service.findLotesLEIInsumosLocalizacoes();
		return ResponseEntity.ok().body(lista);
	}

	@RequestMapping(value = "/findInsumosLocalizacoesByLoteLEI", method = RequestMethod.GET)
	public ResponseEntity<List<InsumoLocalizacao>> findInsumosLocalizacoesByLoteLEI(
			@RequestParam(value = "loteLEI") String loteLEI) {

		List<InsumoLocalizacao> ils = service.findInsumosLocalizacoesByLoteLEI(loteLEI);

		for (InsumoLocalizacao il : ils) {
			il.setNomedoinsumo(il.getInsumo().getNome());
		}

		return ResponseEntity.ok().body(ils);
	}

	@RequestMapping(value = "/findInsumoEntradaByLoteLEI", method = RequestMethod.GET)
	public ResponseEntity<InsumoEntradaDTO> findInsumoEntradaByLoteLEI(@RequestParam(value = "loteLEI") String loteLEI) {

		InsumoEntrada ie = service.findInsumoEntradaByLoteLEI(loteLEI);
		
		return ResponseEntity.ok().body(new InsumoEntradaDTO(ie));
	}
	
	@RequestMapping(value = "/findInsumoLocalizacaoByNome", method = RequestMethod.GET)
	public ResponseEntity<List<InsumoLocalizacao>> findInsumoLocalizacaoByNome(
			@RequestParam(value = "localizacao_id") String localizacao_id,
			@RequestParam(value = "nome") String nome) {

		List<InsumoLocalizacao> list = service
				.findInsumoLocalizacaoByNome(Integer.parseInt(localizacao_id), nome);
		for (InsumoLocalizacao insumoLocalizacao : list) {
			insumoLocalizacao.setCodigoalmoxarifado(insumoLocalizacao.getInsumo().getCodigoalmox());
		}
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/findInsumoLocalizacaoByCodalmox", method = RequestMethod.GET)
	public ResponseEntity<List<InsumoLocalizacao>> findInsumoLocalizacaoByCodalmox(
			@RequestParam(value = "localizacao_id") String localizacao_id,
			@RequestParam(value = "codalmox") String codalmox) {

		List<InsumoLocalizacao> list = service
				.findInsumoLocalizacaoByCodalmox(Integer.parseInt(localizacao_id), codalmox);
		for (InsumoLocalizacao insumoLocalizacao : list) {
			insumoLocalizacao.setCodigoalmoxarifado(insumoLocalizacao.getInsumo().getCodigoalmox());
		}
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/findInsumoLocalizacaoByLotelei", method = RequestMethod.GET)
	public ResponseEntity<List<InsumoLocalizacao>> findInsumoLocalizacaoByLotelei(
			@RequestParam(value = "localizacao_id") String localizacao_id,
			@RequestParam(value = "lotelei") String lotelei) {

		List<InsumoLocalizacao> list = service
				.findInsumoLocalizacaoByLotelei(Integer.parseInt(localizacao_id), lotelei);
		for (InsumoLocalizacao insumoLocalizacao : list) {
			insumoLocalizacao.setCodigoalmoxarifado(insumoLocalizacao.getInsumo().getCodigoalmox());
		}
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/findInsumoLocalizacaoBySublotelei", method = RequestMethod.GET)
	public ResponseEntity<List<InsumoLocalizacao>> findInsumoLocalizacaoBySublotelei(
			@RequestParam(value = "localizacao_id") String localizacao_id,
			@RequestParam(value = "sublotelei") String sublotelei) {

		List<InsumoLocalizacao> list = service
				.findInsumoLocalizacaoBySublotelei(Integer.parseInt(localizacao_id), sublotelei);
		for (InsumoLocalizacao insumoLocalizacao : list) {
			insumoLocalizacao.setCodigoalmoxarifado(insumoLocalizacao.getInsumo().getCodigoalmox());
		}
		return ResponseEntity.ok().body(list);
	}


}
