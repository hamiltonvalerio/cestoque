package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import br.ipen.cestoque.domain.Localizacao;

public class LocalizacaoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Preenchimento obrigatório!")
	private String nome;

	private String usualt;

	private Date datalt;

	private Boolean aprovacao = false;
	
	private Boolean descarte = false;
	
	private Boolean utilizado = false;

	public LocalizacaoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalizacaoDTO(Localizacao obj) {
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.aprovacao = obj.getAprovacao();
		this.usualt = obj.getUsualt();
		this.datalt = obj.getDatalt();
		this.descarte = obj.getDescarte();
		this.utilizado = obj.getUtilizado();
	}

	public LocalizacaoDTO(Integer id, String nome, Boolean aprovacao, String usualt, Date datalt,
			 Boolean descarte, Boolean utilizado) {
		super();
		this.id = id;
		this.nome = nome;
		this.aprovacao = aprovacao;
		this.usualt = usualt;
		this.datalt = datalt;
		this.descarte = descarte;
		this.utilizado = utilizado;
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

	public Boolean getAprovacao() {
		return aprovacao;
	}

	public void setAprovacao(Boolean aprovacao) {
		this.aprovacao = aprovacao;
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

	public Boolean getDescarte() {
		return descarte;
	}

	public void setDescarte(Boolean descarte) {
		this.descarte = descarte;
	}

	public Boolean getUtilizado() {
		return utilizado;
	}

	public void setUtilizado(Boolean utilizado) {
		this.utilizado = utilizado;
	}
	
	

}
