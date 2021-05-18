package br.ipen.cestoque.resources;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ipen.cestoque.domain.InsumoAjuste;
import br.ipen.cestoque.services.EntradaService;
import br.ipen.cestoque.services.InsumoAjusteService;

@RestController
@RequestMapping(value = "/ajusteestoque")
public class InsumoAjusteResource {

	@Autowired
	private EntradaService entradaService;
	
	@Autowired
	private InsumoAjusteService insumoAjusteService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> insert(@Valid @RequestBody InsumoAjuste insumoAjuste){
		
		return ResponseEntity.ok().body(insumoAjusteService.insert(insumoAjuste).getId().toString());
	
	}
	
	@RequestMapping(value="/buscaAjustesPorDataELocalizacao", method=RequestMethod.GET)
	public ResponseEntity<List<InsumoAjuste> > findAjustesByDataELocalizacao(
			@RequestParam(value = "localizacao_id") String localizacao_id,
			@RequestParam(value = "dataAjuste") Date dataAjuste){
		
		List<InsumoAjuste> list = insumoAjusteService.findAjustesByDataELocalizacao(Integer.parseInt(localizacao_id), dataAjuste);

		return ResponseEntity.ok().body(list);
		
	
	}
	
	
	
}
