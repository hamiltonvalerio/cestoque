package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import br.ipen.cestoque.domain.Perfil;

public class PerfilDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String descricao;

	@NotEmpty(message = "Preenchimento obrigatório")
	private String nome;

	private String usualt;

	private Date datalt;

	public PerfilDTO(Perfil obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.descricao = obj.getDescricao();
		this.usualt = obj.getUsualt();
		this.datalt = obj.getDatalt();
	}

	public PerfilDTO(Integer id, @NotEmpty(message = "Preenchimento obrigatório") String nome, String descricao,
			String usualt, Date datalt) {
		super();
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
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

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
