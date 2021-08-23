package br.ipen.cestoque.resources;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

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
import br.ipen.cestoque.dto.LocalizacaoOrdenadaDTO;
import br.ipen.cestoque.services.LocalizacaoService;

@RestController
@RequestMapping(value = "/localizacoes")
public class LocalizacaoResource {

	@Autowired
	private LocalizacaoService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Localizacao> find(@PathVariable String id) {
		Localizacao localizacao;
		localizacao = service.find(Integer.parseInt(id));
		return ResponseEntity.ok().body(localizacao);
	}

	@RequestMapping(value = "/findbyid", method = RequestMethod.GET)
	public ResponseEntity<Localizacao> findById(@RequestParam(value = "localizacao_id") String localizacao_id) {
		Localizacao localizacao;
		localizacao = service.find(Integer.parseInt(localizacao_id));
		return ResponseEntity.ok().body(localizacao);
	}
	
	@RequestMapping(value = "/findAllLocalizacoesFilhasByLocalizacaoPai", method = RequestMethod.GET)
	public ResponseEntity<List<Localizacao>> findAllLocalizacoesFilhasByLocalizacaoPai(@RequestParam(value = "localizacao_id") String localizacao_id) {
		List<Localizacao> list = service.findAllLocalizacoesFilhasByLocalizacaoPai(Integer.parseInt(localizacao_id));
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> insert(@Valid @RequestBody Localizacao objDto) {
		objDto = service.insert(objDto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objDto.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> update(@Valid @RequestBody Localizacao objDto) {
		objDto = service.update(objDto);
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	/*@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<LocalizacaoDTO>> findAll() {
		List<Localizacao> list = service.findAll();
		List<LocalizacaoDTO> listDto = list.stream().map(obj -> new LocalizacaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}*/
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Localizacao>> findAll() {
		List<Localizacao> list = service.findAll();
		//List<LocalizacaoDTO> listDto = list.stream().map(obj -> new LocalizacaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/findAllOrdenado", method = RequestMethod.GET)
	public ResponseEntity<List<Localizacao>> findAllOrdenado() {
		List<Localizacao> list = service.findAll();
		List<LocalizacaoOrdenadaDTO> listaOrdenada = new ArrayList<LocalizacaoOrdenadaDTO>();
		for (Localizacao l : list) {
			if(l.getObjlocalizacaofilha() == null) {
				LocalizacaoOrdenadaDTO lord = new LocalizacaoOrdenadaDTO();
				lord.setLocalizacao(l);
				for (Localizacao lo : list) {
					if(lo.getObjlocalizacaofilha() != null) {
						if(lo.getObjlocalizacaofilha().getId() == l.getId()) {
							lord.getLocalizacoesfilhas().add(lo);
						}
					}
				}
			listaOrdenada.add(lord);
			
			}
		}
		
		return ResponseEntity.ok().body(list);
	}
	

	@RequestMapping(value = "/findAllOrdenadoFilhas", method = RequestMethod.GET)
	public ResponseEntity<List<LocalizacaoOrdenadaDTO>> findAllOrdenadoFilhas() {
		List<Localizacao> list = service.findAll();
		List<Localizacao> listfilhas = new ArrayList<>();
		List<LocalizacaoOrdenadaDTO> listPai = new ArrayList<>();
		for (Localizacao l : list) {
			if(l.getLocalizacaofilha() != null && l.getLocalizacaofilha() == true) {
				listfilhas.add(l);
			}else {
				LocalizacaoOrdenadaDTO lo = new LocalizacaoOrdenadaDTO();
				lo.setLocalizacao(l);
				listPai.add(lo);
			}
		}	
		
		for (LocalizacaoOrdenadaDTO lp : listPai) {
			Integer pai = lp.getLocalizacao().getId();
			List<Localizacao> lfilhas = new ArrayList<>();
			lp.setLocalizacoesfilhas(listaTodosFilhos(pai, listfilhas));
			if(!lp.getLocalizacoesfilhas().isEmpty()) {
				for(Localizacao lof : lp.getLocalizacoesfilhas()) {
					lfilhas.addAll(listaTodosFilhos(lof.getId(), listfilhas));
				}
				lp.getLocalizacoesfilhas().addAll(lfilhas);
			}
		}
		
		return ResponseEntity.ok().body(listPai);

	}
	
	/*para ser usado recursivamente...massss não to usando*/
	public List<Localizacao> listaTodosFilhos(Integer pai, List<Localizacao> filhas){
		List<Localizacao> lks = new ArrayList<>();
		for(Localizacao lf : filhas) {
			if(lf.getObjlocalizacaofilha().getId() == pai) {	
				lks.add(lf);
			}
		}
		return lks;
	}
	
	

	@RequestMapping(value = "/findAllInsumoLocalizacao", method = RequestMethod.GET)
	public ResponseEntity<List<Localizacao>> findAllInsumoLocalizacao() {
		List<Localizacao> list = service.findAllInsumoLocalizacao();
		//List<LocalizacaoDTO> listDto = list.stream().map(obj -> new LocalizacaoDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(list);
	}
	
	@RequestMapping(value = "/findByAprovacaoTrue", method = RequestMethod.GET)
	public ResponseEntity<List<Localizacao>> findByAprovacaoTrue() {
		List<Localizacao> list = service.findByAprovacaoTrue();
		return ResponseEntity.ok().body(list);
	}
	

	@RequestMapping(value = "/page", method = RequestMethod.GET)
	public ResponseEntity<Page<LocalizacaoDTO>> findPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "ASC") String direction) {
		Page<Localizacao> list = service.findPage(page, linesPerPage, orderBy, direction);
		Page<LocalizacaoDTO> listDto = list.map(obj -> new LocalizacaoDTO(obj));
		return ResponseEntity.ok().body(listDto);
	}
	
	@RequestMapping(value = "/validaAlmoxarifadoPrincipal", method = RequestMethod.GET)
	public Boolean validaAlmoxarifadoPrincipal() {
		return service.validaAlmoxarifadoPrincipal();
	}
	
	@RequestMapping(value = "/findAlmoxPrincipal", method = RequestMethod.GET)
	public ResponseEntity<Localizacao> findAlmoxPrincipal() {
		Localizacao localizacao;
		localizacao = service.findAlmoxPrincipal();
		return ResponseEntity.ok().body(localizacao);
	}

}
