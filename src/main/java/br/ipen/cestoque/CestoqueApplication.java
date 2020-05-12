package br.ipen.cestoque;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.ipen.cestoque.domain.Categoria;
import br.ipen.cestoque.domain.Unidade;
import br.ipen.cestoque.repositories.CategoriaRepository;
import br.ipen.cestoque.repositories.UnidadeRepository;

@SpringBootApplication
public class CestoqueApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private UnidadeRepository unidadeRepository;

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
		
		
		
		//Colaborador col = new Colaborador(id, nome, cpf, usualt, datalt)
	}

}
