package br.ipen.cestoque.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InsumoLocalizacao {

	@JsonIgnore
	@EmbeddedId
	private InsumoLocalizacaoPK id = new InsumoLocalizacaoPK();
	
	private Double quantidade;
	
	public InsumoLocalizacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsumoLocalizacao(Insumo insumo, Localizacao localizacao, Double quantidade) {
		super();
		id.setInsumo(insumo);
		id.setLocalizacao(localizacao);
		this.quantidade = quantidade;
	}
	
	@JsonIgnore
	public Localizacao getLocalizacao() {
		return id.getLocalizacao();
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.id.setLocalizacao(localizacao);
	}
	
	public Insumo getInsumo() {
		return id.getInsumo();
	}
	
	public void setInsumo(Insumo insumo) {
		id.setInsumo(insumo);
	}

	public InsumoLocalizacaoPK getId() {
		return id;
	}

	public void setId(InsumoLocalizacaoPK id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

}
