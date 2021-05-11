package br.ipen.cestoque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.repositories.InsumoAjusteRepository;
import br.ipen.cestoque.repositories.InsumoLocalizacaoRepository;
import br.ipen.cestoque.repositories.InsumoRepository;

@Service
public class InsumoAjusteService {
	
	@Autowired
	private InsumoRepository insumoRepository;
	
	@Autowired
	private InsumoLocalizacaoRepository insumoLocalizacaoRepository;
	
	@Autowired
	private InsumoAjusteRepository insumoAjusteRepository;
	
}
