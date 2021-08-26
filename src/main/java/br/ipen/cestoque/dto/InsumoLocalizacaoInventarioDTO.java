package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class InsumoLocalizacaoInventarioDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String loteFornecedor;
	private String loteCR;
	private String cas;
	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataValidade;
	private Double quantidade;
	private Boolean aprovado;
	private Boolean irradiado;
	private String armario;
	private String prateleira;
	private String posicao;
	private String usualt;
	private Date datalt;

	public InsumoLocalizacaoInventarioDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsumoLocalizacaoInventarioDTO(Integer id, String loteFornecedor, String loteCR, String cas,
			LocalDate dataValidade, Double quantidade, Boolean aprovado, Boolean irradiado, String armario,
			String prateleira, String posicao, String usualt, Date datalt) {
		super();
		this.id = id;
		this.loteFornecedor = loteFornecedor;
		this.loteCR = loteCR;
		this.cas = cas;
		this.dataValidade = dataValidade;
		this.quantidade = quantidade;
		this.aprovado = aprovado;
		this.irradiado = irradiado;
		this.armario = armario;
		this.prateleira = prateleira;
		this.posicao = posicao;
		this.usualt = usualt;
		this.datalt = datalt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getCas() {
		return cas;
	}

	public void setCas(String cas) {
		this.cas = cas;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
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

	public String getArmario() {
		return armario;
	}

	public void setArmario(String armario) {
		this.armario = armario;
	}

	public String getPrateleira() {
		return prateleira;
	}

	public void setPrateleira(String prateleira) {
		this.prateleira = prateleira;
	}

	public String getPosicao() {
		return posicao;
	}

	public void setPosicao(String posicao) {
		this.posicao = posicao;
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

}
