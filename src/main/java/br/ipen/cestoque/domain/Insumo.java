package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Insumo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomenclatura;
	private String nome;
	private Double valor;
	private Integer codigo_almox;
	private String observacao;
	private Boolean essencial;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date data_validade;
	
	private Double quantidade;
	private String usualt;	
	private Date datalt;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "INSUMO_CATEGORIA", 
			joinColumns = @JoinColumn(name = "insumo_id"),
			inverseJoinColumns = @JoinColumn(name = "categoria_id")
			)
	private List<Categoria> categorias = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "INSUMO_FORNECEDOR", 
			joinColumns = @JoinColumn(name = "insumo_id"),
			inverseJoinColumns = @JoinColumn(name = "fornecedor_id")
			)
	private List<Fornecedor> fornecedores = new ArrayList<>();	
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "INSUMO_LOCALIZACAO", 
			joinColumns = @JoinColumn(name = "insumo_id"),
			inverseJoinColumns = @JoinColumn(name = "localizacao_id")
			)
	private List<Localizacao> localizacoes = new ArrayList<>();

	@JsonIgnore
	@OneToMany(mappedBy = "id.insumo")
	private Set<ItemProduto> itens = new HashSet<>();
	
	@JsonIgnore
	@OneToMany(mappedBy = "id.insumo")
	private Set<InsumoEntrada> entradas = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "unidade_id")
	private Unidade unidade;

	public Insumo(){
		super();
		// TODO Auto-generated constructor stub
	}

	public Insumo(Integer id, String nomenclatura, String nome, Double valor, Integer codigo_almox, String observacao,
			Boolean essencial, Date data_validade, Double quantidade, String usualt, Date datalt, Unidade uidade) {
		super();
		this.id = id;
		this.nomenclatura = nomenclatura;
		this.nome = nome;
		this.valor = valor;
		this.codigo_almox = codigo_almox;
		this.observacao = observacao;
		this.essencial = essencial;
		this.data_validade = data_validade;
		this.quantidade = quantidade;
		this.usualt = usualt;
		this.datalt = datalt;
		this.setUnidade(unidade);
	}
	
	@JsonIgnore
	public List<Produto> getProdutos(){
		List<Produto> lista = new ArrayList<>();
		for(ItemProduto i : itens) {
			lista.add(i.getProduto());
		}
		return lista;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomenclatura() {
		return nomenclatura;
	}

	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getCodigo_almox() {
		return codigo_almox;
	}

	public void setCodigo_almox(Integer codigo_almox) {
		this.codigo_almox = codigo_almox;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Boolean getEssencial() {
		return essencial;
	}

	public void setEssencial(Boolean essencial) {
		this.essencial = essencial;
	}

	public Date getData_validade() {
		return data_validade;
	}

	public void setData_validade(Date data_validade) {
		this.data_validade = data_validade;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
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

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
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
		Insumo other = (Insumo) obj;
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

	public Set<InsumoEntrada> getEntradas() {
		return entradas;
	}

	public void setEntradas(Set<InsumoEntrada> entradas) {
		this.entradas = entradas;
	}

	public List<Fornecedor> getFornecedores() {
		return fornecedores;
	}

	public void setFornecedores(List<Fornecedor> fornecedores) {
		this.fornecedores = fornecedores;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public List<Localizacao> getLocalizacoes() {
		return localizacoes;
	}

	public void setLocalizacoes(List<Localizacao> localizacoes) {
		this.localizacoes = localizacoes;
	}
	
	
	
}
