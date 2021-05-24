package br.ipen.cestoque.resources;

import java.sql.Connection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.ipen.cestoque.services.InsumoService;
import br.ipen.cestoque.services.RelatorioServiceImpl;

@RestController
@RequestMapping(value = "/relatorios")
public class RelatorioResource {
	
	@Autowired
	private Connection connection;

	@Autowired
	private RelatorioServiceImpl relatorioServiceImpl;
	
	@Autowired
	private InsumoService insumoService; 


	@RequestMapping(value = "/teste2", method = RequestMethod.GET)
	public ResponseEntity<byte[]> report(@PathVariable String nomeDoRelatorio) {
		nomeDoRelatorio = "template_retrato";
		Map<String, Object> params = new HashMap<>();


		byte[] bytes = relatorioServiceImpl.gerarRelatorioPDF(nomeDoRelatorio, params, connection);
		ContentDisposition contentDisposition = ContentDisposition.builder("inline").filename(nomeDoRelatorio + ".pdf")
				.build();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDisposition(contentDisposition);
		return ResponseEntity.ok().header("Content-Type", "application/pdf; charset=UTF-8").headers(headers)
				.body(bytes);
	}
	
	@RequestMapping(value = "/insumos", method = RequestMethod.GET)
	public ResponseEntity<byte[]> reportInsumos() {

		Map<String, Object> params = new HashMap<>();
		
		

		byte[] bytes = relatorioServiceImpl.gerarRelatorioPDF("template_retrato", params, connection);
		ContentDisposition contentDisposition = ContentDisposition.builder("inline").filename("insumos.pdf")
				.build();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentDisposition(contentDisposition);
		return ResponseEntity.ok().header("Content-Type", "application/pdf; charset=UTF-8").headers(headers)
				.body(bytes);
	}
	
	@RequestMapping(value = "/teste-conexao", method = RequestMethod.GET)
	public ResponseEntity<String> testeConecxao() {
		
		String con = connection != null ? "conectado" : "pau";
		
		return ResponseEntity.ok().body(con);
	}

	
	

}
