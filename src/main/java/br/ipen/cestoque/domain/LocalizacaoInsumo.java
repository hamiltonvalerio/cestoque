package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class LocalizacaoInsumo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@EmbeddedId
	private LocalizacaoInsumoPK id = new LocalizacaoInsumoPK();

	private Date data;

	public LocalizacaoInsumo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LocalizacaoInsumo(Localizacao localizacao, Insumo insumo, Date data) {
		super();
		id.setLocalizacao(localizacao);
		id.setInsumo(insumo);
		this.data = data;
	}
	
	public Localizacao getLocalizacao() {
		return id.getLocalizacao();
	}
	
	public Insumo getInsumo() {
		return id.getInsumo();
	}

	public LocalizacaoInsumoPK getId() {
		return id;
	}

	public void setId(LocalizacaoInsumoPK id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
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
		LocalizacaoInsumo other = (LocalizacaoInsumo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
}
