package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Saida implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date data_saida;
	
	private Double total;
	
	private String observacoes;
	
	private String usualt;
	private Date datalt;
	
	@OneToMany(mappedBy = "id.saida")
	private Set<InsumoSaida> itens = new HashSet<>();
	
	public Saida() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Saida(Integer id, Date data_saida, Double total, String observacoes, String usualt, Date datalt) {
		super();
		this.id = id;
		this.data_saida = data_saida;
		this.total = total;
		this.observacoes = observacoes;
		this.usualt = usualt;
		this.datalt = datalt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData_saida() {
		return data_saida;
	}

	public void setData_saida(Date data_saida) {
		this.data_saida = data_saida;
	}

	public Double getTotal() {
		return total;
	}

	public void setTotal(Double total) {
		this.total = total;
	}

	public String getNumeronf() {
		return observacoes;
	}

	public void setNumeronf(String observacoes) {
		this.observacoes = observacoes;
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
		Saida other = (Saida) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Set<InsumoSaida> getItens() {
		return itens;
	}

	public void setItens(Set<InsumoSaida> itens) {
		this.itens = itens;
	}
	
	
	
}
