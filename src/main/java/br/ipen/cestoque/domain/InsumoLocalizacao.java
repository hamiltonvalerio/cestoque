package br.ipen.cestoque.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DynamicUpdate
public class InsumoLocalizacao {

	@JsonIgnore
	@EmbeddedId
	private InsumoLocalizacaoPK id = new InsumoLocalizacaoPK();
	
	private Double quantidade;
	
	private Double quantidademinima;
	
	public InsumoLocalizacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsumoLocalizacao(Insumo insumo, Localizacao localizacao, Double quantidade, Double quantidademinima) {
		super();
		id.setInsumo(insumo);
		id.setLocalizacao(localizacao);
		this.setQuantidade(quantidade);
		this.setQuantidademinima(quantidademinima);
	}
	
	@JsonIgnore
	public Localizacao getLocalizacao() {
		return id.getLocalizacao();
	}

	public void setLocalizacao(Localizacao localizacao) {
		id.setLocalizacao(localizacao);
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

	public Double getQuantidademinima() {
		return quantidademinima;
	}

	public void setQuantidademinima(Double quantidademinima) {
		this.quantidademinima = quantidademinima;
	}

	

}
