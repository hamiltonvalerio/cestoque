package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@DynamicUpdate
public class InsumoAjuste extends DadosComunsInsumos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "localizacao_id", nullable = false)
	private Localizacao localizacao;

	private Double quantidade;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataAjuste;

	private String usualt;
	
	private Date datalt;

	public InsumoAjuste(Integer id, Insumo insumo, 	Double quantidademinima, String loteFornecedor,
			String loteCR, String loteProducao, LocalDate dataIrradiacao, LocalDate dataValidade, 
			LocalDate dataFabricacao, LocalDateTime dataAprovacao, 	LocalDateTime dataReprovacao, 
			Boolean aprovado, String loteRecebimento, String loteARM, Localizacao localizacao,
			Double quantidade, Date dataAjuste, String usualt, Date datalt) {
		super();
		this.setId(id);
		this.setInsumo(insumo);
		this.localizacao = localizacao;
		this.quantidade = quantidade;
		this.setLoteFornecedor(loteFornecedor);
		this.setLoteCR(loteCR);
		this.setDataIrradiacao(dataIrradiacao);
		this.setDataValidade(dataValidade);
		this.setDataFabricacao(dataFabricacao);
		this.setDataAprovacao(dataAprovacao);
		this.setDataReprovacao(dataReprovacao);
		this.setAprovado(aprovado);
		this.setLoteRecebimento(loteRecebimento);
		this.setLoteARM(loteARM);
		this.localizacao = localizacao;
		this.quantidade = quantidade;
		this.dataAjuste = dataAjuste;
		this.usualt = usualt;
		this.datalt = datalt;
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
	
	
}
