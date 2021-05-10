package br.ipen.cestoque.resources;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import br.ipen.cestoque.services.ImpressaoDatamaxService;

@RestController
@RequestMapping(value="/impressora")
public class ImpressoraResource {

	@Autowired
	ImpressaoDatamaxService impressaoDatamaxService;
	
	@RequestMapping(value="/imprimirdatamax",method = RequestMethod.POST)
	public ResponseEntity<Void> imprimeArquivoMultipart(
			@RequestParam(name="files") MultipartFile file){	
		
		Boolean bol = impressaoDatamaxService.imprimeArquivoMultipart(file);
    	
		return ResponseEntity.created(null).build();
	}
	
	@RequestMapping(value="/imprimirdatamaxfile",method = RequestMethod.POST)
	public ResponseEntity<Void> imprimeArquivoFile(
			@RequestParam(name="file") File file){	
		
		Boolean bol = impressaoDatamaxService.imprimeArquivoFile(file);
		
		return ResponseEntity.created(null).build();
	}
	
}
