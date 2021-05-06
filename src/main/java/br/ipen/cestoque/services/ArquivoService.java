package br.ipen.cestoque.services;

import org.springframework.web.multipart.MultipartFile;

import br.ipen.cestoque.domain.Arquivo;

public interface ArquivoService {

	public void salvar(MultipartFile[] arquivos, Integer id);
	
}
