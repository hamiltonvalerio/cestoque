package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
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
	
	@Transient
	private Unidade unidade;

	public InsumoAjuste(
			Date dataAjuste, 
			LocalDate dataFabricacao, 
			LocalDate dataValidade,
			Insumo insumo,
			Localizacao localizacao,
			String loteARM,
			String loteCR,
			String loteFornecedor,
			Double quantidade,
			Unidade unidade) {
		super();
		this.dataAjuste = dataAjuste;
		this.setDataFabricacao(dataFabricacao);
		this.setDataValidade(dataValidade);
		this.setInsumo(insumo);
		this.localizacao = localizacao;
		this.setLoteARM(loteARM);
		this.setLoteCR(loteCR);
		this.setLoteFornecedor(loteFornecedor);
		this.quantidade = quantidade;
		this.unidade = unidade;
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

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	
}
