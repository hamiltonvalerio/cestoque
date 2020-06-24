package br.ipen.cestoque.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.domain.Unidade;
import br.ipen.cestoque.domain.enums.Perfil;
import br.ipen.cestoque.dto.UnidadeDTO;
import br.ipen.cestoque.dto.UnidadeNewDTO;
import br.ipen.cestoque.repositories.UnidadeRepository;
import br.ipen.cestoque.security.UserSS;
import br.ipen.cestoque.services.exception.AuthorizationException;
import br.ipen.cestoque.services.exception.DataIntegrityException;
import br.ipen.cestoque.services.exception.ObjectNotFoundException;


@Service
public class UnidadeService {

	@Autowired
	private UnidadeRepository repo;
	
	
		
	public Unidade find(Integer id) throws ObjectNotFoundException {
		UserSS user = UserService.authenticated();
		if(user == null || !user.hasHole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		Optional<Unidade> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Unidade.class.getName()));
	}
	
	public Unidade insert(Unidade obj) {
		// TODO Auto-generated method stub
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Unidade update(Unidade obj) {
		Unidade newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}


	private void updateData(Unidade newObj, Unidade obj) {
		// TODO Auto-generated method stub
		newObj.setNome(obj.getNome());
		newObj.setSigla(obj.getSigla());
		newObj.setUsualt(obj.getUsualt());
		newObj.setDatalt(new Date());
		
	}

	public void delete(Integer id) {
		// TODO Auto-generated method stub
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			// TODO: handle exception
			throw new DataIntegrityException("Não é possível excluir um Unidade");
		}
	}

	public List<Unidade> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	
	public Page<Unidade> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Unidade fromDTO(UnidadeDTO objDto) {
		return new Unidade(objDto.getId(), objDto.getNome(), objDto.getSigla(), objDto.getUsualt(), objDto.getDatalt());
	}
	
	public Unidade fromDTO(UnidadeNewDTO objDto) {
		Unidade col = new Unidade(null, objDto.getNome(), objDto.getSigla(), objDto.getUsualt(), objDto.getDatalt());
		return col;
	}
	
	
	
}
