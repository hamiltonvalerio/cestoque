package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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

	@ManyToOne
	@JoinColumn(name = "localizacaofilha_id", nullable = false)
	private LocalizacaoFilha localizacaoFilha;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "movimentacao_id")
	private Movimentacao movimentacao;

	private Double quantidadeOrigem;

	private Double quantidadeMovimentada;

	private String loteProducao;

	public InsumoMovimentacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsumoMovimentacao(Integer id, Insumo insumo, Localizacao localizacao, Movimentacao movimentacao,
			LocalizacaoFilha localizacaoFilha, Double quantidadeOrigem, Double quantidadeMovimentada,
			String loteFornecedor, String loteCR, String loteProducao, String loteRecebimento, LocalDate dataIrradiacao,
			LocalDate dataValidade, LocalDate dataFabricacao, LocalDateTime dataAprovacao, LocalDateTime dataReprovacao,
			Boolean aprovado, String loteARM, String condambamostragemgc, String condambamostragemur,
			Double quantidadeDescartada, Double quantidadeUtilizada, LocalDateTime dataPrevisaoControle,
			Boolean irradiado, Double quantidade) {
		super();
		this.setId(id);
		this.setInsumo(insumo);
		this.localizacao = localizacao;
		this.localizacaoFilha = localizacaoFilha;
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

	public LocalizacaoFilha getLocalizacaoFilha() {
		return localizacaoFilha;
	}

	public void setLocalizacaoFilha(LocalizacaoFilha localizacaoFilha) {
		this.localizacaoFilha = localizacaoFilha;
	}

}
