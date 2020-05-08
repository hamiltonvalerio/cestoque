package br.ipen.cestoque.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.domain.Categoria;
import br.ipen.cestoque.repositories.CategoriaRepository;
import br.ipen.cestoque.services.exception.ObjectNotFoundException;


@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository repo;
	
		
	public Categoria find(Integer id) throws ObjectNotFoundException {
		Optional<Categoria> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Categoria.class.getName()));
	}


	public Categoria insert(Categoria obj) {
		// TODO Auto-generated method stub
		obj.setId(null);
		return repo.save(obj);
	}


	public Categoria update(Categoria obj) {
		// TODO Auto-generated method stub
		find(obj.getId());
		return repo.save(obj);
	}
	
}
