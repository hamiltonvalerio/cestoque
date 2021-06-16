package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.envers.Audited;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Audited
@Table(name = "insumoentrada")
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

	private Double valor;

	private Double valorTotal;

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
			String testesuper, Unidade unidadeRecebida, Double quantidadeVolume, Unidade unidadeEntrada, String loteLEI,
			Double quantidadeUtilizada, LocalDateTime dataPrevisaoControle) {
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
		this.setQuantidade(quantidade);
		this.valor = valor;
		this.valorTotal = valorTotal;
		this.setLoteRecebimento(loteRecebimento);
		this.setLoteARM(loteARM);
		this.codigoalmoxarifado = insumo.getCodigoalmox();
		this.setUnidadeRecebida(unidadeRecebida);
		this.setQuantidadeVolume(quantidadeVolume);
		this.setUnidadeEntrada(unidadeEntrada);
		this.setLoteLEI(loteLEI);
		this.setQuantidadeUtilizada(quantidadeUtilizada);
		this.setDataPrevisaoControle(dataPrevisaoControle);
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

}
