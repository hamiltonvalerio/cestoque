package br.ipen.cestoque.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemProduto implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemProdutoPK id = new ItemProdutoPK();

	private Double quantidade;
	private Double valor;

	public ItemProduto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemProduto(Produto produto, Insumo insumo, Double quantidade, Double valor) {
		super();
		id.setProduto(produto);
		id.setInsumo(insumo);
		this.quantidade = quantidade;
		this.valor = valor;
	}
	
	@JsonIgnore
	public Produto getProduto() {
		return id.getProduto();
	}

	public Insumo getInsumo() {
		return id.getInsumo();
	}

	public ItemProdutoPK getId() {
		return id;
	}

	public void setId(ItemProdutoPK id) {
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
		ItemProduto other = (ItemProduto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
