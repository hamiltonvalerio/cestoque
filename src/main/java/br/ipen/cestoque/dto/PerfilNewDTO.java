package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class PerfilNewDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String descricao;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;

	private String usualt;

	private Date datalt;

	public PerfilNewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
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
