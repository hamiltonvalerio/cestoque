package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Movimentacao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date datamovimentacao;
	
	private Localizacao localizacaoOrigem;
	
	private Localizacao localizacaoDestino;

	
	@OneToMany(mappedBy = "movimentacao")
	private List<InsumoMovimentacao> itens = new ArrayList<>();
	
	

	private String usualt;
	private Date datalt;
	
	public Movimentacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Movimentacao(Integer id, Date datamovimentacao, Localizacao localizacaoOrigem,
			Localizacao localizacaoDestino, String usualt, Date datalt) {
		super();
		this.id = id;
		this.datamovimentacao = datamovimentacao;
		this.localizacaoOrigem = localizacaoOrigem;
		this.localizacaoDestino = localizacaoDestino;
		this.usualt = usualt;
		this.datalt = datalt;
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


	
	public List<InsumoMovimentacao> getItens() {
		return itens;
	}


	public void setItens(List<InsumoMovimentacao> itens) {
		this.itens = itens;
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
		Movimentacao other = (Movimentacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}


	
		
	
	
}
