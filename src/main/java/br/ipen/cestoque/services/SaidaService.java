package br.ipen.cestoque.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.InsumoSaida;
import br.ipen.cestoque.domain.Saida;
import br.ipen.cestoque.repositories.InsumoRepository;
import br.ipen.cestoque.repositories.InsumoSaidaRepository;
import br.ipen.cestoque.repositories.SaidaRepository;
import br.ipen.cestoque.services.exception.ObjectNotFoundException;


@Service
public class SaidaService {

	@Autowired
	private SaidaRepository repo;
	
	@Autowired
	private InsumoSaidaRepository insumoSaidaRepository;
	
	@Autowired
	private InsumoRepository insumoRepository;
	
	@Autowired
	private InsumoService insumoService;
	
	@Autowired
	private ColaboradorService colaboradorService;
		
	public Saida find(Integer id) throws ObjectNotFoundException {
		Optional<Saida> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Saida.class.getName()));
	}

	@Transactional
	public Saida insert(Saida obj) {
		List<Insumo> insumos = new ArrayList<>();
		Insumo insumo;
		Double quant;
		obj.setId(null);
		obj.setUsualt(UserService.authenticated().getUsername());
		obj.setDatalt(new Date(System.currentTimeMillis()));
		obj = repo.save(obj);
		for(InsumoSaida ie : obj.getItens()) {
			insumo = new Insumo();
			insumo = insumoService.find(ie.getInsumo().getId());
			quant = ie.getQuantidade();
			ie.setInsumo(insumo);
			ie.setQuantidade(quant);
			//insumo.setId(ie.getInsumo().getId());
			insumo.setQuantidade(ie.getInsumo().getQuantidade() - quant);
			insumos.add(insumo);
			ie.setValor(ie.getInsumo().getValor());
			ie.setSaida(obj);
		}
		insumoSaidaRepository.saveAll(obj.getItens());
		insumoRepository.saveAll(insumos);
		return obj;
	}
}
