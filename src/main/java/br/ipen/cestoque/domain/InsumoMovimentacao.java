package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
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

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataIrradiacao;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataValidade;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataAprovacao;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataReprovacao;

	private Boolean aprovado;

	public InsumoMovimentacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsumoMovimentacao(Integer id, Insumo insumo, Movimentacao movimentacao, Double quantidadeOrigem,
			Double quantidadeMovimentada, String loteFornecedor, String loteCR, String loteProducao,
			Date dataIrradiacao, Date dataValidade, Date dataAprovacao, Date dataReprovacao, Boolean aprovado) {
		super();
		this.id = id;
		this.insumo = insumo;
		this.movimentacao = movimentacao;
		this.quantidadeOrigem = quantidadeOrigem;
		this.quantidadeMovimentada = quantidadeMovimentada;
		this.loteFornecedor = loteFornecedor;
		this.loteCR = loteCR;
		this.loteProducao = loteProducao;
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

	public Date getDataReprovacao() {
		return dataReprovacao;
	}

	public void setDataReprovacao(Date dataReprovacao) {
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
