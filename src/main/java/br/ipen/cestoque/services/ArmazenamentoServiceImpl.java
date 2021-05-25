package br.ipen.cestoque.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;

import br.ipen.cestoque.ApplicationProperties;
import br.ipen.cestoque.services.exception.ArmazenamentoException;
import br.ipen.cestoque.services.exception.ArmazenamentoFileNotFoundException;

@Service
public class ArmazenamentoServiceImpl implements ArmazenamentoService{
	

	private final Path rootLocation;
	private final ApplicationProperties properties;
	
	
	public ArmazenamentoServiceImpl(ApplicationProperties properties) throws IOException {
		this.properties = properties;
		this.rootLocation = Paths.get(properties.getLocalArmazenamento().getURL().getPath());
	}
	

	@Override
	public void init() {
		try {
			Files.createDirectory(rootLocation);
		}
		catch (IOException e) {
			throw new ArmazenamentoException("Could not initialize storage", e);
		}
		
	}

	@Override
	public void deleteAll() {
		try {
			FileSystemUtils.deleteRecursively(rootLocation);
		}
		catch (IOException e) {
			throw new ArmazenamentoException("Could not delete files and folders", e);
		}
		
	}

	@Override
	public boolean jrxmlFileExists(String file) {
		try {
			Path reportFile = Paths.get(properties.getLocalRelatorio().getURI());
			reportFile = reportFile.resolve(file + ".jrxml");
			if (Files.exists(reportFile))
				return true;
		} catch (IOException e) {
			//log.error("Error while trying to get file URI", e);
			return false;
		}
		return false;
	}

	@Override
	public boolean jasperFileExists(String file) {
		//Path reportFile = rootLocation;
		Path reportFile;
		try {
			reportFile = Paths.get(properties.getLocalRelatorio().getURI());
			reportFile = reportFile.resolve(file + ".jasper");
			if (Files.exists(reportFile))
				return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return false;
	}

	@Override
	public String loadJrxmlFile(String file) {
		try {
			Path reportFile = Paths.get(properties.getLocalRelatorio().getURI());
			reportFile = reportFile.resolve(file + ".jrxml");
			return reportFile.toString();
		} catch (IOException e) {
			//log.error("Error while trying to get file prefix", e);
			throw new ArmazenamentoFileNotFoundException("Could not load file", e);
		}
	}

	@Override
	public File loadJasperFile(String file) {
		//Path reportFile = rootLocation;
		Path reportFile;
		try {
			reportFile = Paths.get(properties.getLocalRelatorio().getURI());
			reportFile = reportFile.resolve(file + ".jasper");
			return reportFile.toFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			throw new ArmazenamentoFileNotFoundException("Could not load file", e);
		}
	}

}
