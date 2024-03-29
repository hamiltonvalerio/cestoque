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

import br.ipen.cestoque.domain.Localizacao;
import br.ipen.cestoque.dto.LocalizacaoDTO;
import br.ipen.cestoque.dto.LocalizacaoNewDTO;
import br.ipen.cestoque.repositories.LocalizacaoRepository;
import br.ipen.cestoque.services.exception.DataIntegrityException;
import br.ipen.cestoque.services.exception.ObjectNotFoundException;

@Service
public class LocalizacaoService {

	@Autowired
	private LocalizacaoRepository repo;

	public Localizacao find(Integer id) throws ObjectNotFoundException {
		Optional<Localizacao> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Localizacao.class.getName()));
	}

	public Localizacao insert(Localizacao obj) {
		// TODO Auto-generated method stub
		obj.setId(null);
		if (obj.getAlmoxarifadoprincipal() == false) {
			obj.setAlmoxarifadoprincipal(null);
		}
		obj.setUsualt(UserService.authenticated().getUsername());
		obj.setDatalt(new Date(System.currentTimeMillis()));
		return repo.save(obj);
	}

	public Localizacao update(Localizacao obj) {
		//Localizacao newObj = find(obj.getId());
		obj.setUsualt(UserService.authenticated().getUsername());
		obj.setDatalt(new Date(System.currentTimeMillis()));
		//updateData(newObj, obj);
		return repo.save(obj);
	}
	
	@SuppressWarnings("unused")
	private void updateData(Localizacao newObj, Localizacao obj) {
		// TODO Auto-generated method stub
		newObj.setNome(obj.getNome());
		newObj.setUsualt(UserService.authenticated().getUsername());
		newObj.setDatalt(new Date(System.currentTimeMillis()));
	}	
	
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			// TODO: handle exception
			throw new DataIntegrityException("Não é possível excluir um Localizacao");
		}
	}

	public List<Localizacao> findAll() {
		// TODO Auto-generated method stub
		return repo.findAllByOrderByNome();
	}

	public List<Localizacao> findAllInsumoLocalizacao() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	public Page<Localizacao> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Localizacao fromDTO(LocalizacaoDTO objDto) {
		return new Localizacao(objDto.getId(), objDto.getNome().toUpperCase(), objDto.getAprovacao(),
				objDto.getUsualt(), objDto.getDatalt(), objDto.getDescarte(), objDto.getUtilizado(),
				objDto.getAlmoxarifadoprincipal(), objDto.getIrradiacao(), objDto.getAtualizaqtdminima(), 
				objDto.getGerasublote(), objDto.getResultado());
	}

	public Localizacao fromDTO(LocalizacaoNewDTO objDto) {
		Localizacao col = new Localizacao(null, objDto.getNome(), objDto.getAprovacao(), objDto.getUsualt(),
				objDto.getDatalt(), objDto.getDescarte(), objDto.getUtilizado(), objDto.getAlmoxarifadoprincipal(),
				objDto.getIrradiacao(), objDto.getAtualizaqtdminima(), 
				objDto.getGerasublote(), objDto.getResultado());
		return col;
	}

	public Boolean validaAlmoxarifadoPrincipal() {
		// TODO Auto-generated method stub
		return repo.validaAlmoxarifadoPrincipal();
	}

	public Localizacao findAlmoxPrincipal() {
		// TODO Auto-generated method stub
		return repo.findAlmoxPrincipal();
	}

	public Localizacao findByLocalizacaoUtilizado(Integer id) throws ObjectNotFoundException {
		
		return repo.findByLocalizacaoUtilizado(id);
	}
	
	public Localizacao findByLocalizacaoDescartado(Integer id) throws ObjectNotFoundException {
		
		return repo.findByLocalizacaoDescartado(id);
	}

	public List<Localizacao> findByAprovacaoTrue() {
		// TODO Auto-generated method stub
		return repo.findByAprovacaoTrue();
	}

	public List<Localizacao> findAllLocalizacoesFilhasByLocalizacaoPai(int id) {
		// TODO Auto-generated method stub
		return repo.findAllLocalizacoesFilhasByLocalizacaoPai(id);
	}

}
