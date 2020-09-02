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

import br.ipen.cestoque.domain.Fornecedor;
import br.ipen.cestoque.dto.FornecedorDTO;
import br.ipen.cestoque.dto.FornecedorNewDTO;
import br.ipen.cestoque.repositories.FornecedorRepository;
import br.ipen.cestoque.services.exception.DataIntegrityException;
import br.ipen.cestoque.services.exception.ObjectNotFoundException;


@Service
public class FornecedorService {

	@Autowired
	private FornecedorRepository repo;
	
		
	public Fornecedor find(Integer id) throws ObjectNotFoundException {
		Optional<Fornecedor> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Fornecedor.class.getName()));
	}
	
	public Fornecedor insert(Fornecedor obj) {
		// TODO Auto-generated method stub
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Fornecedor update(Fornecedor obj) {
		Fornecedor newObj = find(obj.getId());
		updateData(newObj, obj);
		return repo.save(newObj);
	}


	private void updateData(Fornecedor newObj, Fornecedor obj) {
		// TODO Auto-generated method stub
		newObj.setNome(obj.getNome());
		newObj.setCnpj(obj.getCnpj());
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
			throw new DataIntegrityException("Não é possível excluir um Fornecedor");
		}
	}

	public List<Fornecedor> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
	
	public List<Fornecedor> findByNome(String nome) {
		// TODO Auto-generated method stub
		return repo.findByNomeContains(nome);
	}
	
	public Page<Fornecedor> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}
	
	public Fornecedor fromDTO(FornecedorDTO objDto) {
		return new Fornecedor(objDto.getId(), objDto.getCod_fornecedor() ,objDto.getNome(), objDto.getCnpj(), objDto.getUsualt(), objDto.getDatalt());
	}
	
	public Fornecedor fromDTO(FornecedorNewDTO objDto) {
		Fornecedor col = new Fornecedor(null, objDto.getCod_fornecedor() ,objDto.getNome(), objDto.getCnpj(), objDto.getUsualt(), objDto.getDatalt());
		return col;
	}
	
}
