package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
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

	@OneToOne
	private Localizacao localizacaoOrigem;

	public InsumoLocalizacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsumoLocalizacao(Integer id, Insumo insumo, Localizacao localizacao, Double quantidade,

			Double quantidademinima, String loteFornecedor, String loteCR, String loteProducao,
			LocalDate dataIrradiacao, LocalDate dataValidade, LocalDate dataFabricacao, LocalDateTime dataAprovacao,
			LocalDateTime dataReprovacao, Boolean aprovado, String loteRecebimento, String loteARM,
			Unidade unidadeRecebida, Double quantidadeVolume, Unidade unidadeEntrada, String loteLEI,
			String condambamostragemgc, String condambamostragemur, Double quantidadeDescartada,
			Double quantidadeUtilizada, LocalDateTime dataPrevisaoControle, Boolean irradiado, String usualt,
			Date datalt, Localizacao localizacaoOrigem, String subloteLEI, String armario, String posicao, String cas, String prateleira) {
		super();
		this.setId(id);
		this.setInsumo(insumo);
		this.localizacao = localizacao;

		this.setQuantidade(quantidade);
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
		this.nomedoinsumo = insumo.getNome();
		this.setLoteRecebimento(loteRecebimento);
		this.setLoteARM(loteARM);
		this.setUnidadeRecebida(unidadeRecebida);
		this.setQuantidadeVolume(quantidadeVolume);
		this.setUnidadeEntrada(unidadeEntrada);
		this.setLoteLEI(loteLEI);
		this.setCondambamostragemgc(condambamostragemgc);
		this.setCondambamostragemur(condambamostragemur);
		this.setQuantidadeDescartada(quantidadeDescartada);
		this.setQuantidadeUtilizada(quantidadeUtilizada);
		this.setDataPrevisaoControle(dataPrevisaoControle);
		this.setIrradiado(irradiado);
		this.setUsualt(usualt);
		this.setDatalt(datalt);
		this.localizacaoOrigem = localizacaoOrigem;
		this.setSubloteLEI(subloteLEI);
		this.setArmario(armario);
		this.setPosicao(posicao);
		this.setCas(cas);
		this.setPrateleira(prateleira);
	}

	public InsumoLocalizacao(InsumoLocalizacao il) {
		super();
		this.setId(il.getId());
		this.setInsumo(il.getInsumo());
		this.localizacao = il.getLocalizacao();
		this.setQuantidade(il.getQuantidade());
		this.quantidademinima = il.getQuantidademinima();
		this.setLoteFornecedor(il.getLoteFornecedor());
		this.setLoteCR(il.getLoteCR());
		this.loteProducao = il.getLoteProducao();
		this.setDataIrradiacao(il.getDataFabricacao());
		this.setDataValidade(il.getDataValidade());
		this.setDataFabricacao(il.getDataFabricacao());
		this.setDataAprovacao(il.getDataAprovacao());
		this.setDataReprovacao(il.getDataReprovacao());
		this.setAprovado(il.getAprovado());
		this.nomedoinsumo = il.getInsumo().getNome();
		this.setLoteRecebimento(il.getLoteRecebimento());
		this.setLoteARM(il.getLoteARM());
		this.setUnidadeRecebida(il.getUnidadeRecebida());
		this.setQuantidadeVolume(il.getQuantidadeVolume());
		this.setUnidadeEntrada(il.getUnidadeEntrada());
		this.setLoteLEI(il.getLoteLEI());
		this.setCondambamostragemgc(il.getCondambamostragemgc());
		this.setCondambamostragemur(il.getCondambamostragemur());
		this.setQuantidadeDescartada(il.getQuantidadeDescartada());
		this.setQuantidadeUtilizada(il.getQuantidadeUtilizada());
		this.setDataPrevisaoControle(il.getDataPrevisaoControle());
		this.setIrradiado(il.getIrradiado());
		this.setUsualt(il.getUsualt());
		this.setDatalt(il.getDatalt());
		this.localizacaoOrigem = il.getLocalizacaoOrigem();
		this.setSubloteLEI(il.getSubloteLEI());
		this.setArmario(il.getArmario());
		this.setPosicao(il.getPosicao());
		this.setCas(il.getCas());
		this.setPrateleira(il.getPrateleira());
	}

	public InsumoLocalizacao(InsumoMovimentacao im) {
		super();
		this.setId(im.getId());
		this.setInsumo(im.getInsumo());
		this.localizacao = im.getLocalizacao();
		this.setQuantidade(im.getQuantidade());
		this.quantidademinima = 0.0;
		this.setLoteFornecedor(im.getLoteFornecedor());
		this.setLoteCR(im.getLoteCR());
		this.loteProducao = im.getLoteProducao();
		this.setDataIrradiacao(im.getDataFabricacao());
		this.setDataValidade(im.getDataValidade());
		this.setDataFabricacao(im.getDataFabricacao());
		this.setDataAprovacao(im.getDataAprovacao());
		this.setDataReprovacao(im.getDataReprovacao());
		this.setAprovado(im.getAprovado());
		this.nomedoinsumo = im.getInsumo().getNome();
		this.setLoteRecebimento(im.getLoteRecebimento());
		this.setLoteARM(im.getLoteARM());
		this.setUnidadeRecebida(im.getUnidadeRecebida());
		this.setQuantidadeVolume(im.getQuantidadeVolume());
		this.setUnidadeEntrada(im.getUnidadeEntrada());
		this.setLoteLEI(im.getLoteLEI());
		this.setCondambamostragemgc(im.getCondambamostragemgc());
		this.setCondambamostragemur(im.getCondambamostragemur());
		this.setQuantidadeDescartada(im.getQuantidadeDescartada());
		this.setQuantidadeUtilizada(im.getQuantidadeUtilizada());
		this.setDataPrevisaoControle(im.getDataPrevisaoControle());
		this.setIrradiado(im.getIrradiado());
		this.setUsualt(im.getUsualt());
		this.setDatalt(im.getDatalt());
		this.localizacaoOrigem = im.getLocalizacaoOrigem();
		this.setSubloteLEI(im.getSubloteLEI());
		this.setArmario(im.getArmario());
		this.setPosicao(im.getPosicao());
		this.setCas(im.getCas());
		this.setPrateleira(im.getPrateleira());
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
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
		if (getAprovado() != null) {
			if (getAprovado().equals(true)) {
				this.foiaprovado = "SIM";
			} else {
				this.foiaprovado = "NÃO";
			}
		}
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

	public Localizacao getLocalizacaoOrigem() {
		return localizacaoOrigem;
	}

	public void setLocalizacaoOrigem(Localizacao localizacaoOrigem) {
		this.localizacaoOrigem = localizacaoOrigem;
	}

}
