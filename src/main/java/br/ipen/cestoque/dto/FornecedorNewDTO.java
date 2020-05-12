package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import br.ipen.cestoque.services.validation.ColaboradorInsert;

@ColaboradorInsert
public class FornecedorNewDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String cnpj;
	
	private String usualt;
	
	private Date datalt;


	public FornecedorNewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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
