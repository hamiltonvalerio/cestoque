package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import br.ipen.cestoque.domain.Unidade;

public class UnidadeDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório!")
	private String nome;

	@NotEmpty(message = "Preenchimento obrigatório!")
	private String sigla;

	private String usualt;

	private Date datalt;

	public UnidadeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnidadeDTO(Unidade obj) {
		id = obj.getId();
		nome = obj.getNome();
		sigla = obj.getSigla();
		usualt = obj.getUsualt();
		datalt = obj.getDatalt();
	}

	public UnidadeDTO(Integer id, String nome, String sigla, String usualt, Date datalt) {
		super();
		this.id = id;
		this.nome = nome;
		this.sigla = sigla;
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

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
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
