package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InsumoEntrada implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@EmbeddedId
	private InsumoEntradaPK id = new InsumoEntradaPK();
	
	private String loteFornecedor;
	private String loteCR;
	private Date dataIrradiacao;
	private Date dataVencIrradiacao;
	
	private Date dataValidade;
	
	private Double quantidade;
	private Double valor;
	
	private Double valorTotal;
	
	private String loteRecebimento;
	
	public InsumoEntrada() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsumoEntrada(Insumo insumo, Entrada entrada, String loteFornecedor, String loteCR, Date dataIrradiacao, Date dataVencIrradiacao,
			Date dataValidade, Double quantidade, Double valor, Double valorTotal, String loteRecebimento) {
		super();
		id.setInsumo(insumo);
		id.setEntrada(entrada);
		this.loteFornecedor = loteFornecedor;
		this.loteCR = loteCR;
		this.dataIrradiacao = dataIrradiacao;
		this.dataVencIrradiacao = dataVencIrradiacao;
		this.dataValidade = dataValidade;
		this.quantidade = quantidade;
		this.loteRecebimento = loteRecebimento;
		this.setValor(valor);
		this.setValorTotal(valorTotal);
	}
	
	@JsonIgnore
	public Entrada getEntrada() {
		return id.getEntrada();
	}
	
	public void setEntrada(Entrada entrada) {
		id.setEntrada(entrada);
	}
	
	public Insumo getInsumo() {
		return id.getInsumo();
	}
	
	public void setInsumo(Insumo insumo) {
		id.setInsumo(insumo);
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

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getLoteFornecedor() {
		return loteFornecedor;
	}

	public void setLoteFornecedor(String loteFornecedor) {
		this.loteFornecedor = loteFornecedor;
	}

	public String getLoteCR() {
		return loteCR;
	}

	public void setLoteCR(String loteCR) {
		this.loteCR = loteCR;
	}

	public Date getDataIrradiacao() {
		return dataIrradiacao;
	}

	public void setDataIrradiacao(Date dataIrradiacao) {
		this.dataIrradiacao = dataIrradiacao;
	}

	public Date getDataVencIrradiacao() {
		return dataVencIrradiacao;
	}

	public void setDataVencIrradiacao(Date dataVencIrradiacao) {
		this.dataVencIrradiacao = dataVencIrradiacao;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getLoteRecebimento() {
		return loteRecebimento;
	}

	public void setLoteRecebimento(String loteRecebimento) {
		this.loteRecebimento = loteRecebimento;
	}
	
	
	
	
	
}
