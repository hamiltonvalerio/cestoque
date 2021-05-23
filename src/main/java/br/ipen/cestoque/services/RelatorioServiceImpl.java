package br.ipen.cestoque.services;

import java.util.Map;

import org.springframework.stereotype.Service;

import net.sf.jasperreports.engine.JRDataSource;

@Service
public class RelatorioServiceImpl implements RelatorioService{
		

	@Override
	public byte[] gerarRelatorioPDF(String inputFileName, Map<String, Object> params) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public byte[] gerarRelatorioPDF(String inputFileName, Map<String, Object> params, JRDataSource dataSource) {
		// TODO Auto-generated method stub
		return null;
	}

}
