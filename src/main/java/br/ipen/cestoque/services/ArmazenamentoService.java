package br.ipen.cestoque.services;

import java.io.File;

public interface ArmazenamentoService {
	
	void init();

	void deleteAll();

	boolean jrxmlFileExists(String file);

	boolean jasperFileExists(String file);

	String loadJrxmlFile(String file);

	File loadJasperFile(String file);
	
}
