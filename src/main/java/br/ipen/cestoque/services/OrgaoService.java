package br.ipen.cestoque.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.domain.Orgao;
import br.ipen.cestoque.repositories.OrgaoRepository;
import br.ipen.cestoque.services.exception.DataIntegrityException;
import br.ipen.cestoque.services.exception.ObjectNotFoundException;

@Service
public class OrgaoService {

	@Autowired
	private OrgaoRepository repo;
	
	public Orgao find(Integer id) throws ObjectNotFoundException{
		Optional<Orgao> obj = repo.findById(id);
		return obj.orElseThrow(()->new ObjectNotFoundException(
				"Objecto não encontrado! Id: "+ id + ", Tipo: "+ Orgao.class.getName()));
	}
	
	public Orgao insert(Orgao obj) {
		// TODO Auto-generated method stub
		obj.setUsualt(UserService.authenticated().getUsername());
		obj.setDatalt(new Date(System.currentTimeMillis()));
		obj.setId(null);
		
		return repo.save(obj);
	}
	
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			// TODO: handle exception
			throw new DataIntegrityException("Não é possível excluir um Orgão");
		}
	}
	
	public List<Orgao> findAll(){
		return repo.findAllByOrderByNomeAsc();
	}
	
	
}
