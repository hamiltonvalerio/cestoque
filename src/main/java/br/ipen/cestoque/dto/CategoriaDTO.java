package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import br.ipen.cestoque.domain.Categoria;

public class CategoriaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	private Integer id;
	
	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;
	
	private String usualt;
	private Date datalt;

	
	public CategoriaDTO(Categoria obj) {
		id = obj.getId();
		nome = obj.getNome();
		usualt = obj.getUsualt();
		datalt = obj.getDatalt();
	}
	
	public CategoriaDTO(Integer id, @NotEmpty(message = "Preenchimento obrigatório") String nome, String usualt,
			Date datalt) {
		super();
		this.id = id;
		this.nome = nome;
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
