package br.ipen.cestoque.services;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.prefs.Preferences;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.ipen.cestoque.resources.ImpressoraResource;
import honeywell.connection.ConnectionBase;
import honeywell.connection.Connection_TCP;
import honeywell.printer.DocumentDPL;

@Service
public class ImpressaoDatamaxService implements Runnable {

	private String connType = "TCP/IP";
	private String m_deviceAddress = "192.168.001.129";
	private int m_devicePort = 9100;
	private String printerLanguage = "DPL";
	private Integer m_printHeadWidth = 384;
	private String printTipo = "Print";
	private String dplMode = "Incrementing Sample";

	private ConnectionBase conn = null;

	private DocumentDPL docDPL;

	private byte[] printData;

	Preferences prefs = Preferences.userNodeForPackage(ImpressoraResource.class);

	@Override
	public void run() {
		conn = null;
		try {
			conn = Connection_TCP.createClient(m_deviceAddress, m_devicePort, false);
			conn.open();
			conn.write(printData);
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			conn.close();
		}
	}

	public Boolean imprimeArquivoMultipart(MultipartFile file) {
		try {
			printData = file.getBytes();
			run();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}

	public Boolean imprimeArquivoFile(File file) {
		byte[] readBuffer = new byte[(int) file.length()];
		InputStream inputStream;
		try {
			inputStream = new BufferedInputStream(new FileInputStream(file));
			inputStream.read(readBuffer);
			inputStream.close();
			printData = file.getPath().getBytes();
			run();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean imprimeArquivoFileToMultipar(File file) throws IOException {
		printData = file.getPath().getBytes();
		run();
		return true;
	}
	
	public Boolean imprimeArquivoBytes(byte[] bytes) throws IOException {
		printData = bytes;
		run();
		return true;
	}

}
