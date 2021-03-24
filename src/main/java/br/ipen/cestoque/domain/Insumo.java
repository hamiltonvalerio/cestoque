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
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DynamicUpdate(value = true)
public class Insumo implements Serializable {

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
	private String codigoalmox;
	private String observacao;
	private Boolean essencial;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date datavalidade;

	private Double quantidade;
	private Double taxadeconsumo;
	private String codigobarra;
	private String qrcode;
	private String rfid;

	private String usualt;
	private Date datalt;

	private Integer codinsumofornecedor;
	private Boolean irradiado;
	private Date datairradiado;
	private Boolean amostracq;
	private Date dataamostracq;
	private String lote;

	@Transient
	private String nomecodalmox;

	@Transient
	private Double quantidademinima;

	@Transient
	private Integer codlocalizacaoIE;

	
	@ManyToMany
	@JoinTable(name = "INSUMO_CATEGORIA", joinColumns = @JoinColumn(name = "insumo_id"), inverseJoinColumns = @JoinColumn(name = "categoria_id"))
	private List<Categoria> categorias = new ArrayList<>();

	@JsonIgnore
	@ManyToMany
	@JoinTable(name = "INSUMO_FORNECEDOR", joinColumns = @JoinColumn(name = "insumo_id"), inverseJoinColumns = @JoinColumn(name = "fornecedor_id"))
	private List<Fornecedor> fornecedores = new ArrayList<>();

	/*
	 * @JsonIgnore
	 * 
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "INSUMO_LOCALIZACAO", joinColumns = @JoinColumn(name =
	 * "insumo_id"), inverseJoinColumns = @JoinColumn(name = "localizacao_id") )
	 */

	@JsonIgnore
	@OneToMany(mappedBy = "id.insumo")
	private Set<ItemProduto> itens = new HashSet<>();

	@ManyToOne
	@JoinColumn(name = "unidade_id")
	private Unidade unidade;

	public Insumo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Insumo(Integer id, String nomenclatura, String nome, Double valor, String codigoalmox, String observacao,
			Boolean essencial, Date datavalidade, Double quantidade, Double taxadeconsumo, String codigobarra,
			String qrcode, String rfid, String usualt, Date datalt, Unidade unidade, Integer codinsumofornecedor,
			Boolean irradiado, Date datairradiado, Boolean amostracq, Date dataamostracq, String lote, List<Categoria> categorias) {
		super();
		this.id = id;
		this.nomenclatura = nomenclatura;
		this.nome = nome;
		this.valor = valor;
		this.codigoalmox = codigoalmox;
		this.observacao = observacao;
		this.essencial = essencial;
		this.datavalidade = datavalidade;
		this.quantidade = quantidade;
		this.taxadeconsumo = taxadeconsumo;
		this.codigobarra = codigobarra;
		this.qrcode = qrcode;
		this.rfid = rfid;
		this.usualt = usualt;
		this.datalt = datalt;
		this.setUnidade(unidade);
		this.codinsumofornecedor = codinsumofornecedor;
		this.irradiado = irradiado;
		this.datairradiado = datairradiado;
		this.amostracq = amostracq;
		this.dataamostracq = dataamostracq;
		this.lote = lote;
		this.nomecodalmox = nome + " - " + codigoalmox;
		this.categorias = categorias;
	}
	
	

	
	@JsonIgnore
	public List<Produto> getProdutos() {
		List<Produto> lista = new ArrayList<>();
		for (ItemProduto i : itens) {
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

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public String getRfid() {
		return rfid;
	}

	public void setRfid(String rfid) {
		this.rfid = rfid;
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

	public Boolean getIrradiado() {
		return irradiado;
	}

	public void setIrradiado(Boolean irradiado) {
		this.irradiado = irradiado;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getCodigoalmox() {
		return codigoalmox;
	}

	public void setCodigoalmox(String codigoalmox) {
		this.codigoalmox = codigoalmox;
	}

	public Date getDatavalidade() {
		return datavalidade;
	}

	public void setDatavalidade(Date datavalidade) {
		this.datavalidade = datavalidade;
	}

	public Double getTaxadeconsumo() {
		return taxadeconsumo;
	}

	public void setTaxadeconsumo(Double taxadeconsumo) {
		this.taxadeconsumo = taxadeconsumo;
	}

	public String getCodigobarra() {
		return codigobarra;
	}

	public void setCodigobarra(String codigobarra) {
		this.codigobarra = codigobarra;
	}

	public Integer getCodinsumofornecedor() {
		return codinsumofornecedor;
	}

	public void setCodinsumofornecedor(Integer codinsumofornecedor) {
		this.codinsumofornecedor = codinsumofornecedor;
	}

	public Date getDatairradiado() {
		return datairradiado;
	}

	public void setDatairradiado(Date datairradiado) {
		this.datairradiado = datairradiado;
	}

	public Boolean getAmostracq() {
		return amostracq;
	}

	public void setAmostracq(Boolean amostracq) {
		this.amostracq = amostracq;
	}

	public Date getDataamostracq() {
		return dataamostracq;
	}

	public void setDataamostracq(Date dataamostracq) {
		this.dataamostracq = dataamostracq;
	}

	public String getNomecodalmox() {
		if (this.nome != null && this.codigoalmox != null) {
			this.setCodigoalmox(this.nome + " - " + this.codigoalmox);
		}
		return nomecodalmox;
	}

	public void setNomecodalmox(String nome_codalmox) {
		this.nomecodalmox = nome_codalmox;
	}

	public Double getQuantidademinima() {
		return quantidademinima;
	}

	public void setQuantidademinima(Double quantidademinima) {
		this.quantidademinima = quantidademinima;
	}

	public Integer getCodlocalizacaoIE() {
		return codlocalizacaoIE;
	}

	public void setCodlocalizacaoIE(Integer codlocalizacaoIE) {
		this.codlocalizacaoIE = codlocalizacaoIE;
	}

}
