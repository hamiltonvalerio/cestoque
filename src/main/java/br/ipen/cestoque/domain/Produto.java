package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Produto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private Double quantidade;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date data_produto;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date data_validade;
	
	private String usualt;
	private Date datalt;
	
	@ManyToOne
	@JoinColumn(name = "colaborador_id")
	private Colaborador colaborador;
	
	//@JsonIgnore
	@OneToMany(mappedBy = "id.produto")
	private Set<ItemProduto> itens = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.produto")
	private Set<ItemProducao> itensProducao = new HashSet<>();

	public Produto() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Produto(Integer id, String nome, Double quantidade, Date data_produto, String usualt, Date datalt, Colaborador colaborador, Date data_validade) {
		super();
		this.id = id;
		this.nome = nome;
		this.quantidade = quantidade;
		this.data_produto = data_produto;
		this.usualt = usualt;
		this.datalt = datalt;
		this.colaborador = colaborador;
		this.data_validade = data_validade;
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

	public Date getData_validade() {
		return data_validade;
	}

	public void setData_validade(Date data_validade) {
		this.data_validade = data_validade;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		StringBuilder builder = new StringBuilder();
		builder.append("Data: ");
		builder.append(sdf.format(getData_produto()));
		builder.append(", Nome: ");
		builder.append(getNome());
		builder.append(", Inserido por: ");
		builder.append(getColaborador().getNome());
		builder.append("\nDetalhes:\n");
		for(ItemProduto ip : getItens()) {
			builder.append(ip.toString());
		}
		return builder.toString();
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Set<ItemProducao> getItensProducao() {
		return itensProducao;
	}

	public void setItensProducao(Set<ItemProducao> itensProducao) {
		this.itensProducao = itensProducao;
	}
	
	
	
	
}
