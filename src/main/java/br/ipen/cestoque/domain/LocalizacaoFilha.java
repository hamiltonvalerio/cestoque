package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DynamicUpdate
@Audited
@Table(name = "localizacaofilha")
public class LocalizacaoFilha extends DadosComunsLocalizacoes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "localizacao_id", nullable = false)
	private Localizacao localizacao;

	@JsonIgnore
	@OneToMany(mappedBy = "localizacao")
	private List<InsumoLocalizacao> insumolocalizacoes = new ArrayList<>();
	
	@Transient
	private Localizacao localizacaopai;

	public LocalizacaoFilha() {
		// TODO Auto-generated constructor stub
	}

	public LocalizacaoFilha(Integer id, Localizacao localizacao, String nome, Boolean aprovacao, String usualt, Date datalt, Boolean descarte,
			Boolean utilizado, Boolean almoxarifadoprincipal, Boolean irradiacao, Boolean atualizaqtdminima, Localizacao localizacaopai) {
		super();
		this.setId(id);
		this.localizacao = localizacao;
		this.setNome(nome);
		this.setAprovacao(aprovacao);
		this.setUsualt(usualt);
		this.setDatalt(datalt);
		this.setDescarte(descarte);
		this.setUtilizado(utilizado);
		this.setAlmoxarifadoprincipal(almoxarifadoprincipal);
		this.setIrradiacao(irradiacao);
		this.setAtualizaqtdminima(atualizaqtdminima);
		this.localizacaopai = localizacaopai;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public List<InsumoLocalizacao> getInsumolocalizacoes() {
		return insumolocalizacoes;
	}

	public void setInsumolocalizacoes(List<InsumoLocalizacao> insumolocalizacoes) {
		this.insumolocalizacoes = insumolocalizacoes;
	}

	public Localizacao getLocalizacaopai() {
		return localizacaopai;
	}

	public void setLocalizacaopai(Localizacao localizacaopai) {
		this.localizacaopai = localizacaopai;
	}

}
