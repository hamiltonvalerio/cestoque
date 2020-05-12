package br.ipen.cestoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.domain.Categoria;
import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.repositories.CategoriaRepository;
import br.ipen.cestoque.repositories.InsumoRepository;
import br.ipen.cestoque.services.exception.ObjectNotFoundException;


@Service
public class InsumoService {

	@Autowired
	private InsumoRepository repo;
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
		
	public Insumo find(Integer id) throws ObjectNotFoundException {
		Optional<Insumo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Insumo.class.getName()));
	}
	
	public Page<Insumo> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.search(nome, categorias, pageRequest);
	}
	
}
