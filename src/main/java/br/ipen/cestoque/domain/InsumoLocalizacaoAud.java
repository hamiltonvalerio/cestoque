package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Transient;


public class InsumoLocalizacaoAud implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Integer rev;
	
	private Integer revtype;
	
	private Date datalt;

	private String loteARM;
	
	private String loteCR;
	
	private String loteFornecedor;
	
	private String loteLEI;
	
	private String loteRecebimento;
	
	private Double quantidade;
	
	private Double quantidadeDescartada;
	
	private Double quantidadeUtilizada;
	
	private String usualt;
	
	private String loteProducao;
	
	private Double quantidademinima;
	
	@ManyToOne
	@JoinColumn(name = "localizacao_id", nullable = false)
	private Localizacao localizacao;
	
	@OneToOne
	private Localizacao localizacaoOrigem;
	
	@Transient
	private String nomedoinsumo;
	
	@Transient
	private String foiaprovado;

	@Transient
	private String emaprovacao;
	
	@Transient
	private String codigoalmoxarifado;
	
	private Boolean aprovado;

	private Boolean irradiado;
	
	public InsumoLocalizacaoAud() {
		super();
		// TODO Auto-generated constructor stub
	}
		
	public InsumoLocalizacaoAud(Integer id, Integer rev, Integer revtype, Date datalt, String loteARM, String loteCR,
			String loteFornecedor, String loteLEI, String loteRecebimento, Double quantidade,
			Double quantidadeDescartada, Double quantidadeUtilizada, String usualt, String loteProducao,
			Double quantidademinima, Localizacao localizacao, Localizacao localizacaoOrigem, String nomedoinsumo,
			String foiaprovado, String emaprovacao, String codigoalmoxarifado, Boolean aprovado, Boolean irradiado) {
		super();
		this.id = id;
		this.rev = rev;
		this.revtype = revtype;
		this.datalt = datalt;
		this.loteARM = loteARM;
		this.loteCR = loteCR;
		this.loteFornecedor = loteFornecedor;
		this.loteLEI = loteLEI;
		this.loteRecebimento = loteRecebimento;
		this.quantidade = quantidade;
		this.quantidadeDescartada = quantidadeDescartada;
		this.quantidadeUtilizada = quantidadeUtilizada;
		this.usualt = usualt;
		this.loteProducao = loteProducao;
		this.quantidademinima = quantidademinima;
		this.localizacao = localizacao;
		this.localizacaoOrigem = localizacaoOrigem;
		this.nomedoinsumo = nomedoinsumo;
		this.foiaprovado = foiaprovado;
		this.emaprovacao = emaprovacao;
		this.codigoalmoxarifado = codigoalmoxarifado;
		this.aprovado = aprovado;
		this.irradiado = irradiado;
	}


	public String getFoiaprovado() {
		if(this.aprovado != null) {
			if(this.aprovado.equals(true)) {
				this.foiaprovado = "SIM";
			}else {
				this.foiaprovado = "NÃO";
			}
		}
		return foiaprovado;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public Integer getRev() {
		return rev;
	}



	public void setRev(Integer rev) {
		this.rev = rev;
	}



	public Integer getRevtype() {
		return revtype;
	}



	public void setRevtype(Integer revtype) {
		this.revtype = revtype;
	}



	public Date getDatalt() {
		return datalt;
	}



	public void setDatalt(Date datalt) {
		this.datalt = datalt;
	}



	public String getLoteARM() {
		return loteARM;
	}



	public void setLoteARM(String loteARM) {
		this.loteARM = loteARM;
	}



	public String getLoteCR() {
		return loteCR;
	}



	public void setLoteCR(String loteCR) {
		this.loteCR = loteCR;
	}



	public String getLoteFornecedor() {
		return loteFornecedor;
	}



	public void setLoteFornecedor(String loteFornecedor) {
		this.loteFornecedor = loteFornecedor;
	}



	public String getLoteLEI() {
		return loteLEI;
	}



	public void setLoteLEI(String loteLEI) {
		this.loteLEI = loteLEI;
	}



	public String getLoteRecebimento() {
		return loteRecebimento;
	}



	public void setLoteRecebimento(String loteRecebimento) {
		this.loteRecebimento = loteRecebimento;
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



	public String getLoteProducao() {
		return loteProducao;
	}



	public void setLoteProducao(String loteProducao) {
		this.loteProducao = loteProducao;
	}



	public Double getQuantidademinima() {
		return quantidademinima;
	}



	public void setQuantidademinima(Double quantidademinima) {
		this.quantidademinima = quantidademinima;
	}



	public Localizacao getLocalizacao() {
		return localizacao;
	}



	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}



	public Localizacao getLocalizacaoOrigem() {
		return localizacaoOrigem;
	}



	public void setLocalizacaoOrigem(Localizacao localizacaoOrigem) {
		this.localizacaoOrigem = localizacaoOrigem;
	}



	public String getNomedoinsumo() {
		return nomedoinsumo;
	}



	public void setNomedoinsumo(String nomedoinsumo) {
		this.nomedoinsumo = nomedoinsumo;
	}



	public String getEmaprovacao() {
		return emaprovacao;
	}



	public void setEmaprovacao(String emaprovacao) {
		this.emaprovacao = emaprovacao;
	}



	public String getCodigoalmoxarifado() {
		return codigoalmoxarifado;
	}



	public void setCodigoalmoxarifado(String codigoalmoxarifado) {
		this.codigoalmoxarifado = codigoalmoxarifado;
	}



	public void setFoiaprovado(String foiaprovado) {
		this.foiaprovado = foiaprovado;
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

	
	
	


}
