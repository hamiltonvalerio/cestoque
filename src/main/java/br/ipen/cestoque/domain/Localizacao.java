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

	@Column(name = "aprovacao", nullable = false)
	private Boolean aprovacao = false;
	
	@Column(name = "descarte", nullable = false)
	private Boolean descarte = false;
	
	@Column(name = "utilizado", nullable = false)
	private Boolean utilizado = false;

	// @ManyToMany(mappedBy = "localizacoes")
	@JsonIgnore
	@OneToMany(mappedBy = "localizacao")
	private List<InsumoLocalizacao> insumolocalizacoes = new ArrayList<>();

	public Localizacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Localizacao(Integer id, String nome, Boolean aprovacao, String usualt, Date datalt,
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
	
	

}
