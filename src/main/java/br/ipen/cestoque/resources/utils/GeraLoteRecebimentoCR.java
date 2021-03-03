package br.ipen.cestoque.resources.utils;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ipen.cestoque.services.EntradaService;

@Component
public class GeraLoteRecebimentoCR {

	
	@Autowired
	private EntradaService entradaService;
	
	public String gerarLote(Date data) {
		//formatardata YYYYmmdd hora e minuto
		
		
		Integer ultimoId = entradaService.findMaxId();
		StringBuilder lr = new StringBuilder();
		lr.append("LRCR").append(data).append(ultimoId);
		
		System.out.println("ULTIMO ID:"+lr.toString());
		
		return lr.toString();
	}
	
}
