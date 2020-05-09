package br.ipen.cestoque.domain;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class InsumoSaidaPK implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "saida_id")
	private Saida saida;
	
	@ManyToOne
	@JoinColumn(name = "insumo_id")
	private Insumo insumo;

	public Saida getSaida() {
		return saida;
	}

	public void setSaida(Saida saida) {
		this.saida = saida;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((saida == null) ? 0 : saida.hashCode());
		result = prime * result + ((insumo == null) ? 0 : insumo.hashCode());
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
		InsumoSaidaPK other = (InsumoSaidaPK) obj;
		if (saida == null) {
			if (other.saida != null)
				return false;
		} else if (!saida.equals(other.saida))
			return false;
		if (insumo == null) {
			if (other.insumo != null)
				return false;
		} else if (!insumo.equals(other.insumo))
			return false;
		return true;
	}
	
	

}
