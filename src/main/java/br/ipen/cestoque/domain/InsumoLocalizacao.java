package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.envers.Audited;

@Entity
@DynamicUpdate
@Audited
@Table(name = "insumolocalizacao")
public class InsumoLocalizacao extends DadosComunsInsumos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "localizacao_id", nullable = false)
	private Localizacao localizacao;

	private Double quantidade;

	private Double quantidademinima;

	private String loteProducao;

	@Transient
	private String nomedoinsumo;

	@Transient
	private String foiaprovado;

	@Transient
	private String emaprovacao;
	
	@Transient
	private String codigoalmoxarifado;

	public InsumoLocalizacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsumoLocalizacao(Integer id, Insumo insumo, Localizacao localizacao, Double quantidade,
			Double quantidademinima, String loteFornecedor, String loteCR, String loteProducao,
			LocalDate dataIrradiacao, LocalDate dataValidade, LocalDate dataFabricacao, LocalDateTime dataAprovacao,
			LocalDateTime dataReprovacao, Boolean aprovado, String loteRecebimento, String loteARM,
			Unidade unidadeRecebida, Double quantidadeVolume, Unidade unidadeEntrada, String loteLEI) {
		super();
		this.setId(id);
		this.setInsumo(insumo);
		this.localizacao = localizacao;
		this.quantidade = quantidade;
		this.quantidademinima = quantidademinima;
		this.setLoteFornecedor(loteFornecedor);
		this.setLoteCR(loteCR);
		this.loteProducao = loteProducao;
		this.setDataIrradiacao(dataIrradiacao);
		this.setDataValidade(dataValidade);
		this.setDataFabricacao(dataFabricacao);
		this.setDataAprovacao(dataAprovacao);
		this.setDataReprovacao(dataReprovacao);
		this.setAprovado(aprovado);
		//this.setNomedoinsumo(insumo.getNome());
		this.nomedoinsumo = insumo.getNome();
		this.setLoteRecebimento(loteRecebimento);
		this.setLoteARM(loteARM);
		this.setUnidadeRecebida(unidadeRecebida);
		this.setQuantidadeVolume(quantidadeVolume);
		this.setUnidadeEntrada(unidadeEntrada);
		this.setLoteLEI(loteLEI);
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
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

	public String getLoteProducao() {
		return loteProducao;
	}

	public void setLoteProducao(String loteProducao) {
		this.loteProducao = loteProducao;
	}

	public String getNomedoinsumo() {
		return nomedoinsumo;
	}

	public void setNomedoinsumo(String nomedoinsumo) {
		this.nomedoinsumo = nomedoinsumo;
	}

	public String getFoiaprovado() {
		return foiaprovado;
	}

	public void setFoiaprovado(String foiaprovado) {
		this.foiaprovado = foiaprovado;
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

}
