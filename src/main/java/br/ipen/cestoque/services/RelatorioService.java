package br.ipen.cestoque.services;

import java.sql.Connection;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;

public interface RelatorioService {

	byte[] gerarRelatorioPDF(String inputFileName, Map<String, Object> params, Connection connection);
	
}
