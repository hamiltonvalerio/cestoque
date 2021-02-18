package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.ipen.cestoque.domain.Localizacao;

public class MovimentacaoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date datamovimentacao;
	

	private Localizacao localizacaoOrigem;

	private Localizacao localizacaoDestino;

	private List<InsumoMovimentacaoDTO> itens = new ArrayList<>();
	
	private String usualt;
	
	private Date datalt;
	
	

	public MovimentacaoDTO() {
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDatamovimentacao() {
		return datamovimentacao;
	}

	public void setDatamovimentacao(Date datamovimentacao) {
		this.datamovimentacao = datamovimentacao;
	}

	public Localizacao getLocalizacaoOrigem() {
		return localizacaoOrigem;
	}

	public void setLocalizacaoOrigem(Localizacao localizacaoOrigem) {
		this.localizacaoOrigem = localizacaoOrigem;
	}

	public Localizacao getLocalizacaoDestino() {
		return localizacaoDestino;
	}

	public void setLocalizacaoDestino(Localizacao localizacaoDestino) {
		this.localizacaoDestino = localizacaoDestino;
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


	public List<InsumoMovimentacaoDTO> getItens() {
		return itens;
	}


	public void setItens(List<InsumoMovimentacaoDTO> itens) {
		this.itens = itens;
	}
	
	
	
	

}
