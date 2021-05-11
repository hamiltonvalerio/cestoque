package br.ipen.cestoque.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.ipen.cestoque.domain.Entrada;
import br.ipen.cestoque.domain.EntradaArquivo;
import br.ipen.cestoque.dto.EntradaDTO;
import br.ipen.cestoque.resources.utils.GeraLoteRecebimentoCR;
import br.ipen.cestoque.services.EntradaArquivoService;
import br.ipen.cestoque.services.EntradaService;

@RestController
@RequestMapping(value = "/entradas")
public class EntradaResource {

	@Autowired
	private EntradaService service;

	@Autowired
	private EntradaArquivoService entradaArquivoService;

	@Autowired
	private GeraLoteRecebimentoCR gera;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Entrada> find(@PathVariable Integer id) {
		Entrada entrada;
		entrada = service.find(id);
		return ResponseEntity.ok().body(entrada);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<String> insert(@Valid @RequestBody Entrada obj) {
		String loterecebimento = gera.gerarLote(obj.getDataEntrada());
		obj.setLoteRecebimento(loterecebimento);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		// return ResponseEntity.created(uri).build();
		return ResponseEntity.ok().body(obj.getId().toString());
	}

	@RequestMapping(value = "/inserarquivos", method = RequestMethod.POST)
	public ResponseEntity<Void> insertarquivos(@RequestParam(name = "files") MultipartFile[] files,
			@RequestParam(name = "identrada") String entrada)

	{
		entradaArquivoService.salvar(files, Integer.parseInt(entrada));

		return ResponseEntity.created(null).build();
	}

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<EntradaDTO>> findAll() {
		List<Entrada> list = service.findAllOrderById();
		List<EntradaDTO> listDto = list.stream().map(obj -> new EntradaDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	}

	/*
	 * @GetMapping("/files") public ResponseEntity<List<ResponseFile>>
	 * getListFiles() { List<ResponseFile> files =
	 * entradaArquivoService.getAllFiles().map(dbFile -> { String fileDownloadUri =
	 * ServletUriComponentsBuilder .fromCurrentContextPath() .path("/files/")
	 * .path(dbFile.getId().toString()) .toUriString();
	 * 
	 * return new ResponseFile( dbFile.getArquivo().getNome(), fileDownloadUri,
	 * dbFile.getArquivo().getTipo(), dbFile.getArquivo().getData().length);
	 * }).collect(Collectors.toList());
	 * 
	 * return ResponseEntity.status(HttpStatus.OK).body(files);
	 * 
	 * }
	 */

	/*
	 * @GetMapping("/downloadFile/{fileId}") public ResponseEntity<Resource>
	 * downloadFile(@PathVariable String fileId) { // Load file from database DBFile
	 * dbFile = dbFileStorageService.getFile(fileId);
	 * 
	 * return ResponseEntity.ok()
	 * .contentType(MediaType.parseMediaType(dbFile.getFileType()))
	 * .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" +
	 * dbFile.getFileName() + "\"") .body(new ByteArrayResource(dbFile.getData()));
	 * }
	 */

	@GetMapping("/download")
	public ResponseEntity<Resource> download() {
		List<EntradaArquivo> lista = entradaArquivoService.getAllFiles();
		EntradaArquivo ent = new EntradaArquivo();
		for (EntradaArquivo entradaArquivo : lista) {
			ent = entradaArquivo;
		}
		String fileName = ent.getArquivo().getNome();
		Resource resource = null;

		return null;
	}

	@RequestMapping(value = "/geraretiquetas", method = RequestMethod.POST)
	public ResponseEntity<Void> gerarEtiquetasDatamax(@RequestBody Entrada obj) {

		Boolean bol = entradaArquivoService.gerarEtiquetasDatamax(obj);

		return ResponseEntity.created(null).build();
	}

}
