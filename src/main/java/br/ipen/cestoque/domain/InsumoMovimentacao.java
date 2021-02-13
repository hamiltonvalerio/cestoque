package br.ipen.cestoque.domain;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InsumoMovimentacao{

	
	@JsonIgnore
	@EmbeddedId
	private InsumoMovimentacaoPK id = new InsumoMovimentacaoPK();
	
	private Double quantidadeOrigem;
	
	private Double quantidadeMovimentada;
	

	public InsumoMovimentacao() {
		super();
		// TODO Auto-generated constructor stub
	}


	public InsumoMovimentacao(Insumo insumo, Movimentacao movimentacao, Double quantidadeOrigem, Double quantidadeMovimentada) {
		super();
		id.setInsumo(insumo);
		id.setMovimentacao(movimentacao);
		this.quantidadeOrigem = quantidadeOrigem;
		this.quantidadeMovimentada = quantidadeMovimentada;
	}
	
	@JsonIgnore
	public Movimentacao getMovimentacao() {
		return id.getMovimentacao();
	}
	
	public void setMovimentacao(Movimentacao movimentacao) {
		id.setMovimentacao(movimentacao);
	}
	
	public Insumo getInsumo() {
		return id.getInsumo();
	}
	
	public void setInsumo(Insumo insumo) {
		id.setInsumo(insumo);
	}


	public InsumoMovimentacaoPK getId() {
		return id;
	}


	public void setId(InsumoMovimentacaoPK id) {
		this.id = id;
	}


	public Double getQuantidadeOrigem() {
		return quantidadeOrigem;
	}


	public void setQuantidadeOrigem(Double quantidadeOrigem) {
		this.quantidadeOrigem = quantidadeOrigem;
	}


	public Double getQuantidadeMovimentada() {
		return quantidadeMovimentada;
	}


	public void setQuantidadeMovimentada(Double quantidadeMovimentada) {
		this.quantidadeMovimentada = quantidadeMovimentada;
	}
	
	
	
	
	

}
