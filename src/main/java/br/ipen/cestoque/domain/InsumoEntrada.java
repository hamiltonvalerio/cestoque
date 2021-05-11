package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class InsumoEntrada extends DadosComunsInsumos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "entrada_id")
	private Entrada entrada;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataVencIrradiacao;

	private Double quantidade;

	private Double valor;

	private Double valorTotal;

	@Transient
	private Integer quantidadeetiquetas;

	public InsumoEntrada() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsumoEntrada(Integer id, Insumo insumo, Entrada entrada, String loteFornecedor, String loteCR,
			LocalDate dataIrradiacao, LocalDate dataVencIrradiacao, LocalDate dataValidade, LocalDate dataFabricacao,
			Double quantidade, Double valor, Double valorTotal, String loteRecebimento, String loteARM,
			String testesuper) {
		super();
		this.setId(id);
		this.setInsumo(insumo);
		this.entrada = entrada;
		this.setLoteFornecedor(loteFornecedor);
		this.setLoteCR(loteCR);
		this.setDataIrradiacao(dataIrradiacao);
		this.dataVencIrradiacao = dataVencIrradiacao;
		this.setDataValidade(dataValidade);
		this.setDataFabricacao(dataFabricacao);
		this.quantidade = quantidade;
		this.valor = valor;
		this.valorTotal = valorTotal;
		this.setLoteRecebimento(loteRecebimento);
		this.setLoteARM(loteARM);

	}

	public Entrada getEntrada() {
		return entrada;
	}

	public void setEntrada(Entrada entrada) {
		this.entrada = entrada;
	}

	public LocalDate getDataVencIrradiacao() {
		return dataVencIrradiacao;
	}

	public void setDataVencIrradiacao(LocalDate dataVencIrradiacao) {
		this.dataVencIrradiacao = dataVencIrradiacao;
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

	public Double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(Double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public Integer getQuantidadeetiquetas() {
		return quantidadeetiquetas;
	}

	public void setQuantidadeetiquetas(Integer quantidadeetiquetas) {
		this.quantidadeetiquetas = quantidadeetiquetas;
	}

}
