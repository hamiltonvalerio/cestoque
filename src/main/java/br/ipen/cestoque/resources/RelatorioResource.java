package br.ipen.cestoque.resources;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ipen.cestoque.domain.Entrada;
import br.ipen.cestoque.services.RelatorioServiceImpl;

@RestController
@RequestMapping(value = "/relatorios")
public class RelatorioResource {

	@Autowired
	private RelatorioServiceImpl relatorioServiceImpl;

	@RequestMapping(value = "/teste2", method = RequestMethod.GET)
	public ResponseEntity<byte[]> report(@PathVariable(required = false) String username) {
		username = "teste";
		System.out.println(username);
		
		Map<String, Object> params = new HashMap<>();
		params.put("username", username);
		byte[] bytes = relatorioServiceImpl.gerarRelatorioPDF("pdf_rest_resource", params);
		ContentDisposition contentDisposition = ContentDisposition.builder("inline").filename(username + ".pdf")
				.build();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDisposition(contentDisposition);
		return ResponseEntity.ok().header("Content-Type", "application/pdf; charset=UTF-8").headers(headers)
				.body(bytes);
	}
	
	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public ResponseEntity<Entrada> find() {
		System.out.println("s");
		return ResponseEntity.ok().body(null);
	}

}
