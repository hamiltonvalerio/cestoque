package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.InsumoMovimentacao;

public class InsumoMovimentacaoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	// private Integer id_insumo;

	// private String nome_insumo;

	private Insumo insumo;

	private Double quantidadeOrigem;

	private Double quantidadeMovimentada;

	private String loteFornecedor;

	private String loteCR;

	private String loteProducao;

	private String loteRecebimento;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataIrradiacao;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataValidade;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataAprovacao;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataReproprovacao;

	private Boolean aprovado;

	public InsumoMovimentacaoDTO() {

	}

	public InsumoMovimentacaoDTO(InsumoMovimentacao obj) {
		super();
		this.id = obj.getId();
		this.insumo = obj.getInsumo();
		this.quantidadeOrigem = obj.getQuantidadeOrigem();
		this.quantidadeMovimentada = obj.getQuantidadeMovimentada();
		this.loteFornecedor = obj.getLoteFornecedor();
		this.loteCR = obj.getLoteCR();
		this.loteProducao = obj.getLoteProducao();
		this.dataIrradiacao = obj.getDataIrradiacao();
		this.dataValidade = obj.getDataValidade();
		this.dataAprovacao = obj.getDataAprovacao();
		this.dataReproprovacao = obj.getDataReprovacao();
		this.aprovado = obj.getAprovado();
		this.loteRecebimento = obj.getLoteRecebimento();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
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

	public String getLoteRecebimento() {
		return loteRecebimento;
	}

	public void setLoteRecebimento(String loteRecebimento) {
		this.loteRecebimento = loteRecebimento;
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

	public Date getDataReproprovacao() {
		return dataReproprovacao;
	}

	public void setDataReproprovacao(Date dataReproprovacao) {
		this.dataReproprovacao = dataReproprovacao;
	}

	public Boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}

}
