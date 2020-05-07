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


	public Categoria insert(Categoria cat) {
		// TODO Auto-generated method stub
		cat.setId(null);
		return repo.save(cat);
	}
	
}
