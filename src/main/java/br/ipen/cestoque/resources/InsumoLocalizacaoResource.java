package br.ipen.cestoque.resources;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.time.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.ipen.cestoque.domain.InsumoLocalizacao;
import br.ipen.cestoque.repositories.InsumoLocalizacaoRepository;
import br.ipen.cestoque.services.InsumoService;
import br.ipen.cestoque.services.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Insumos Localizacao")
@RestController
@RequestMapping(value = "/insumolocalizacao")
public class InsumoLocalizacaoResource {

	@Autowired
	private InsumoService service;

	@Autowired
	private InsumoLocalizacaoRepository ilrepo;

	public InsumoLocalizacaoResource() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value = "/buscainsumolocalizacaoporlocalizacao", method = RequestMethod.GET)
	public ResponseEntity<Page<InsumoLocalizacao>> findInsumoLocalizacaoByLocalizacao(
			@RequestParam(value = "localizacao_id") String localizacao_id,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "30") Integer linesPerPage) {

		Page<InsumoLocalizacao> list = service.findInsumoLocalizacaoByLocalizacao(Integer.parseInt(localizacao_id),
				page, linesPerPage);

		for (InsumoLocalizacao insumoLocalizacao : list) {
			insumoLocalizacao.setCodigoalmoxarifado(insumoLocalizacao.getInsumo().getCodigoalmox());
		}

		return ResponseEntity.ok().body(list);

	}

	@RequestMapping(value = "/buscainsumolocalizacaoporlocalizacaoSemVazio", method = RequestMethod.GET)
	public ResponseEntity<Page<InsumoLocalizacao>> findInsumoLocalizacaoByLocalizacaoSemVazio(
			@RequestParam(value = "localizacao_id") String localizacao_id,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "30") Integer linesPerPage) {

		Page<InsumoLocalizacao> list = service
				.findInsumoLocalizacaoByLocalizacaoSemVazio(Integer.parseInt(localizacao_id), page, linesPerPage);

		for (InsumoLocalizacao insumoLocalizacao : list) {
			insumoLocalizacao.setCodigoalmoxarifado(insumoLocalizacao.getInsumo().getCodigoalmox());
		}

		return ResponseEntity.ok().body(list);

	}

	@RequestMapping(value = "/buscaporlocalizacaonopage", method = RequestMethod.GET)
	public ResponseEntity<List<InsumoLocalizacao>> buscaporlocalizacaonopage(
			@RequestParam(value = "localizacao_id") String localizacao_id) {

		List<InsumoLocalizacao> ils = service.buscatodosporlocalizacaonopage(Integer.parseInt(localizacao_id));

		for (InsumoLocalizacao il : ils) {
			il.setNomedoinsumo(il.getInsumo().getNome());
		}

		return ResponseEntity.ok().body(ils);
	}

	@ApiOperation(value = "Faz o recebimento do insumo")
	@RequestMapping(value = "/updateRecebimento", method = RequestMethod.POST)
	public ResponseEntity<Void> updateRecebimento(
			@RequestParam(value = "insumolocalizacao_id") String insumolocalizacao_id,
			@RequestParam(value = "usuario") String usuario) {

		Boolean recebido = true;

		ilrepo.updateRecebimento(Integer.parseInt(insumolocalizacao_id), usuario, recebido,
				new Date(System.currentTimeMillis()));
		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Retorna LotesLEI cadastrados")
	@RequestMapping(value = "/findLotesLEIInsumosLocalizacoes", method = RequestMethod.GET)
	public ResponseEntity<List<InsumoLocalizacao>> findLotesLEIInsumosLocalizacoes() {
		List<InsumoLocalizacao> lista = service.findLotesLEIInsumosLocalizacoes();
		return ResponseEntity.ok().body(lista);
	}

	@RequestMapping(value = "/findInsumosLocalizacoesByLoteLEI", method = RequestMethod.GET)
	public ResponseEntity<List<InsumoLocalizacao>> findInsumosLocalizacoesByLoteLEI(
			@RequestParam(value = "loteLEI") String loteLEI) {

		List<InsumoLocalizacao> ils = service.findInsumosLocalizacoesByLoteLEI(loteLEI);

		for (InsumoLocalizacao il : ils) {
			il.setNomedoinsumo(il.getInsumo().getNome());
		}

		return ResponseEntity.ok().body(ils);
	}

	@ApiOperation(value = "Altera a previsão de controle")
	@RequestMapping(value = "/updatePrevisaoControle", method = RequestMethod.POST)
	public ResponseEntity<Void> updatePrevisaoControle(
			@RequestParam(value = "insumolocalizacao_id") String insumolocalizacao_id,
			@RequestParam(value = "usuario") String usuario, @RequestParam(value = "data") String data) {
		try {
			ilrepo.updatePrevisaoControle(Integer.parseInt(insumolocalizacao_id),
					DateUtils.parseDate(data, new String[] { "dd/MM/yyyy HH:mm", "dd-MM-yyyy" }),
					new Date(System.currentTimeMillis()), usuario);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.noContent().build();
	}

	@ApiOperation(value = "Altera o insumo na localização - utilizado para inventário!")
	@RequestMapping(value = "/updateInsumoLocalizacaoInventario", method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> updateInsumoLocalizacaoInventario(@RequestBody InsumoLocalizacao objDto) {
		objDto.setUsualt(UserService.authenticated().getNome());
		objDto.setDatalt(new Date(System.currentTimeMillis()));

		
		InsumoLocalizacao il = service.updateInsumoLocalizacaoInventario(objDto);
		
		return ResponseEntity.noContent().build();
	}

}
