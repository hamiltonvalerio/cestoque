package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.Localizacao;
import br.ipen.cestoque.domain.Unidade;

public class InsumoAjusteNewDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

	//@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataAjuste;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataFabricacao;

	@DateTimeFormat(iso = ISO.DATE)
	private LocalDate dataValidade;

	private Insumo insumo;

	private Localizacao localizacao;

	private String loteARM;

	private String loteCR;

	private String loteFornecedor;

	private Double quantidade;

	private Unidade unidade;

	public InsumoAjusteNewDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsumoAjusteNewDTO(Integer id, Date dataAjuste, LocalDate dataFabricacao, LocalDate dataValidade,
			Insumo insumo, Localizacao localizacao, String loteARM, String loteCR, String loteFornecedor,
			Double quantidade, Unidade unidade) {
		super();
		this.id = id;
		this.dataAjuste = dataAjuste;
		this.dataFabricacao = dataFabricacao;
		this.dataValidade = dataValidade;
		this.insumo = insumo;
		this.localizacao = localizacao;
		this.loteARM = loteARM;
		this.loteCR = loteCR;
		this.loteFornecedor = loteFornecedor;
		this.quantidade = quantidade;
		this.unidade = unidade;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataAjuste() {
		return dataAjuste;
	}

	public void setDataAjuste(Date dataAjuste) {
		this.dataAjuste = dataAjuste;
	}

	public LocalDate getDataFabricacao() {
		return dataFabricacao;
	}

	public void setDataFabricacao(LocalDate dataFabricacao) {
		this.dataFabricacao = dataFabricacao;
	}

	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(LocalDate dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
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

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InsumoAjusteNewDTO other = (InsumoAjusteNewDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
