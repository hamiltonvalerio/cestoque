package br.ipen.cestoque.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Date data_produto;
	private String usualt;
	private Date datalt;
	
	private Colaborador colaborador;

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
