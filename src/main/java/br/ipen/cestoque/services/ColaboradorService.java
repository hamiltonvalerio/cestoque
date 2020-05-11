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

import br.ipen.cestoque.domain.Colaborador;
import br.ipen.cestoque.dto.ColaboradorDTO;
import br.ipen.cestoque.dto.ColaboradorNewDTO;
import br.ipen.cestoque.repositories.ColaboradorRepository;
import br.ipen.cestoque.services.exception.DataIntegrityException;
import br.ipen.cestoque.services.exception.ObjectNotFoundException;


@Service
public class ColaboradorService {

	@Autowired
	private ColaboradorRepository repo;
	
		
	public Colaborador find(Integer id) throws ObjectNotFoundException {
		Optional<Colaborador> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Colaborador.class.getName()));
	}
	
	public Colaborador insert(Colaborador obj) {
		// TODO Auto-generated method stub
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Colaborador update(Colaborador obj) {
		Colaborador newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}


	private void updateData(Colaborador newObj, Colaborador obj) {
		// TODO Auto-generated method stub
		newObj.setNome(obj.getNome());
		newObj.setCpf(obj.getCpf());
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
			throw new DataIntegrityException("Não é possível excluir um Colaborador");
		}
	}

	public List<Colaborador> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	public Page<Colaborador> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Colaborador fromDTO(ColaboradorDTO objDto) {
		return new Colaborador(objDto.getId(), objDto.getNome(), objDto.getCpf(), objDto.getUsualt(), objDto.getDatalt());
	}
	
	public Colaborador fromDTO(ColaboradorNewDTO objDto) {
		Colaborador col = new Colaborador(null, objDto.getNome(), objDto.getCpf(), objDto.getUsualt(), objDto.getDatalt());
		return col;
	}
	
}
