package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Audited
@Table(name = "localizacao")
public class Localizacao extends DadosComunsLocalizacoes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
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
		this.setId(id);
		this.setNome(nome);
		this.setAprovacao(aprovacao);
		this.setUsualt(usualt);
		this.setDatalt(datalt);
		this.setDescarte(descarte);
		this.setUtilizado(utilizado);
		this.setAlmoxarifadoprincipal(almoxarifadoprincipal);
		this.setIrradiacao(irradiacao);
		this.setAtualizaqtdminima(atualizaqtdminima);
	}
	
	public List<InsumoLocalizacao> getInsumolocalizacoes() {
		return insumolocalizacoes;
	}

	public void setInsumolocalizacoes(List<InsumoLocalizacao> insumolocalizacoes) {
		this.insumolocalizacoes = insumolocalizacoes;
	}

	
	
	
}
