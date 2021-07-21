package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

public class LocalizacaoNewDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@NotEmpty(message = "Preenchimento obrigatório!")
	private String nome;

	private String usualt;

	private Date datalt;

	private Boolean aprovacao;
	
	private Boolean descarte;
	
	private Boolean utilizado;
	
	private Boolean almoxarifadoprincipal;
	
	private Boolean irradiacao;
	
	private Boolean atualizaqtdminima;
	
	private Boolean gerasublote;

	public LocalizacaoNewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.toUpperCase();
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

	public Boolean getAlmoxarifadoprincipal() {
		return almoxarifadoprincipal;
	}

	public void setAlmoxarifadoprincipal(Boolean almoxarifadoprincipal) {
		this.almoxarifadoprincipal = almoxarifadoprincipal;
	}

	public Boolean getIrradiacao() {
		return irradiacao;
	}

	public void setIrradiacao(Boolean irradiacao) {
		this.irradiacao = irradiacao;
	}

	public Boolean getAtualizaqtdminima() {
		return atualizaqtdminima;
	}

	public void setAtualizaqtdminima(Boolean atualizaqtdminima) {
		this.atualizaqtdminima = atualizaqtdminima;
	}

	public Boolean getGerasublote() {
		return gerasublote;
	}

	public void setGerasublote(Boolean gerasublote) {
		this.gerasublote = gerasublote;
	}


	
}
