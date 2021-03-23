package br.ipen.cestoque.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.domain.Categoria;
import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.InsumoLocalizacao;
import br.ipen.cestoque.dto.InsumoDTO;
import br.ipen.cestoque.dto.InsumoNewDTO;
import br.ipen.cestoque.repositories.CategoriaRepository;
import br.ipen.cestoque.repositories.InsumoLocalizacaoRepository;
import br.ipen.cestoque.repositories.InsumoRepository;
import br.ipen.cestoque.services.exception.DataIntegrityException;
import br.ipen.cestoque.services.exception.ObjectNotFoundException;

@Service
public class InsumoService {

	@Autowired
	private InsumoRepository repo;
	
	@Autowired
	private InsumoLocalizacaoRepository insumoLocalizacaoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Insumo find(Integer id) throws ObjectNotFoundException {
		Optional<Insumo> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Insumo.class.getName()));
	}

	public Page<Insumo> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy,
			String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		List<Categoria> categorias = categoriaRepository.findAllById(ids);
		return repo.search(nome, categorias, pageRequest);
	}

	public Insumo fromDTO(@Valid InsumoDTO objDto) {
		return new Insumo(objDto.getId(), 
				objDto.getNomenclatura(), 
				objDto.getNome(), 
				objDto.getValor(), 
				objDto.getCodigoalmox(), 
				objDto.getObservacao(), 
				objDto.getEssencial(), 
				objDto.getDatavalidade(), 
				objDto.getQuantidade(), 
				objDto.getTaxadeconsumo(), 
				objDto.getCodigobarra(), 
				objDto.getQrcode(), 
				objDto.getRfid(), 
				objDto.getUsualt(), 
				objDto.getDatalt(), 
				objDto.getUnidade(),
				objDto.getCodinsumofornecedor(),
				objDto.getIrradiado(),
				objDto.getDatairradiado(),
				objDto.getAmostracq(),
				objDto.getDataamostracq(),
				objDto.getLote()
				);
	}
	
	public Insumo fromDTO(@Valid InsumoNewDTO objDto) {
		return new Insumo(null, 
				objDto.getNomenclatura(), 
				objDto.getNome(), 
				objDto.getValor(), 
				objDto.getCodigo_almox(), 
				objDto.getObservacao(), 
				objDto.getEssencial(), 
				objDto.getData_validade(), 
				objDto.getQuantidade(), 
				objDto.getTaxa_de_consumo(), 
				objDto.getCodigo_barra(), 
				objDto.getQrcode(), 
				objDto.getRfid(), 
				objDto.getUsualt(), 
				objDto.getDatalt(), 
				objDto.getUnidade(),
				objDto.getCod_insumo_fornecedor(),
				objDto.getIrradiado(),
				objDto.getData_irradiado(),
				objDto.getAmostra_cq(),
				objDto.getData_amostra_cq(),
				objDto.getLote()
				);
	}

	public Insumo insert(Insumo obj) {
		// TODO Auto-generated method stub
		obj.setUsualt(UserService.authenticated().getUsername());
		obj.setDatalt(new Date(System.currentTimeMillis()));
		obj.setId(null);
		return repo.save(obj);
	}
	
	public Insumo update(Insumo obj) {
		Insumo up = find(obj.getId());
		updateData(up, obj);
		return repo.save(up);
	}

	private void updateData(Insumo up, Insumo obj) {
		up.setNome(obj.getNome());
	}
	
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		find(id);
		try {
			repo.deleteById(id);
		} catch (DataIntegrityViolationException e) {
			// TODO: handle exception
			throw new DataIntegrityException("Não é possível excluir um Insumo");
		}
	}
	
	public List<Insumo> findAll(){
		return repo.findAllByOrderByNomeAsc();
	}
	
	public Page<Insumo> findPage(Integer page, Integer linesPerPage, String orderBy, String direction){
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		return repo.findAll(pageRequest);
	}

	public Page<Insumo> findByLocalizacao(Integer localizacao_id, Integer page, Integer linesPerPage, String orderBy,
			String direction) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		// TODO Auto-generated method stub
		return repo.findByLocalizacaoId(localizacao_id , pageRequest);
	}
	
	public List<Insumo> buscaporlocalizacaonopage(Integer localizacao_id) {
		// TODO Auto-generated method stub
		return repo.buscaporlocalizacaonopage(localizacao_id);
	}
	
	public List<InsumoLocalizacao> buscatodosporlocalizacaonopage(Integer localizacao_id) {
		// TODO Auto-generated method stub
		return insumoLocalizacaoRepository.findAllByLocalizacao_id(localizacao_id);
	}

	public Page<InsumoLocalizacao> findInsumoLocalizacaoByLocalizacao(int localizacao_id, Integer page, Integer linesPerPage) {
		PageRequest pageRequest = PageRequest.of(page, linesPerPage);
		
		// TODO Auto-generated method stub
		return insumoLocalizacaoRepository.buscaTodosPorLocalizacao(localizacao_id,pageRequest);
	}

	public Long findTotalCadastrados() {
		// TODO Auto-generated method stub
		return insumoLocalizacaoRepository.count();
	}
	
	
}
