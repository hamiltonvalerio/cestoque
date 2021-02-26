package br.ipen.cestoque.resources.utils;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import br.ipen.cestoque.services.EntradaService;

public class GeraLoteRecebimentoCR {

	
	@Autowired
	private EntradaService entradaService;
	
	public String gerarLote(Date data) {
		
		Integer ultimoId = entradaService.findMaxId();
		
		System.out.println("ULTIMO ID:"+ultimoId);
		
		return "vazio";
	}
	
}
