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
public class InsumoEntrada implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*
	 * @JsonIgnore
	 * 
	 * @EmbeddedId private InsumoEntradaPK id = new InsumoEntradaPK();
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "insumo_id", nullable = false)
	private Insumo insumo;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "entrada_id")
	private Entrada entrada;

	private String loteFornecedor;
	private String loteCR;

	//@JsonFormat(pattern = "yyyy-MM-dd")
	@DateTimeFormat(iso = ISO.DATE_TIME)
	private LocalDateTime dataIrradiacao;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataVencIrradiacao;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataValidade;

	private Double quantidade;
	private Double valor;

	private Double valorTotal;

	private String loteRecebimento;

	public InsumoEntrada() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsumoEntrada(Integer id, Insumo insumo, Entrada entrada, String loteFornecedor, String loteCR,
			LocalDateTime dataIrradiacao, LocalDate dataVencIrradiacao, LocalDate dataValidade,
			Double quantidade, Double valor, Double valorTotal, String loteRecebimento) {
		super();
		this.id = id;
		this.insumo = insumo;
		this.entrada = entrada;
		this.loteFornecedor = loteFornecedor;
		this.loteCR = loteCR;
		this.dataIrradiacao = dataIrradiacao;
		this.dataVencIrradiacao = dataVencIrradiacao;
		this.dataValidade = dataValidade;
		this.quantidade = quantidade;
		this.valor = valor;
		this.valorTotal = valorTotal;
		this.loteRecebimento = loteRecebimento;
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

	public LocalDateTime getDataIrradiacao() {
		return dataIrradiacao;
	}

	public void setDataIrradiacao(LocalDateTime dataIrradiacao) {
		this.dataIrradiacao = dataIrradiacao;
	}

	public LocalDate getDataVencIrradiacao() {
		return dataVencIrradiacao;
	}

	public void setDataVencIrradiacao(LocalDate dataVencIrradiacao) {
		this.dataVencIrradiacao = dataVencIrradiacao;
	}

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public String getLoteRecebimento() {
		return loteRecebimento;
	}

	public void setLoteRecebimento(String loteRecebimento) {
		this.loteRecebimento = loteRecebimento;
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

	public Entrada getEntrada() {
		return entrada;
	}

	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
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
		InsumoEntrada other = (InsumoEntrada) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
