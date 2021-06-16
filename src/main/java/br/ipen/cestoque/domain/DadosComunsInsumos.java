package br.ipen.cestoque.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@MappedSuperclass
public abstract class DadosComunsInsumos {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "insumo_id", nullable = false)
	private Insumo insumo;

	private String loteFornecedor;

	private String loteCR;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataIrradiacao;

	private String loteRecebimento;

	private String loteARM;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataValidade;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataFabricacao;

	private Boolean aprovado;

	private Boolean irradiado;
	
	private LocalDateTime dataAprovacao;

	private LocalDateTime dataReprovacao;
	
	private LocalDateTime dataPrevisaoControle;
	
	@ManyToOne
	@JoinColumn(name = "unidaderecebida_id")
	private Unidade unidadeRecebida;
	
	private Double quantidadeVolume;
	
	@ManyToOne
	@JoinColumn(name = "unidadeentrada_id")
	private Unidade unidadeEntrada;
	
	private String loteLEI;
	
	private String condambamostragemgc;
	private String condambamostragemur;

	private Double quantidade;
	private Double quantidadeDescartada;
	private Double quantidadeUtilizada;
	
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

	public LocalDate getDataIrradiacao() {
		return dataIrradiacao;
	}

	public void setDataIrradiacao(LocalDate dataIrradiacao) {
		this.dataIrradiacao = dataIrradiacao;
	}

	public String getLoteRecebimento() {
		return loteRecebimento;
	}

	public void setLoteRecebimento(String loteRecebimento) {
		this.loteRecebimento = loteRecebimento;
	}

	public String getLoteARM() {
		return loteARM;
	}

	public void setLoteARM(String loteARM) {
		this.loteARM = loteARM;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public Boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
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
	
	public String getCondambamostragemgc() {
		return condambamostragemgc;
	}

	public void setCondambamostragemgc(String condambamostragemgc) {
		this.condambamostragemgc = condambamostragemgc;
	}

	public String getCondambamostragemur() {
		return condambamostragemur;
	}

	public void setCondambamostragemur(String condambamostragemur) {
		this.condambamostragemur = condambamostragemur;
	}

	public Double getQuantidadeDescartada() {
		return quantidadeDescartada;
	}

	public void setQuantidadeDescartada(Double quantidadeDescartada) {
		this.quantidadeDescartada = quantidadeDescartada;
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
		DadosComunsInsumos other = (DadosComunsInsumos) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public String getLoteLEI() {
		return loteLEI;
	}

	public void setLoteLEI(String loteLEI) {
		this.loteLEI = loteLEI;
	}

	public Double getQuantidadeUtilizada() {
		return quantidadeUtilizada;
	}

	public void setQuantidadeUtilizada(Double quantidadeUtilizada) {
		this.quantidadeUtilizada = quantidadeUtilizada;
	}

	public LocalDateTime getDataPrevisaoControle() {
		return dataPrevisaoControle;
	}

	public void setDataPrevisaoControle(LocalDateTime dataPrevisaoControle) {
		this.dataPrevisaoControle = dataPrevisaoControle;
	}

	public Boolean getIrradiado() {
		return irradiado;
	}

	public void setIrradiado(Boolean irradiado) {
		this.irradiado = irradiado;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

}
