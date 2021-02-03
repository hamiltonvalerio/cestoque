package br.ipen.cestoque.dto;

import br.ipen.cestoque.domain.Insumo;

public class InsumoLocalizacaoVisDTO {
	
	private Insumo insumo = new Insumo();
	private String  insumolocalizacao;
	private String  quantlocalizacao;
	
	public Insumo getInsumo() {
		return insumo;
	}
	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}
	public String getInsumolocalizacao() {
		return insumolocalizacao;
	}
	public void setInsumolocalizacao(String insumolocalizacao) {
		this.insumolocalizacao = insumolocalizacao;
	}
	public String getQuantlocalizacao() {
		return quantlocalizacao;
	}
	public void setQuantlocalizacao(String quantlocalizacao) {
		this.quantlocalizacao = quantlocalizacao;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((insumo == null) ? 0 : insumo.hashCode());
		result = prime * result + ((insumolocalizacao == null) ? 0 : insumolocalizacao.hashCode());
		result = prime * result + ((quantlocalizacao == null) ? 0 : quantlocalizacao.hashCode());
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
		InsumoLocalizacaoVisDTO other = (InsumoLocalizacaoVisDTO) obj;
		if (insumo == null) {
			if (other.insumo != null)
				return false;
		} else if (!insumo.equals(other.insumo))
			return false;
		if (insumolocalizacao == null) {
			if (other.insumolocalizacao != null)
				return false;
		} else if (!insumolocalizacao.equals(other.insumolocalizacao))
			return false;
		if (quantlocalizacao == null) {
			if (other.quantlocalizacao != null)
				return false;
		} else if (!quantlocalizacao.equals(other.quantlocalizacao))
			return false;
		return true;
	}
	
	

}
