package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import br.ipen.cestoque.services.validation.ColaboradorInsert;

@ColaboradorInsert
public class ColaboradorNewDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String nome;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String cpf;
	
	private String usualt;
	
	private Date datalt;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String senha;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	@Email(message="Email inválido")
	private String email;
	
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

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
