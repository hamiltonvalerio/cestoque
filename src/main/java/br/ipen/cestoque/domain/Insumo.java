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
@DynamicUpdate(value=true)
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
	private String codigo_almox;
	private String observacao;
	private Boolean essencial;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date data_validade;
	
	private Double quantidade;
	private Double taxa_de_consumo;
	private String codigo_barra;
	private String qrcode;
	private String rfid;
	
	private String usualt;	
	private Date datalt;
	
	private Integer cod_insumo_fornecedor;
	private Boolean irradiado;
	private Date data_irradiado;
	private Boolean amostra_cq;
	private Date data_amostra_cq;
	private String lote;
	
	@Transient
	private String nome_codalmox;
	
	
	
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
	private List<InsumoLocalizacao> localizacoes = new ArrayList<>();

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
	

	

	
	public Insumo(Integer id, String nomenclatura, String nome, Double valor, String codigo_almox, String observacao,
			Boolean essencial, Date data_validade, Double quantidade, Double taxa_de_consumo, String codigo_barra,
			String qrcode, String rfid, String usualt, Date datalt, Unidade unidade, Integer cod_insumo_fornecedor, Boolean irradiado,
			Date data_irradiado, Boolean amostra_cq, Date data_amostra_cq, String lote) {
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
		this.taxa_de_consumo = taxa_de_consumo;
		this.codigo_barra = codigo_barra;
		this.qrcode = qrcode;
		this.rfid = rfid;
		this.usualt = usualt;
		this.datalt = datalt;
		this.setUnidade(unidade);
		this.cod_insumo_fornecedor = cod_insumo_fornecedor;
		this.irradiado = irradiado;
		this.data_irradiado = data_irradiado;
		this.amostra_cq = amostra_cq;
		this.data_amostra_cq = data_amostra_cq;
		this.lote = lote;
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

	public String getCodigo_almox() {
		return codigo_almox;
	}

	public void setCodigo_almox(String codigo_almox) {
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
	

	public String getCodigo_barra() {
		return codigo_barra;
	}


	public void setCodigo_barra(String codigo_barra) {
		this.codigo_barra = codigo_barra;
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

	


	public List<InsumoLocalizacao> getLocalizacoes() {
		return localizacoes;
	}


	public void setLocalizacoes(List<InsumoLocalizacao> localizacoes) {
		this.localizacoes = localizacoes;
	}


	public Double getTaxa_de_consumo() {
		return taxa_de_consumo;
	}


	public void setTaxa_de_consumo(Double taxa_de_consumo) {
		this.taxa_de_consumo = taxa_de_consumo;
	}


	public Integer getCod_insumo_fornecedor() {
		return cod_insumo_fornecedor;
	}


	public void setCod_insumo_fornecedor(Integer cod_insumo_fornecedor) {
		this.cod_insumo_fornecedor = cod_insumo_fornecedor;
	}


	public Boolean getIrradiado() {
		return irradiado;
	}


	public void setIrradiado(Boolean irradiado) {
		this.irradiado = irradiado;
	}


	public Date getData_irradiado() {
		return data_irradiado;
	}


	public void setData_irradiado(Date data_irradiado) {
		this.data_irradiado = data_irradiado;
	}


	public Boolean getAmostra_cq() {
		return amostra_cq;
	}


	public void setAmostra_cq(Boolean amostra_cq) {
		this.amostra_cq = amostra_cq;
	}


	public Date getData_amostra_cq() {
		return data_amostra_cq;
	}


	public void setData_amostra_cq(Date data_amostra_cq) {
		this.data_amostra_cq = data_amostra_cq;
	}


	public String getLote() {
		return lote;
	}


	public void setLote(String lote) {
		this.lote = lote;
	}





	public String getNome_codalmox() {
		if(this.nome != null && this.codigo_almox != null) {
			this.setCodigo_almox(this.nome + " - "+ this.codigo_almox);
		}
		return nome_codalmox;
	}





	public void setNome_codalmox(String nome_codalmox) {
		this.nome_codalmox = nome_codalmox;
	}
	
	
	
}
