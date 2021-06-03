package br.ipen.cestoque.resources.utils;

import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.ipen.cestoque.repositories.InsumoEntradaRepository;
import br.ipen.cestoque.services.EntradaService;

@Component
public class GeraLoteRecebimentoCR {

	@Autowired
	private EntradaService entradaService;
	
	@Autowired
	private InsumoEntradaRepository InsumoEntradaRepository;
	
	public String gerarLote(Date data) {
		//formatardata YYYYmmdd hora e minuto
		DateTime dt = new DateTime(data);
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyyMMddHHmm");
		String str = fmt.print(dt);
		
		Integer ultimoId = entradaService.findMaxId();
		StringBuilder lr = new StringBuilder();
		lr.append("LRCR").append(str).append(ultimoId);
		
		System.out.println("ULTIMO ID:"+lr.toString());
		
		return lr.toString();
	}
	
	public String gerarLoteComLia(String numLIA) {
		//formatardata YYYYmmdd hora e minuto
		String str = "";
		if(numLIA != null) {
			str = numLIA;
		}else {
			str = "NLV";
		}
		Integer ultimoId = entradaService.findMaxId();
		StringBuilder lr = new StringBuilder();
		lr.append("LRCR").append(str).append(ultimoId);
		
		System.out.println("ULTIMO ID:"+lr.toString());
		
		return lr.toString();
	}
	
	public String gerarLei() {
		String lotelei = "";
		lotelei = gerarCodigoLei();
		Boolean existe = InsumoEntradaRepository.findTrueByLoteLEI(lotelei);
		if(existe != null) {
			return gerarLei();
		}else {
			return lotelei;
		}
	}
	
	private String gerarCodigoLei() {
		//formatardata YYYYmmdd hora e minuto
		String ranLetras = RandomStringUtils.randomAlphabetic(2).toUpperCase();
		String ranNumeros = RandomStringUtils.randomNumeric(5);
		String ramUmaLetra = RandomStringUtils.randomAlphabetic(1).toUpperCase();
		StringBuilder lr = new StringBuilder();
		lr.append("L").append(ranLetras).append(ranNumeros).append(ramUmaLetra);
		return lr.toString();
	}
	
}
