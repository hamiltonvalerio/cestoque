package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Audited
@Table(name = "localizacao")
public class Localizacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	@Column(name = "almoxarifadoprincipal", unique = true)
	private Boolean almoxarifadoprincipal = false;
	
	@Column(name = "irradiacao")
	private Boolean irradiacao = false;
	
	@Column(name = "atualizaqtdminima")
	private Boolean atualizaqtdminima = false;
		
	
	// @ManyToMany(mappedBy = "localizacoes")
	@JsonIgnore
	@OneToMany(mappedBy = "localizacao")
	private List<InsumoLocalizacao> insumolocalizacoes = new ArrayList<>();

	public Localizacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Localizacao(Integer id, String nome, Boolean aprovacao, String usualt, Date datalt,
			Boolean descarte, Boolean utilizado, Boolean almoxarifadoprincipal, Boolean irradiacao, Boolean atualizaqtdminima) {
		super();
		this.id = id;
		this.nome = nome;
		this.aprovacao = aprovacao;
		this.usualt = usualt;
		this.datalt = datalt;
		this.descarte = descarte;
		this.utilizado = utilizado;
		this.almoxarifadoprincipal = almoxarifadoprincipal;
		this.irradiacao = irradiacao;
		this.atualizaqtdminima = atualizaqtdminima;
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

	public Boolean getAprovacao() {
		return aprovacao;
	}

	public void setAprovacao(Boolean aprovacao) {
		this.aprovacao = aprovacao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Localizacao other = (Localizacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<InsumoLocalizacao> getInsumolocalizacoes() {
		return insumolocalizacoes;
	}

	public void setInsumolocalizacoes(List<InsumoLocalizacao> insumolocalizacoes) {
		this.insumolocalizacoes = insumolocalizacoes;
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

}
