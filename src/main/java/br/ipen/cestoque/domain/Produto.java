package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Produto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private Date data_produto;
	private String usualt;
	private Date datalt;
	
	@ManyToOne
	@JoinColumn(name = "colaborador_id")
	private Colaborador colaborador;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "produto")
	private Producao producao;
	
	@OneToMany(mappedBy = "id.produto")
	private Set<ItemProduto> itens = new HashSet<>();

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produto(Integer id, Date data_produto, String usualt, Date datalt, Colaborador colaborador,
			Producao producao) {
		super();
		this.id = id;
		this.data_produto = data_produto;
		this.usualt = usualt;
		this.datalt = datalt;
		this.colaborador = colaborador;
		this.producao = producao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData_produto() {
		return data_produto;
	}

	public void setData_produto(Date data_produto) {
		this.data_produto = data_produto;
	}

	public String getUsualt() {
		return usualt;
	}

	public void setUsualt(String usualt) {
		this.usualt = usualt;
	}

	public Date getDatalt() {
		return datalt;
	}

	public void setDatalt(Date datalt) {
		this.datalt = datalt;
	}

	public Colaborador getColaborador() {
		return colaborador;
	}

	public void setColaborador(Colaborador colaborador) {
		this.colaborador = colaborador;
	}

	public Producao getProducao() {
		return producao;
	}

	public void setProducao(Producao producao) {
		this.producao = producao;
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
		Produto other = (Produto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Set<ItemProduto> getItens() {
		return itens;
	}

	public void setItens(Set<ItemProduto> itens) {
		this.itens = itens;
	}
	
	
	
	
	
}
