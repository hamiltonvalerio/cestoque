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

import org.hibernate.envers.Audited;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Audited
@Table(name = "insumomovimentacao")
public class InsumoMovimentacao extends DadosComunsInsumos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "localizacao_id", nullable = false)
	private Localizacao localizacao;

	@Audited
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "movimentacao_id")
	private Movimentacao movimentacao;

	private Double quantidadeOrigem;

	private Double quantidadeMovimentada;

	private String loteProducao;
	
	@OneToOne
	private Localizacao localizacaoOrigem;
	
	@Transient
	private Double quantidadeRealMovimentada;

	public InsumoMovimentacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsumoMovimentacao(Integer id, Insumo insumo, Localizacao localizacao, Movimentacao movimentacao,
			Double quantidadeOrigem, Double quantidadeMovimentada,
			String loteFornecedor, String loteCR, String loteProducao, String loteRecebimento, LocalDate dataIrradiacao,
			LocalDate dataValidade, LocalDate dataFabricacao, LocalDateTime dataAprovacao, LocalDateTime dataReprovacao,
			Boolean aprovado, String loteARM, String condambamostragemgc, String condambamostragemur,
			Double quantidadeDescartada, Double quantidadeUtilizada, LocalDateTime dataPrevisaoControle,
			Boolean irradiado, Double quantidade, Localizacao localizacaoOrigem, String usualt, Date datalt, String armario, String posicao, String cas, String prateleira) {
		super();
		this.setId(id);
		this.setInsumo(insumo);
		this.localizacao = localizacao;
		this.movimentacao = movimentacao;
		this.quantidadeOrigem = quantidadeOrigem;
		this.quantidadeMovimentada = quantidadeMovimentada;
		this.setLoteFornecedor(loteFornecedor);
		this.setLoteCR(loteCR);
		this.loteProducao = loteProducao;
		this.setDataIrradiacao(dataIrradiacao);
		this.setDataValidade(dataValidade);
		this.setDataFabricacao(dataFabricacao);
		this.setDataAprovacao(dataAprovacao);
		this.setDataReprovacao(dataReprovacao);
		this.setAprovado(aprovado);
		this.setLoteRecebimento(loteRecebimento);
		this.setLoteARM(loteARM);
		this.setCondambamostragemgc(condambamostragemgc);
		this.setCondambamostragemur(condambamostragemur);
		this.setQuantidadeDescartada(quantidadeDescartada);
		this.setQuantidadeUtilizada(quantidadeUtilizada);
		this.setDataPrevisaoControle(dataPrevisaoControle);
		this.setIrradiado(irradiado);
		this.setQuantidade(quantidade);
		this.localizacaoOrigem = localizacaoOrigem;
		this.setUsualt(usualt);
		this.setDatalt(datalt);
		this.setArmario(armario);
		this.setPosicao(posicao);
		this.setCas(cas);
		this.setPrateleira(prateleira);
	}
	
	public InsumoMovimentacao(InsumoLocalizacao il) {
		super();
		this.setInsumo(il.getInsumo());
		this.localizacao = il.getLocalizacao();
		this.quantidadeOrigem = 0.0;
		this.quantidadeMovimentada = il.getQuantidade();
		this.setLoteFornecedor(il.getLoteFornecedor());
		this.setLoteCR(il.getLoteCR());
		this.loteProducao = il.getLoteProducao();
		this.setDataIrradiacao(il.getDataIrradiacao());
		this.setDataValidade(il.getDataValidade());
		this.setDataFabricacao(il.getDataFabricacao());
		this.setDataAprovacao(il.getDataAprovacao());
		this.setDataReprovacao(il.getDataReprovacao());
		this.setAprovado(il.getAprovado());
		this.setLoteRecebimento(il.getLoteRecebimento());
		this.setLoteARM(il.getLoteARM());
		this.setCondambamostragemgc(il.getCondambamostragemgc());
		this.setCondambamostragemur(il.getCondambamostragemur());
		this.setQuantidadeDescartada(il.getQuantidadeDescartada());
		this.setQuantidadeUtilizada(il.getQuantidadeUtilizada());
		this.setDataPrevisaoControle(il.getDataPrevisaoControle());
		this.setIrradiado(il.getIrradiado());
		this.setQuantidade(il.getQuantidade());
		this.localizacaoOrigem = il.getLocalizacaoOrigem();
		this.setUsualt(il.getUsualt());
		this.setDatalt(il.getDatalt());
		this.setLoteLEI(il.getLoteLEI());
		this.setSubloteLEI(il.getSubloteLEI());
		this.setArmario(il.getArmario());
		this.setPosicao(il.getPosicao());
		this.setCas(il.getCas());
		this.setPrateleira(il.getPrateleira());
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public Movimentacao getMovimentacao() {
		return movimentacao;
	}

	public void setMovimentacao(Movimentacao movimentacao) {
		this.movimentacao = movimentacao;
	}

	public Double getQuantidadeOrigem() {
		return quantidadeOrigem;
	}

	public void setQuantidadeOrigem(Double quantidadeOrigem) {
		this.quantidadeOrigem = quantidadeOrigem;
	}

	public Double getQuantidadeMovimentada() {
		return quantidadeMovimentada;
	}

	public void setQuantidadeMovimentada(Double quantidadeMovimentada) {
		this.quantidadeMovimentada = quantidadeMovimentada;
	}

	public String getLoteProducao() {
		return loteProducao;
	}

	public void setLoteProducao(String loteProducao) {
		this.loteProducao = loteProducao;
	}

	public Localizacao getLocalizacaoOrigem() {
		return localizacaoOrigem;
	}

	public void setLocalizacaoOrigem(Localizacao localizacaoOrigem) {
		this.localizacaoOrigem = localizacaoOrigem;
	}

	public Double getQuantidadeRealMovimentada() {
		if(this.localizacao != null) {
			if(this.localizacao.getUtilizado() != null) {
				if(this.localizacao.getUtilizado()) {
					return this.getQuantidadeUtilizada();
				}else if(this.localizacao.getDescarte()) {
					return this.getQuantidadeDescartada();
				}else {
					this.getQuantidadeMovimentada();
				}
			}else if(this.localizacao.getDescarte() != null) {
				return this.localizacao.getDescarte()?this.getQuantidadeDescartada():this.getQuantidadeMovimentada();
			}	
		}
		return quantidadeMovimentada;
	}

	public void setQuantidadeRealMovimentada(Double quantidadeRealMovimentada) {
		this.quantidadeRealMovimentada = quantidadeRealMovimentada;
	}


}
