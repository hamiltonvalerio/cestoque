package br.ipen.cestoque.domain;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InsumoMovimentacao{

	
	@JsonIgnore
	@EmbeddedId
	private InsumoMovimentacaoPK id = new InsumoMovimentacaoPK();
	
	private Double quantidadeOrigem;
	
	private Double quantidadeMovimentada;
	
	private String loteFornecedor;
	
	private String loteCR;
	
	private String loteProducao;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataIrradiacao;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataValidade;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataAprovacao;
	
	private Boolean aprovado;
	

	public InsumoMovimentacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@JsonIgnore
	public Movimentacao getMovimentacao() {
		return id.getMovimentacao();
	}
	
	public InsumoMovimentacao(Insumo insumo, Movimentacao movimentacao, Double quantidadeOrigem, Double quantidadeMovimentada, String loteFornecedor,
			String loteCR, String loteProducao, Date dataIrradiacao, Date dataValidade, Date dataAprovacao,
			Boolean aprovado) {
		super();
		id.setInsumo(insumo);
		id.setMovimentacao(movimentacao);
		this.quantidadeOrigem = quantidadeOrigem;
		this.quantidadeMovimentada = quantidadeMovimentada;
		this.loteFornecedor = loteFornecedor;
		this.loteCR = loteCR;
		this.loteProducao = loteProducao;
		this.dataIrradiacao = dataIrradiacao;
		this.dataValidade = dataValidade;
		this.dataAprovacao = dataAprovacao;
		this.aprovado = aprovado;
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


	public String getLoteProducao() {
		return loteProducao;
	}


	public void setLoteProducao(String loteProducao) {
		this.loteProducao = loteProducao;
	}


	public Date getDataIrradiacao() {
		return dataIrradiacao;
	}


	public void setDataIrradiacao(Date dataIrradiacao) {
		this.dataIrradiacao = dataIrradiacao;
	}


	public Date getDataValidade() {
		return dataValidade;
	}


	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}


	public Date getDataAprovacao() {
		return dataAprovacao;
	}


	public void setDataAprovacao(Date dataAprovacao) {
		this.dataAprovacao = dataAprovacao;
	}


	public Boolean getAprovado() {
		return aprovado;
	}


	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}
		
	

}
