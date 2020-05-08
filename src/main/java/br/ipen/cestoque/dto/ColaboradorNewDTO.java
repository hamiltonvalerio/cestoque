package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class ColaboradorNewDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cpf;
	
	private Set<String> telefones = new HashSet<>();
	
}
