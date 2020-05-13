package br.ipen.cestoque;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.ipen.cestoque.domain.Categoria;
import br.ipen.cestoque.domain.Fornecedor;
import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.Localizacao;
import br.ipen.cestoque.domain.Unidade;
import br.ipen.cestoque.repositories.CategoriaRepository;
import br.ipen.cestoque.repositories.FornecedorRepository;
import br.ipen.cestoque.repositories.InsumoRepository;
import br.ipen.cestoque.repositories.LocalizacaoRepository;
import br.ipen.cestoque.repositories.UnidadeRepository;

@SpringBootApplication
public class CestoqueApplication implements CommandLineRunner{
	
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
	
	public static void main(String[] args) {
		SpringApplication.run(CestoqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null, "Categoria 01", "Hamilton", new Date());
		Categoria cat2 = new Categoria(null, "Categoria 02", "Hamilton", new Date());
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		Unidade un1 = new Unidade(null, "UN", "Hamilton", new Date()); 
		Unidade un2 = new Unidade(null, "ML", "Hamilton", new Date());
		Unidade un3 = new Unidade(null, "G", "Hamilton", new Date());
		unidadeRepository.saveAll(Arrays.asList(un1,un2,un3));
		
		Fornecedor f1 = new Fornecedor(null, "Teste de Fornecedor", "02114428000190", "Hamilton", new Date());
		Fornecedor f2 = new Fornecedor(null, "Teste de Fornecedor2", "02114428000190", "Hamilton", new Date());
		fornecedorRepository.saveAll(Arrays.asList(f1,f2));
		
		Localizacao l1 = new Localizacao(null, "BUFFER RL", "Hamilton", new Date());
		Localizacao l2 = new Localizacao(null, "CONTROLE DE QUALIDADE", "Hamilton", new Date());
		localizacaoRepository.saveAll(Arrays.asList(l1,l2));
		
		Insumo i1 = new Insumo(null, "bandeja de liofilizador estéril", "BANDEJA DE ACO INOXIDAVEL P/LIOFILIZADOS", 0.0, 8171, "", true, new Date(), 3.0, "hamilton", new Date(), un1);
		Insumo i2 = new Insumo(null, "ACIDO ASCORBICO PARA PREPARO DE SOLUCAO", "ACIDO ASCORBICO PA REF.A5960 (FR 100G) SIGMA", 0.0, 7588, "", true, new Date(), 1.0, "hamilton", new Date(), un2);
		Insumo i3 = new Insumo(null, "ACETATO DE SODIO TRIHIDRATADO FR. 500G (106267) MERCK", "ACETATO DE SODIO 10%", 0.0, 7588, "", true, new Date(), 5.0, "hamilton", new Date(), un2);
		
		i1.setCategorias(Arrays.asList(cat1));
		i2.setCategorias(Arrays.asList(cat1));
		i3.setCategorias(Arrays.asList(cat2));
		
		i1.setUnidade(un1);
		i2.setUnidade(un2);
		i3.setUnidade(un2);
		
		insumoRepository.saveAll(Arrays.asList(i1,i2,i3));
	}

}
