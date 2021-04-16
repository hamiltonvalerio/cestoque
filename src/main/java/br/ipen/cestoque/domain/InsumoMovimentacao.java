package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InsumoMovimentacao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "localizacao_id", nullable = false)
	private Localizacao localizacao;

	@ManyToOne
	@JoinColumn(name = "insumo_id", nullable = false)
	private Insumo insumo;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "movimentacao_id")
	private Movimentacao movimentacao;

	private Double quantidadeOrigem;

	private Double quantidadeMovimentada;

	private String loteFornecedor;

	private String loteCR;

	private String loteProducao;

	private String loteRecebimento;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataIrradiacao;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataValidade;

	private LocalDateTime dataAprovacao;

	private LocalDateTime dataReprovacao;

	private Boolean aprovado;

	public InsumoMovimentacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsumoMovimentacao(Integer id, Insumo insumo, Localizacao localizacao, Movimentacao movimentacao,
			Double quantidadeOrigem, Double quantidadeMovimentada, String loteFornecedor, String loteCR,
			String loteProducao, String loteRecebimento, LocalDate dataIrradiacao, LocalDate dataValidade,
			LocalDateTime dataAprovacao, LocalDateTime dataReprovacao, Boolean aprovado) {
		super();
		this.id = id;
		this.insumo = insumo;
		this.localizacao = localizacao;
		this.movimentacao = movimentacao;
		this.quantidadeOrigem = quantidadeOrigem;
		this.quantidadeMovimentada = quantidadeMovimentada;
		this.loteFornecedor = loteFornecedor;
		this.loteCR = loteCR;
		this.loteProducao = loteProducao;
		this.loteRecebimento = loteRecebimento;
		this.dataIrradiacao = dataIrradiacao;
		this.dataValidade = dataValidade;
		this.dataAprovacao = dataAprovacao;
		this.dataReprovacao = dataReprovacao;
		this.aprovado = aprovado;
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

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public Movimentacao getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
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

	public LocalDate getDataIrradiacao() {
		return dataIrradiacao;
	}

	public void setDataIrradiacao(LocalDate dataIrradiacao) {
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

	public LocalDateTime getDataReprovacao() {
		return dataReprovacao;
	}

	public void setDataReprovacao(LocalDateTime dataReprovacao) {
		this.dataReprovacao = dataReprovacao;
	}

	public Boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
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
		InsumoMovimentacao other = (InsumoMovimentacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
