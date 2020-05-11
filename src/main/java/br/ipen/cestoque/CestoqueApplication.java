package br.ipen.cestoque;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.ipen.cestoque.domain.Categoria;
import br.ipen.cestoque.domain.Colaborador;
import br.ipen.cestoque.dto.ColaboradorNewDTO;
import br.ipen.cestoque.repositories.CategoriaRepository;

@SpringBootApplication
public class CestoqueApplication implements CommandLineRunner{
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	public static void main(String[] args) {
		SpringApplication.run(CestoqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Categoria cat1 = new Categoria(null, "Informatica", "Usuario", new Date());
		Categoria cat2 = new Categoria(null, "Escritorio", "Usuario", new Date());
		
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2));
		
		//Colaborador col = new Colaborador(id, nome, cpf, usualt, datalt)
	}

}
