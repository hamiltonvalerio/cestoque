package br.ipen.cestoque.services;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import br.ipen.cestoque.domain.Arquivo;
import br.ipen.cestoque.domain.Entrada;
import br.ipen.cestoque.domain.EntradaArquivo;
import br.ipen.cestoque.domain.InsumoEntrada;
import br.ipen.cestoque.repositories.ArquivoRepository;
import br.ipen.cestoque.repositories.EntradaArquivoRepository;
import br.ipen.cestoque.repositories.EntradaRepository;

@Service
public class EntradaArquivoService implements ArquivoService {

	Logger log = LoggerFactory.getLogger(this.getClass().getName());

	@Autowired
	EntradaRepository entradaRepository;

	@Autowired
	EntradaArquivoRepository entradaArquivoRepository;

	@Autowired
	ArquivoRepository arquivoRepository;

	@Autowired
	ImpressaoDatamaxService impressaoDatamaxService;

	@Override
	public void salvar(MultipartFile[] arquivos, Integer id) {
		// TODO Auto-generated method stub
		Entrada entrada = entradaRepository.findById(id).orElse(null);
		List<EntradaArquivo> listaEntradaArquivos = new ArrayList<>();
		if (arquivos.length > 0) {
			for (MultipartFile mtf : arquivos) {
				try {
					listaEntradaArquivos.add(new EntradaArquivo(null, arquivoRepository.save(new Arquivo(
							null,
							StringUtils.cleanPath(mtf.getOriginalFilename()),
							mtf.getContentType(), 
							mtf.getBytes())),
							entrada));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		try {
			entradaArquivoRepository.saveAll(listaEntradaArquivos);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<EntradaArquivo> getAllFiles() {
		return entradaArquivoRepository.findAll();
	}

	public Boolean gerarEtiquetasDatamax(Entrada obj) {

		
		
			File file = null;
			try {
				file = File.createTempFile("arquivotemporario", ".txt");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
 		
            try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
            	for (InsumoEntrada content : obj.getItens()) {
            		Integer quantidade = content.getQuantidadeetiquetas()!=null?content.getQuantidadeetiquetas():0;
            		for (int i = 0; i < quantidade; i++) {
            			bw.write("M3000");
            			bw.write(System.lineSeparator());
            			bw.write("c0000");
            			bw.write(System.lineSeparator());
            			bw.write("e");
            			bw.write(System.lineSeparator());
            			bw.write("f140");
            			bw.write(System.lineSeparator());
            			bw.write("DL");
            			bw.write(System.lineSeparator());
            			bw.write("L");
            			bw.write(System.lineSeparator());
            			bw.write("D12");
            			bw.write(System.lineSeparator());
            			bw.write("PO");
            			bw.write(System.lineSeparator());
            			bw.write("SD");
            			bw.write(System.lineSeparator());
            			bw.write("H22");
            			bw.write(System.lineSeparator());
            			bw.write("102200001000020"+content.getInsumo().getNome());
            			bw.write(System.lineSeparator());
            			bw.write("102100000800020Lote Forn: "+content.getLoteFornecedor());
            			bw.write(System.lineSeparator());
            			bw.write("102100000800188Cod Almox: "+content.getInsumo().getCodigoalmox());
            			bw.write(System.lineSeparator());
            			bw.write("102100000700020Fab.:");
            			bw.write(System.lineSeparator());
            			bw.write("102100000700045"+content.getDataFabricacao());
            			bw.write(System.lineSeparator());
            			bw.write("102100000700150Val.:");
            			bw.write(System.lineSeparator());
            			bw.write("102100000700185"+content.getDataValidade());
            			bw.write(System.lineSeparator());
            			bw.write("102100000600020Lote CR:");
            			bw.write(System.lineSeparator());
            			bw.write("102100000600065"+content.getLoteCR());
            			bw.write(System.lineSeparator());
            			bw.write("102100000500020Lote Rec:");
            			bw.write(System.lineSeparator());
            			bw.write("102100000500071"+content.getLoteRecebimento());
            			bw.write(System.lineSeparator());
            			bw.write("102100000500150Lote LEI:");
            			bw.write(System.lineSeparator());
            			bw.write("102100000500205"+content.getLoteLEI());
            			bw.write(System.lineSeparator());
            			bw.write("Q0001");
            			bw.write(System.lineSeparator());
            			bw.write("E");
            			bw.write(System.lineSeparator());
					}
				}
            	bw.close();

            	FileInputStream stream = new FileInputStream(file);
            	MultipartFile multip = new MockMultipartFile("file", file.getName(), MediaType.TEXT_PLAIN_VALUE, stream);
           	 	byte [] tes2 = multip.getBytes();
            	Boolean imprimeArquivoFile = impressaoDatamaxService.imprimeArquivoBytes(tes2);
            	 
            	file.delete();
            	
            } catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;

	}
	

}
