package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import br.ipen.cestoque.domain.Entrada;
import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.InsumoEntrada;
import br.ipen.cestoque.domain.Unidade;


public class InsumoEntradaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;


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
	

	private Unidade unidadeRecebida;
	
	private Double quantidadeVolume;
	

	private Unidade unidadeEntrada;

	private String loteLEI;
	
	private String condambamostragemgc;
	private String condambamostragemur;

	private Double quantidade;

	private Double quantidadeDescartada;

	private Double quantidadeUtilizada;

	private String usualt;

	private Date datalt;
	
	private Entrada entrada;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataVencIrradiacao;

	private Double valor;

	private Double valorTotal;

	private Integer quantidadeetiquetas;

	private String codigoalmoxarifado;

	public InsumoEntradaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	

	public InsumoEntradaDTO(InsumoEntrada ie) {
		super();
		this.id = ie.getId();
		this.insumo = ie.getInsumo();
		this.loteFornecedor = ie.getLoteFornecedor();
		this.loteCR = ie.getLoteCR();
		this.dataIrradiacao = ie.getDataIrradiacao();
		this.loteRecebimento = ie.getLoteRecebimento();
		this.loteARM = ie.getLoteARM();
		this.dataValidade = ie.getDataValidade();
		this.dataFabricacao = ie.getDataFabricacao();
		this.aprovado = ie.getAprovado();
		this.irradiado = ie.getAprovado();
		this.dataAprovacao = ie.getDataAprovacao();
		this.dataReprovacao = ie.getDataReprovacao();
		this.dataPrevisaoControle = ie.getDataPrevisaoControle();
		this.unidadeRecebida = ie.getUnidadeRecebida();
		this.quantidadeVolume = ie.getQuantidadeVolume();
		this.unidadeEntrada = ie.getUnidadeEntrada();
		this.loteLEI = ie.getLoteLEI();
		this.condambamostragemgc = ie.getCondambamostragemgc();
		this.condambamostragemur = ie.getCondambamostragemur();
		this.quantidade = ie.getQuantidade();
		this.quantidadeDescartada = ie.getQuantidadeDescartada();
		this.quantidadeUtilizada = ie.getQuantidadeUtilizada();
		this.usualt = ie.getUsualt();
		this.datalt = ie.getDatalt();
		this.entrada = ie.getEntrada();
		this.dataVencIrradiacao = ie.getDataVencIrradiacao();
		this.valor = ie.getValor();
		this.valorTotal = ie.getValorTotal();
		this.quantidadeetiquetas = ie.getQuantidadeetiquetas();
		this.codigoalmoxarifado = ie.getCodigoalmoxarifado();
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

	public Boolean getIrradiado() {
		return irradiado;
	}

	public void setIrradiado(Boolean irradiado) {
		this.irradiado = irradiado;
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

	public LocalDateTime getDataPrevisaoControle() {
		return dataPrevisaoControle;
	}

	public void setDataPrevisaoControle(LocalDateTime dataPrevisaoControle) {
		this.dataPrevisaoControle = dataPrevisaoControle;
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

	public String getLoteLEI() {
		return loteLEI;
	}

	public void setLoteLEI(String loteLEI) {
		this.loteLEI = loteLEI;
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

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getQuantidadeDescartada() {
		return quantidadeDescartada;
	}

	public void setQuantidadeDescartada(Double quantidadeDescartada) {
		this.quantidadeDescartada = quantidadeDescartada;
	}

	public Double getQuantidadeUtilizada() {
		return quantidadeUtilizada;
	}

	public void setQuantidadeUtilizada(Double quantidadeUtilizada) {
		this.quantidadeUtilizada = quantidadeUtilizada;
	}

	public String getUsualt() {
		return usualt;
	}

	public void setUsualt(String usualt) {
		this.usualt = usualt;
	}

	public Date getDatalt() {
		return datalt;
	}

	public void setDatalt(Date datalt) {
		this.datalt = datalt;
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
