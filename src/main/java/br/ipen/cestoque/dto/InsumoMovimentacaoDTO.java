package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.InsumoMovimentacao;

public class InsumoMovimentacaoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Insumo insumo;

	private Double quantidadeOrigem;

	private Double quantidadeMovimentada;

	private String loteFornecedor;

	private String loteCR;

	private String loteProducao;

	private String loteRecebimento;

	private LocalDateTime dataIrradiacao;

	private LocalDate dataValidade;

	private LocalDateTime dataAprovacao;

	private LocalDateTime dataReproprovacao;

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

	public LocalDateTime getDataIrradiacao() {
		return dataIrradiacao;
	}

	public void setDataIrradiacao(LocalDateTime dataIrradiacao) {
		this.dataIrradiacao = dataIrradiacao;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public LocalDateTime getDataAprovacao() {
		return dataAprovacao;
	}

	public void setDataAprovacao(LocalDateTime dataAprovacao) {
		this.dataAprovacao = dataAprovacao;
	}

	public LocalDateTime getDataReproprovacao() {
		return dataReproprovacao;
	}

	public void setDataReproprovacao(LocalDateTime dataReproprovacao) {
		this.dataReproprovacao = dataReproprovacao;
	}

	public Boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}

}
