package br.ipen.cestoque.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InsumoSaida {

	@JsonIgnore
	@EmbeddedId
	private InsumoSaidaPK id = new InsumoSaidaPK();
	
	private Double quantidade;
	private Double valor;
	
	public InsumoSaida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsumoSaida(Insumo insumo, Saida saida, Double quantidade, Double valor) {
		super();
		id.setInsumo(insumo);
		id.setSaida(saida);
		this.quantidade = quantidade;
		this.setValor(valor);
	}
	
	@JsonIgnore
	public Saida getSaida() {
		return id.getSaida();
	}
	
	public Insumo getInsumo() {
		return id.getInsumo();
	}

	public InsumoSaidaPK getId() {
		return id;
	}

	public void setId(InsumoSaidaPK id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}
	
	
	
}
