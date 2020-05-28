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
public class Entrada implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date data_entrada;
	
	
	private String numeronf;
	
	private String usualt;
	private Date datalt;
	
	@OneToMany(mappedBy = "id.entrada")
	private Set<InsumoEntrada> itens = new HashSet<>();
	
	public Entrada() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entrada(Integer id, Date data_entrada, String numeronf, String usualt, Date datalt) {
		super();
		this.id = id;
		this.data_entrada = data_entrada;
		this.numeronf = numeronf;
		this.usualt = usualt;
		this.datalt = datalt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData_entrada() {
		return data_entrada;
	}

	public void setData_entrada(Date data_entrada) {
		this.data_entrada = data_entrada;
	}

	public String getNumeronf() {
		return numeronf;
	}

	public void setNumeronf(String numeronf) {
		this.numeronf = numeronf;
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
		Entrada other = (Entrada) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Set<InsumoEntrada> getItens() {
		return itens;
	}

	public void setItens(Set<InsumoEntrada> itens) {
		this.itens = itens;
	}
	
	
	
}
