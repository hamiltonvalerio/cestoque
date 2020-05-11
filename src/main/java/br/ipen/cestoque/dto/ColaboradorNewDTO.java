package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class ColaboradorNewDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String cpf;
	private String usualt;
	private Date datalt;
	
	private Set<String> telefones = new HashSet<>();
	
	private Set<String> emails = new HashSet<>();

	public ColaboradorNewDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public Set<String> getTelefones() {
		return telefones;
	}

	public void setTelefones(Set<String> telefones) {
		this.telefones = telefones;
	}

	public Set<String> getEmails() {
		return emails;
	}

	public void setEmails(Set<String> emails) {
		this.emails = emails;
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
