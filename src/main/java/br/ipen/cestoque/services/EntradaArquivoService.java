package br.ipen.cestoque.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.ipen.cestoque.domain.Arquivo;
import br.ipen.cestoque.repositories.FileRepository;

@Service
public class EntradaArquivoService implements ArquivoService{

	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	FileRepository fileRepo;

	@Override
	public Arquivo salvar(MultipartFile[] arquivos, Integer id) {
		// TODO Auto-generated method stub
		if(arquivos.length > 0){
			for (MultipartFile mtf : arquivos) {
				
			}
		}
		
		
		return null;
	}
	

}
