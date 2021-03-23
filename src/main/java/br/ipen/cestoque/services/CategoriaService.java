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

import br.ipen.cestoque.domain.Categoria;
import br.ipen.cestoque.dto.CategoriaDTO;
import br.ipen.cestoque.dto.CategoriaNewDTO;
import br.ipen.cestoque.repositories.CategoriaRepository;
import br.ipen.cestoque.services.exception.DataIntegrityException;
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
		Categoria newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}
	
	private void updateData(Categoria newObj, Categoria obj) {
		// TODO Auto-generated method stub
		newObj.setNome(obj.getNome());
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
			throw new DataIntegrityException("Não é possível excluir uma categoria que possui insumos");
		}
	}

	public List<Categoria> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	public Page<Categoria> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Categoria fromDTO(CategoriaNewDTO objDto) {
		return new Categoria(null, objDto.getNome(), objDto.getUsualt(), objDto.getDatalt());
	}
	
	public Categoria fromDTO(CategoriaDTO objDto) {
		return new Categoria(objDto.getId(), objDto.getNome(), objDto.getUsualt(), objDto.getDatalt());
	}
	
}
