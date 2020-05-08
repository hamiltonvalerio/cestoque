package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import br.ipen.cestoque.domain.Colaborador;


public class ColaboradorDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String nome;
	
	private String cpf;
	
	private String usualt;
	
	private Date datalt;
	
	
	public ColaboradorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public ColaboradorDTO(Colaborador obj) {
		id = obj.getId();
		nome = obj.getNome();
		cpf = obj.getCpf();
		usualt = obj.getUsualt();
		datalt = obj.getDatalt();
	}

	public ColaboradorDTO(Integer id, String nome, String cpf, String usualt, Date datalt) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.usualt = usualt;
		this.datalt = datalt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getUsualt() {
		return usualt;
	}

	public void setUsualt(String usualt) {
		this.usualt = usualt;
	}

	public Date getDatalt() {
		return datalt;
	}

	public void setDatalt(Date datalt) {
		this.datalt = datalt;
	}
	
	


	
}
