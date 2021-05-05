package br.ipen.cestoque.services;

import java.nio.file.Path;
import java.util.stream.Stream;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import br.ipen.cestoque.domain.Arquivo;

public interface ArquivoService {

	public Arquivo salvar(MultipartFile arquivo);
	
	public Resource carregarArquivo(String nomeDoArquivo);
	
	public void init();
	
	public Stream<Path> getArquivos();
	
	public void deletarTodos();
}
