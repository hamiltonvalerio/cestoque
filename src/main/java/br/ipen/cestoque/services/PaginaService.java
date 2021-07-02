package br.ipen.cestoque.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.domain.Pagina;
import br.ipen.cestoque.domain.enums.Perfil;
import br.ipen.cestoque.dto.PaginaDTO;
import br.ipen.cestoque.dto.PaginaNewDTO;
import br.ipen.cestoque.repositories.PaginaRepository;
import br.ipen.cestoque.security.UserSS;
import br.ipen.cestoque.services.exception.AuthorizationException;
import br.ipen.cestoque.services.exception.DataIntegrityException;
import br.ipen.cestoque.services.exception.ObjectNotFoundException;


@Service
public class PaginaService {

	@Autowired
	private PaginaRepository repo;
	
		
	public Pagina find(Integer id) throws ObjectNotFoundException {
		UserSS user = UserService.authenticated();
		if(user == null || !user.hasHole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Pagina> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Pagina.class.getName()));
	}
	
	public Pagina insert(Pagina obj) {
		// TODO Auto-generated method stub
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Pagina update(Pagina obj) {
		Pagina newObj = find(obj.getId());
		
		return repo.save(newObj);
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			// TODO: handle exception
			throw new DataIntegrityException("Não é possível excluir um Pagina");
		}
	}

	public List<Pagina> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	
	public Page<Pagina> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Pagina fromDTO(PaginaDTO objDto) {
		return new Pagina(objDto.getId(), objDto.getNome(), objDto.getUsualt(), objDto.getDatalt());
	}
	
	public Pagina fromDTO(PaginaNewDTO objDto) {
		Pagina col = new Pagina(null, objDto.getNome(), objDto.getUsualt(), objDto.getDatalt());
		return col;
	}
	
	
	
}
