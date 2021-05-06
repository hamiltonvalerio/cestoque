package br.ipen.cestoque.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.ipen.cestoque.domain.Arquivo;
import br.ipen.cestoque.domain.Entrada;
import br.ipen.cestoque.domain.EntradaArquivo;
import br.ipen.cestoque.repositories.ArquivoRepository;
import br.ipen.cestoque.repositories.EntradaArquivoRepository;
import br.ipen.cestoque.repositories.EntradaRepository;

@Service
public class EntradaArquivoService implements ArquivoService{

	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	EntradaRepository entradaRepository;
	
	@Autowired
	EntradaArquivoRepository entradaArquivoRepository;
	
	@Autowired
	ArquivoRepository arquivoRepository; 

	@Override
	public void salvar(MultipartFile[] arquivos, Integer id) {
		// TODO Auto-generated method stub
		Entrada entrada = entradaRepository.findById(id).orElse(null);
		List<EntradaArquivo> listaEntradaArquivos = new ArrayList<>();
		if(arquivos.length > 0){
			for (MultipartFile mtf : arquivos) {
				try {
					listaEntradaArquivos.add(new EntradaArquivo(null, arquivoRepository.save(new Arquivo(null, StringUtils.cleanPath(mtf.getOriginalFilename()), mtf.getContentType(), mtf.getBytes())), entrada));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		try {
			entradaArquivoRepository.saveAll(listaEntradaArquivos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
