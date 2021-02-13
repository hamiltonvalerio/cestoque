package br.ipen.cestoque.domain;

import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@DynamicUpdate
public class InsumoLocalizacao {

	@JsonIgnore
	@EmbeddedId
	private InsumoLocalizacaoPK id = new InsumoLocalizacaoPK();
	
	private Double quantidade;
	
	private Double quantidademinima;
	
	private String loteFornecedor;
	
	private String loteCR;
	
	private String loteProducao;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataIrradiacao;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataValidade;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataAprovacao;
	
	private Boolean aprovado;
	
	public InsumoLocalizacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public InsumoLocalizacao(Insumo insumo, Localizacao localizacao, Double quantidade, Double quantidademinima, 
			String loteFornecedor, String loteCR, String loteProducao,
			Date dataIrradiacao, Date dataValidade, Date dataAprovacao, Boolean aprovado) {
		super();
		id.setInsumo(insumo);
		id.setLocalizacao(localizacao);
		this.quantidade = quantidade;
		this.quantidademinima = quantidademinima;
		this.loteFornecedor = loteFornecedor;
		this.loteCR = loteCR;
		this.loteProducao = loteProducao;
		this.dataIrradiacao = dataIrradiacao;
		this.dataValidade = dataValidade;
		this.dataAprovacao = dataAprovacao;
		this.aprovado = aprovado;
	}
	
	@JsonIgnore
	public Localizacao getLocalizacao() {
		return id.getLocalizacao();
	}


	public void setLocalizacao(Localizacao localizacao) {
		id.setLocalizacao(localizacao);
	}
	
	public Insumo getInsumo() {
		return id.getInsumo();
	}
	
	public void setInsumo(Insumo insumo) {
		id.setInsumo(insumo);
	}

	public InsumoLocalizacaoPK getId() {
		return id;
	}

	public void setId(InsumoLocalizacaoPK id) {
		this.id = id;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getQuantidademinima() {
		return quantidademinima;
	}

	public void setQuantidademinima(Double quantidademinima) {
		this.quantidademinima = quantidademinima;
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

	public Boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}


	public String getLoteProducao() {
		return loteProducao;
	}


	public void setLoteProducao(String loteProducao) {
		this.loteProducao = loteProducao;
	}

	

}
