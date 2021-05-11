package br.ipen.cestoque.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ipen.cestoque.domain.InsumoAjuste;
import br.ipen.cestoque.services.EntradaService;
import br.ipen.cestoque.services.InsumoAjusteService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(value = "/ajusteestoque")
public class InsumoAjusteResource {

	@Autowired
	private EntradaService entradaService;
	
	@Autowired
	private InsumoAjusteService insumoAjusteService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<InsumoAjuste> insert(@RequestBody InsumoAjuste obj){
		
		
		
		return ResponseEntity.ok().body(null);
	}
}
