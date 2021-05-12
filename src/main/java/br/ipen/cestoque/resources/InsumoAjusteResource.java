package br.ipen.cestoque.resources;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ipen.cestoque.dto.InsumoAjusteNewDTO;
import br.ipen.cestoque.services.InsumoAjusteService;

@RestController
@RequestMapping(value = "/ajusteestoque")
public class InsumoAjusteResource {

		
	@Autowired
	private InsumoAjusteService insumoAjusteService;
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@Valid @RequestBody InsumoAjusteNewDTO insumoAjusteNewDTO){
		
	System.out.println("aqui "+insumoAjusteNewDTO.getLoteARM());
		
		return ResponseEntity.ok().body(null);
	}
	
}
