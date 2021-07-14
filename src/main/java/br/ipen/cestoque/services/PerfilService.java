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

import br.ipen.cestoque.domain.Perfil;
import br.ipen.cestoque.dto.PerfilDTO;
import br.ipen.cestoque.dto.PerfilNewDTO;
import br.ipen.cestoque.repositories.PerfilRepository;
import br.ipen.cestoque.services.exception.DataIntegrityException;
import br.ipen.cestoque.services.exception.ObjectNotFoundException;


@Service
public class PerfilService {

	@Autowired
	private PerfilRepository repo;
	
		
	public Perfil find(Integer id) throws ObjectNotFoundException {
		Optional<Perfil> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Perfil.class.getName()));
	}


	public Perfil insert(Perfil obj) {
		// TODO Auto-generated method stub
		String roleDescricao = "ROLE_";
		obj.setDescricao(roleDescricao.concat(obj.getDescricao()));
		obj.setUsualt(UserService.authenticated().getUsername());
		obj.setDatalt(new Date(System.currentTimeMillis()));
		obj.setId(null);
		
		return repo.save(obj);
	}

	public Perfil update(Perfil obj) {
		Perfil newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Perfil newObj, Perfil obj) {
		// TODO Auto-generated method stub
		newObj.setNome(obj.getNome());
		newObj.setDescricao(obj.getDescricao());
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
			throw new DataIntegrityException("Não é possível excluir um Perfil que possui usuários");
		}
	}

	public List<Perfil> findAll() {
		// TODO Auto-generated method stub
		return repo.findAllByOrderByNomeAsc();
	}
	
	public Page<Perfil> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Perfil fromDTO(PerfilNewDTO objDto) {
		return new Perfil(null, objDto.getNome(), objDto.getDescricao(), objDto.getUsualt(), objDto.getDatalt());
	}
	
	public Perfil fromDTO(PerfilDTO objDto) {
		return new Perfil(objDto.getId(), objDto.getNome(), objDto.getDescricao(), objDto.getUsualt(), objDto.getDatalt());
	}


	public List<Perfil> findAllByNomePagina(String nomepagina) {
		// TODO Auto-generated method stub
		return repo.findAllByNomePagina(nomepagina);
	}
	
}
