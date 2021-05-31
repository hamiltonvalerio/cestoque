package br.ipen.cestoque.services;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.ipen.cestoque.domain.Arquivo;
import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.InsumoArquivo;
import br.ipen.cestoque.repositories.ArquivoRepository;
import br.ipen.cestoque.repositories.InsumoArquivoRepository;
import br.ipen.cestoque.repositories.InsumoRepository;

@Service
public class InsumoArquivoService {
	
	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	ArquivoRepository arquivoRepository;
	
	@Autowired
	InsumoRepository insumoRepository;  
	
	@Autowired
	InsumoArquivoRepository insumoArquivoRepository;

	public void salvar(MultipartFile file, Integer idinsumo, String loteFornecedor) {
		// TODO Auto-generated method stub
		Insumo insumo = insumoRepository.findById(idinsumo).orElse(null);
		try {
			insumoArquivoRepository.save(new InsumoArquivo(null, arquivoRepository.save(new Arquivo(
					null,
					StringUtils.cleanPath(file.getOriginalFilename()),
					file.getContentType(), 
					file.getBytes()
					)), insumo, loteFornecedor));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
