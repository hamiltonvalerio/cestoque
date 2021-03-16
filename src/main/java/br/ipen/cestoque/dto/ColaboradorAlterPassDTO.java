package br.ipen.cestoque.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import br.ipen.cestoque.domain.Colaborador;
import br.ipen.cestoque.services.validation.ColaboradorInsert;

@ColaboradorInsert
public class ColaboradorAlterPassDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório!")
	@Email(message = "Email inválido")
	private String email;

	@NotEmpty(message = "Preenchimento obrigatório!")
	private String senha;

	public ColaboradorAlterPassDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ColaboradorAlterPassDTO(Colaborador obj) {
		super();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
	}

	public ColaboradorAlterPassDTO(String email, String senha) {
		super();
		this.email = email;
		this.senha = senha;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
