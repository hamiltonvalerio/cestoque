package br.ipen.cestoque.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public class DadosComunsLocalizacoes {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String nome;

	private String usualt;

	private Date datalt;

	@Column(name = "aprovacao")
	private Boolean aprovacao = false;
	
	@Column(name = "descarte")
	private Boolean descarte = false;
	
	@Column(name = "utilizado")
	private Boolean utilizado = false;
	
	@Column(name = "almoxarifadoprincipal")
	private Boolean almoxarifadoprincipal = false;
	
	@Column(name = "irradiacao")
	private Boolean irradiacao = false;
	
	@Column(name = "atualizaqtdminima")
	private Boolean atualizaqtdminima = false;
	
	@Column(name = "localizacaofilha")
	private Boolean localizacaofilha = false;
	
	@Column(name = "gerasublote")
	private Boolean gerasublote = false;
	
	@Column(name = "resultado")
	private Boolean resultado = false;
	
	@OneToOne
	private Localizacao objlocalizacaofilha;
		
	

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

	public Boolean getAprovacao() {
		return aprovacao;
	}

	public void setAprovacao(Boolean aprovacao) {
		this.aprovacao = aprovacao;
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

	public Boolean getLocalizacaofilha() {
		return localizacaofilha;
	}

	public void setLocalizacaofilha(Boolean localizacaofilha) {
		this.localizacaofilha = localizacaofilha;
	}

	public Localizacao getObjlocalizacaofilha() {
		return objlocalizacaofilha;
	}

	public void setObjlocalizacaofilha(Localizacao objlocalizacaofilha) {
		this.objlocalizacaofilha = objlocalizacaofilha;
	}

	public Boolean getGerasublote() {
		return gerasublote;
	}

	public void setGerasublote(Boolean gerasublote) {
		this.gerasublote = gerasublote;
	}

	public Boolean getResultado() {
		return resultado;
	}

	public void setResultado(Boolean resultado) {
		this.resultado = resultado;
	}

}
