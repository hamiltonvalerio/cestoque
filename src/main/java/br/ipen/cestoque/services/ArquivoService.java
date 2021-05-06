package br.ipen.cestoque.services;

import org.springframework.web.multipart.MultipartFile;

import br.ipen.cestoque.domain.Arquivo;

public interface ArquivoService {

	public Arquivo salvar(MultipartFile[] arquivos, Integer id);
	
}
