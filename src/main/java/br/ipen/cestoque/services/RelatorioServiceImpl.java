package br.ipen.cestoque.services;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.util.Map;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.ApplicationProperties;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.util.JRSaver;

@Service
public class RelatorioServiceImpl implements RelatorioService{
	
	@Autowired
	private ArmazenamentoService armazenamentoService;  
	
	@Autowired
	private ApplicationProperties properties;
	
	private static final String JASPER_DIRETORIO = "classpath:relatorios/";
	
	@Override
	public byte[] gerarRelatorioPDF(String inputFileName, Map<String, Object> params, Connection connection) {
		// TODO Auto-generated method stub
		
		byte[] bytes = null;
		JasperReport jasperReport = null;

		params.put("IMAGEM_DIRETORIO", JASPER_DIRETORIO);

		try (ByteArrayOutputStream byteArray = new ByteArrayOutputStream()) {
			// Check if a compiled report exists
			if (armazenamentoService.jasperFileExists(inputFileName)) {
				jasperReport = (JasperReport) JRLoader
						.loadObject(armazenamentoService.loadJasperFile(inputFileName));
			}
			// Compile report from source and save
			else {
				String jrxml = armazenamentoService.loadJrxmlFile(inputFileName);
				//log.info("{} loaded. Compiling report", jrxml);
				jasperReport = JasperCompileManager.compileReport(jrxml);
				// Save compiled report. Compiled report is loaded next time
				JRSaver.saveObject(jasperReport,armazenamentoService.loadJasperFile(inputFileName));
			}
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, params,
					connection);
			bytes = JasperExportManager.exportReportToPdf(jasperPrint);
		}
		catch (JRException | IOException e) {
			e.printStackTrace();
			//log.error("Encountered error when loading jasper file", e);
		}

		return bytes;
	}

}
