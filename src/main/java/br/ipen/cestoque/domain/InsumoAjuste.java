package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import br.ipen.cestoque.dto.InsumoLocalizacaoInventarioDTO;

@Entity
@Table(name = "insumoajuste")
public class InsumoAjuste extends DadosComunsInsumos implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@ManyToOne
	@JoinColumn(name = "localizacao_id", nullable = false)
	private Localizacao localizacao;

	// @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataAjuste;

	private String usualt;

	private Date datalt;

	@Transient
	private Unidade unidade;

	public InsumoAjuste() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsumoAjuste(Date dataAjuste, LocalDate dataFabricacao, LocalDate dataValidade, Insumo insumo,
			Localizacao localizacao, String loteARM, String loteCR, String loteFornecedor, Double quantidade,
			Unidade unidade, String loteLEI, String subloteLEI, String armario, String posicao, String cas, String prateleira) {
		super();
		this.dataAjuste = dataAjuste;
		this.setDataFabricacao(dataFabricacao);
		this.setDataValidade(dataValidade);
		this.setInsumo(insumo);
		this.localizacao = localizacao;
		this.setLoteARM(loteARM);
		this.setLoteCR(loteCR);
		this.setLoteFornecedor(loteFornecedor);
		this.setQuantidade(quantidade);
		this.unidade = unidade;
		this.setLoteLEI(subloteLEI);
		this.setSubloteLEI(subloteLEI);
		this.setArmario(armario);
		this.setPosicao(posicao);
		this.setCas(cas);
		this.setPrateleira(prateleira);
	}

	public InsumoAjuste(Localizacao localizacao, Double quantidade, Date dataAjuste, String usualt, Date datalt,
			Unidade unidade, Integer id, Insumo insumo, String loteFornecedor, String loteCR, LocalDate dataIrradiacao,
			String loteRecebimento, String loteARM, LocalDate dataValidade, LocalDate dataFabricacao, Boolean aprovado,
			LocalDateTime dataAprovacao, LocalDateTime dataReprovacao, String loteLEI, String subloteLEI,
			String armario, String posicao, String cas, String prateleira) {
		super();
		this.localizacao = localizacao;
		this.setQuantidade(quantidade);
		this.dataAjuste = dataAjuste;
		this.usualt = usualt;
		this.datalt = datalt;
		this.unidade = unidade;
		this.setId(id);
		this.setInsumo(insumo);
		this.setLoteFornecedor(loteFornecedor);
		this.setLoteCR(loteCR);
		this.setDataIrradiacao(dataIrradiacao);
		this.setLoteRecebimento(loteRecebimento);
		this.setLoteARM(loteARM);
		this.setDataValidade(dataValidade);
		this.setDataFabricacao(dataFabricacao);
		this.setAprovado(aprovado);
		this.setDataAprovacao(dataAprovacao);
		this.setDataReprovacao(dataReprovacao);
		this.setLoteLEI(subloteLEI);
		this.setSubloteLEI(subloteLEI);
		this.setArmario(armario);
		this.setPosicao(posicao);
		this.setCas(cas);
		this.setPrateleira(prateleira);
	}

	public InsumoAjuste(InsumoLocalizacao il) {
		// TODO Auto-generated constructor stub
		this.setInsumo(il.getInsumo());
		this.setLoteFornecedor(il.getLoteFornecedor());
		this.setLoteCR(il.getLoteCR());
		this.setLoteARM(il.getLoteARM());
		this.setDataIrradiacao(il.getDataIrradiacao());
		this.setIrradiado(il.getIrradiado());
		this.setLoteRecebimento(il.getLoteRecebimento());
		this.setDataValidade(il.getDataValidade());
		this.setQuantidade(il.getQuantidade());
		this.setDataFabricacao(il.getDataFabricacao());
		this.setAprovado(il.getAprovado());
		this.setDataAprovacao(il.getDataAprovacao());
		this.setDataReprovacao(il.getDataReprovacao());
		this.setLoteLEI(il.getLoteLEI());
		this.setSubloteLEI(il.getSubloteLEI());
		this.setArmario(il.getArmario());
		this.setPosicao(il.getPosicao());
		this.setCas(il.getCas());
		this.setPrateleira(il.getPrateleira());
		this.setLocalizacao(il.getLocalizacao());
	}
	
	public InsumoAjuste(InsumoLocalizacaoInventarioDTO ilv) {
		// TODO Auto-generated constructor stub
		this.setId(ilv.getId());
		this.setLoteFornecedor(ilv.getLoteFornecedor());
		this.setLoteCR(ilv.getLoteCR());
		this.setCas(ilv.getCas());
		this.setDataValidade(ilv.getDataValidade());
		this.setQuantidade(ilv.getQuantidade());
		this.setAprovado(ilv.getAprovado());
		this.setIrradiado(ilv.getIrradiado());
		this.setArmario(ilv.getArmario());
		this.setPrateleira(ilv.getPrateleira());
		this.setPosicao(ilv.getPosicao());
		this.setUsualt(ilv.getUsualt());
		this.setDatalt(ilv.getDatalt());
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public Date getDataAjuste() {
		return dataAjuste;
	}

	public void setDataAjuste(Date dataAjuste) {
		this.dataAjuste = dataAjuste;
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

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

}
