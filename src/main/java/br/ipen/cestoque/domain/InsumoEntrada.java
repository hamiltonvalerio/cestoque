package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Audited
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
	
	@ManyToOne
	@JoinColumn(name = "unidaderecebida_id")
	private Unidade unidadeRecebida;
	
	private Double quantidadeVolume;
	
	@ManyToOne
	@JoinColumn(name = "unidadeentrada_id")
	private Unidade unidadeEntrada;

	@Transient
	private Integer quantidadeetiquetas;
	
	@Transient
	private String codigoalmoxarifado;

	
	public InsumoEntrada() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsumoEntrada(Integer id, Insumo insumo, Entrada entrada, String loteFornecedor, String loteCR,
			LocalDate dataIrradiacao, LocalDate dataVencIrradiacao, LocalDate dataValidade, LocalDate dataFabricacao,
			Double quantidade, Double valor, Double valorTotal, String loteRecebimento, String loteARM,
			String testesuper, Unidade unidadeRecebida, Double quantidadeVolume, Unidade unidadeEntrada) {
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
		this.codigoalmoxarifado = insumo.getCodigoalmox();
		this.setUnidadeRecebida(unidadeRecebida);
		this.quantidadeVolume = quantidadeVolume;
		this.setUnidadeEntrada(unidadeEntrada);

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

	public String getCodigoalmoxarifado() {
		return codigoalmoxarifado;
	}

	public void setCodigoalmoxarifado(String codigoalmoxarifado) {
		this.codigoalmoxarifado = codigoalmoxarifado;
	}

	public Unidade getUnidadeRecebida() {
		return unidadeRecebida;
	}

	public void setUnidadeRecebida(Unidade unidadeRecebida) {
		this.unidadeRecebida = unidadeRecebida;
	}

	public Double getQuantidadeVolume() {
		return quantidadeVolume;
	}

	public void setQuantidadeVolume(Double quantidadeVolume) {
		this.quantidadeVolume = quantidadeVolume;
	}

	public Unidade getUnidadeEntrada() {
		return unidadeEntrada;
	}

	public void setUnidadeEntrada(Unidade unidadeEntrada) {
		this.unidadeEntrada = unidadeEntrada;
	}
	
	

}
