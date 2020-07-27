package br.ipen.cestoque.services;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.ipen.cestoque.domain.Categoria;
import br.ipen.cestoque.domain.Colaborador;
import br.ipen.cestoque.domain.Fornecedor;
import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.InsumoLocalizacao;
import br.ipen.cestoque.domain.ItemProduto;
import br.ipen.cestoque.domain.Localizacao;
import br.ipen.cestoque.domain.Produto;
import br.ipen.cestoque.domain.Unidade;
import br.ipen.cestoque.repositories.CategoriaRepository;
import br.ipen.cestoque.repositories.ColaboradorRepository;
import br.ipen.cestoque.repositories.FornecedorRepository;
import br.ipen.cestoque.repositories.InsumoLocalizacaoRepository;
import br.ipen.cestoque.repositories.InsumoRepository;
import br.ipen.cestoque.repositories.ItemProdutoRepository;
import br.ipen.cestoque.repositories.LocalizacaoRepository;
import br.ipen.cestoque.repositories.ProducaoRepository;
import br.ipen.cestoque.repositories.ProdutoRepository;
import br.ipen.cestoque.repositories.UnidadeRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private UnidadeRepository unidadeRepository;
	
	@Autowired
	private FornecedorRepository fornecedorRepository;

	@Autowired
	private LocalizacaoRepository localizacaoRepository;
	
	@Autowired
	private InsumoRepository insumoRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private ColaboradorRepository colaboradorRepository;
	
	@Autowired
	private ProducaoRepository producaoRepository;
	
	@Autowired
	private ItemProdutoRepository itemProdutoRepository;
	
	@Autowired
	private InsumoLocalizacaoRepository insumoLocalizacaoRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public void instantiateTestDatabase() {
		// TODO Auto-generated method stub
				Categoria cat1 = new Categoria(null, "Categoria 01", "Hamilton", new Date());
				Categoria cat2 = new Categoria(null, "Categoria 02", "Hamilton", new Date());
				categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
				
				Unidade un1 = new Unidade(null, "UNIDADE","UN", "Hamilton", new Date()); 
				Unidade un2 = new Unidade(null, "MILILITRO", "ML","Hamilton", new Date());
				Unidade un3 = new Unidade(null, "GRAMA", "GR", "Hamilton", new Date());
				unidadeRepository.saveAll(Arrays.asList(un1,un2,un3));
				
				Fornecedor f1 = new Fornecedor(null, "Teste de Fornecedor", "02114428000190", "Hamilton", new Date());
				Fornecedor f2 = new Fornecedor(null, "Teste de Fornecedor2", "02114428000190", "Hamilton", new Date());
				fornecedorRepository.saveAll(Arrays.asList(f1,f2));
				
				Localizacao l1 = new Localizacao(null, "BUFFER RL", "Hamilton", new Date());
				Localizacao l2 = new Localizacao(null, "CONTROLE DE QUALIDADE", "Hamilton", new Date());
				localizacaoRepository.saveAll(Arrays.asList(l1,l2));
				
				Insumo i1 = new Insumo(null, "bandeja de liofilizador estéril", "BANDEJA DE ACO INOXIDAVEL P/LIOFILIZADOS", 0.0, 8171, "", true, new Date(), 3.0,3.0,"","","","hamilton", new Date(), un1);
				Insumo i2 = new Insumo(null, "ACIDO ASCORBICO PARA PREPARO DE SOLUCAO", "ACIDO ASCORBICO PA REF.A5960 (FR 100G) SIGMA", 0.0, 7588, "", true, new Date(), 1.0, 1.0,"","","","hamilton", new Date(), un2);
				Insumo i3 = new Insumo(null, "ACETATO DE SODIO TRIHIDRATADO FR. 500G (106267) MERCK", "ACETATO DE SODIO 10%", 0.0, 7588, "", true, new Date(), 5.0, 5.0, "","","","hamilton", new Date(), un2);
				
				i1.setCategorias(Arrays.asList(cat1));
				i2.setCategorias(Arrays.asList(cat1));
				i3.setCategorias(Arrays.asList(cat2));
				
				i1.setUnidade(un1);
				i2.setUnidade(un2);
				i3.setUnidade(un2);
				
				i1.setFornecedores(Arrays.asList(f1));
				i2.setFornecedores(Arrays.asList(f1));
				i3.setFornecedores(Arrays.asList(f2));
				
				InsumoLocalizacao il1 = new InsumoLocalizacao(i1, l1, 2.0);
				InsumoLocalizacao il2 = new InsumoLocalizacao(i1, l2, 4.0);
				InsumoLocalizacao il3 = new InsumoLocalizacao(i2, l1, 3.0);
				
				i1.getLocalizacoes().addAll(Arrays.asList(il1,il2));
				i2.getLocalizacoes().addAll(Arrays.asList(il3));
				
				//i1.setLocalizacoes(Arrays.asList(il1));
				//i2.setLocalizacoes(Arrays.asList(il2));
				//i3.setLocalizacoes(Arrays.asList(il3));
				
				insumoRepository.saveAll(Arrays.asList(i1,i2,i3));
				insumoLocalizacaoRepository.saveAll(Arrays.asList(il1,il2,il3));
				
				Colaborador c1 = new Colaborador(null, "Hamilton", "84025166100", "Hamilton", new Date(),bCryptPasswordEncoder.encode("123"),"htecmac@gmail.com");
				
				colaboradorRepository.save(c1);
				
				
				Produto p1 = new Produto(null, "DEX500-TEC",0.0,new Date(), "Hamilton", new Date(), c1, new Date()); 
				p1.setColaborador(c1);
				
				
				produtoRepository.save(p1);
			
				
				ItemProduto it1 = new ItemProduto(p1, i1, 1.0, 0.0);
				ItemProduto it2 = new ItemProduto(p1, i2, 2.0, 0.0);
				
				p1.getItens().addAll(Arrays.asList(it1,it2));
				
				i1.getItens().addAll(Arrays.asList(it1));
				i2.getItens().addAll(Arrays.asList(it2));
				
				itemProdutoRepository.saveAll(Arrays.asList(it1,it2));
				
				
	}
}
