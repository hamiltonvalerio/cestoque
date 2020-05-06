package br.ipen.cestoque.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.domain.Colaborador;
import br.ipen.cestoque.repositories.ClienteRepository;
import br.ipen.cestoque.services.exception.ObjectNotFoundException;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository repo;
	
		
	public Colaborador find(Integer id) throws ObjectNotFoundException {
		Optional<Colaborador> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Colaborador.class.getName()));
	}
	
}
