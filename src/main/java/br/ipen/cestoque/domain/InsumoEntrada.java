package br.ipen.cestoque.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InsumoEntrada {

	@JsonIgnore
	@EmbeddedId
	private InsumoEntradaPK id = new InsumoEntradaPK();
	
	private Double quantidade;
	private Double valor;
	
	public InsumoEntrada() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsumoEntrada(Insumo insumo, Entrada entrada, Double quantidade, Double valor) {
		super();
		id.setInsumo(insumo);
		id.setEntrada(entrada);
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	@JsonIgnore
	public Entrada getEntrada() {
		return id.getEntrada();
	}
	
	public Insumo getInsumo() {
		return id.getInsumo();
	}

	public InsumoEntradaPK getId() {
		return id;
	}

	public void setId(InsumoEntradaPK id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}
	
	
	
}
