package br.ipen.cestoque.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.domain.Entrada;
import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.InsumoEntrada;
import br.ipen.cestoque.repositories.EntradaRepository;
import br.ipen.cestoque.repositories.InsumoEntradaRepository;
import br.ipen.cestoque.repositories.InsumoRepository;
import br.ipen.cestoque.services.exception.ObjectNotFoundException;


@Service
public class EntradaService {

	@Autowired
	private EntradaRepository repo;
	
	@Autowired
	private InsumoEntradaRepository insumoEntradaRepository;
	
	@Autowired
	private InsumoRepository insumoRepository;
	
	@Autowired
	private InsumoService insumoService;
	
	@Autowired
	private ColaboradorService colaboradorService;
		
	public Entrada find(Integer id) throws ObjectNotFoundException {
		Optional<Entrada> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Entrada.class.getName()));
	}

	@Transactional
	public Entrada insert(Entrada obj) {
		List<Insumo> insumos = new ArrayList<>();
		Insumo insumo;
		Double quant;
		obj.setId(null);
		obj.setUsualt(UserService.authenticated().getUsername());
		obj.setDatalt(new Date(System.currentTimeMillis()));
		obj = repo.save(obj);
		for(InsumoEntrada ie : obj.getItens()) {
			insumo = new Insumo();
			insumo = insumoService.find(ie.getInsumo().getId());
			quant = ie.getQuantidade();
			ie.setInsumo(insumo);
			ie.setQuantidade(quant);
			//insumo.setId(ie.getInsumo().getId());
			if(ie.getInsumo().getQuantidade() == null) {
				ie.getInsumo().setQuantidade(0.0);
			}
			insumo.setQuantidade(ie.getInsumo().getQuantidade() + quant);
			insumos.add(insumo);
			ie.setValor(ie.getInsumo().getValor());
			ie.setEntrada(obj);
		}
		insumoEntradaRepository.saveAll(obj.getItens());
		insumoRepository.saveAll(insumos);
		return obj;
	}
	
	public List<Entrada> findAll() {
		// TODO Auto-generated method stub
		//return repo.findAll();
		return repo.findAllByOrderByDataEntradaDesc();
		
	}
}
