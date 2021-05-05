package br.ipen.cestoque.services;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.ipen.cestoque.domain.Arquivo;
import br.ipen.cestoque.repositories.FileRepository;
import br.ipen.cestoque.repositories.utils.FileErrors;
import br.ipen.cestoque.services.exception.FileSaveException;

@Service
public class ArquivoServiceImpl implements ArquivoService{

	Logger log = LoggerFactory.getLogger(this.getClass().getName());
	
	@Autowired
	FileRepository fileRepo;
	
	@Override
	public Arquivo salvar(MultipartFile file) {
		// TODO Auto-generated method stub
		String nomeArquivo = StringUtils.cleanPath(file.getOriginalFilename());
		try {
			if(nomeArquivo.contains("...")) {
				throw new FileSaveException(FileErrors.INVALID_FILE + nomeArquivo);
			}
			Arquivo arquivo = new Arquivo(null, nomeArquivo,file.getContentType(), file.getBytes());
			return fileRepo.save(arquivo);
 		} catch (Exception e) {
			// TODO: handle exception
 			throw new FileSaveException(FileErrors.FILE_NOT_STORED, e);
		}
	}

	@Override
	public Resource carregarArquivo(String nomeDoArquivo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Stream<Path> getArquivos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletarTodos() {
		// TODO Auto-generated method stub
		
	}

}
