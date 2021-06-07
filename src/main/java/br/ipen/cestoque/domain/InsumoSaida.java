package br.ipen.cestoque.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "insumosaida")
public class InsumoSaida implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
	public void setSaida(Saida saida) {
		id.setSaida(saida);
	}
	
	public Insumo getInsumo() {
		return id.getInsumo();
	}
	
	public void setInsumo(Insumo insumo) {
		id.setInsumo(insumo);
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
