package br.ipen.cestoque.services;

import java.util.Date;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.domain.ItemProduto;
import br.ipen.cestoque.domain.Produto;
import br.ipen.cestoque.repositories.ItemProdutoRepository;
import br.ipen.cestoque.repositories.ProdutoRepository;
import br.ipen.cestoque.services.exception.ObjectNotFoundException;


@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	
	@Autowired
	private ItemProdutoRepository itemProdutoRepository; 
	
	@Autowired
	private InsumoService insumoService;
	
	@Autowired
	private ColaboradorService colaboradorService;
		
	public Produto find(Integer id) throws ObjectNotFoundException {
		Optional<Produto> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
		"Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName()));
	}


	@Transactional
	public Produto insert(Produto obj) {
		obj.setId(null);
		obj.setData_produto(new Date());
		obj.setData_validade(new Date());
		obj.setUsualt("Hamilton");
		obj.setDatalt(new Date());
		obj.setColaborador(colaboradorService.find(obj.getColaborador().getId()));
		obj = repo.save(obj);
		for(ItemProduto ip : obj.getItens()) {
			ip.setInsumo(insumoService.find(ip.getInsumo().getId()));
			ip.setValor(ip.getInsumo().getValor());
			ip.setProduto(obj);
		}
		itemProdutoRepository.saveAll(obj.getItens());
		return obj;
	}
	
}
