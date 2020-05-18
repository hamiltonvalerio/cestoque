package br.ipen.cestoque.domain;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ItemProducao implements Serializable{

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private ItemProducaoPK id = new ItemProducaoPK();

	private Double quantidade;


	public ItemProducao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemProducao(Produto produto, Producao producao, Double quantidade) {
		super();
		id.setProduto(produto);
		id.setProducao(producao);
		this.quantidade = quantidade;
	}
	
	@JsonIgnore
	public Produto getProduto() {
		return id.getProduto();
	}
	
	public void setProduto(Produto produto) {
		id.setProduto(produto);
	}

	public Producao getProducao() {
		return id.getProducao();
	}
	
	public void setProducao(Producao producao) {
		id.setProducao(producao);
	}

	public ItemProducaoPK getId() {
		return id;
	}

	public void setId(ItemProducaoPK id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
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
		ItemProducao other = (ItemProducao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(getProduto().getNome());
		builder.append(", Qtd: ");
		builder.append(getQuantidade());
		builder.append("\n");
		return builder.toString();
	}
	
	

}
