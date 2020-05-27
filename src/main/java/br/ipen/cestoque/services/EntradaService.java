package br.ipen.cestoque.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.repositories.EntradaRepository;
import br.ipen.cestoque.repositories.InsumoEntradaRepository;


@Service
public class EntradaService {

	@Autowired
	private EntradaRepository repo;
	
	@Autowired
	private InsumoEntradaRepository insumoEntradaRepository;
	
	@Autowired
	private InsumoService insumoService;
	
	@Autowired
	private ColaboradorService colaboradorService;
		


	
}
