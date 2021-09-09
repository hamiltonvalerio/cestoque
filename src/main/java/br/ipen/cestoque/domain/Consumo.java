package br.ipen.cestoque.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import br.ipen.cestoque.domain.enums.TipoConsumo;

@Entity
@DynamicUpdate(value = true)
@Table(name = "consumo")
public class Consumo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "insumo_id", nullable = false)
	private Insumo insumo;
	
	private TipoConsumo tipoconsumo;
	
	@ManyToOne
	@JoinColumn(name = "unidadetipo_id", nullable = false)
	private Unidade unidadetipo;
	
	private Double quantidadecon;
	
	@ManyToOne
	@JoinColumn(name = "unidadecon_id", nullable = false)
	private Unidade unidadecon;

	public Consumo() {
		// TODO Auto-generated constructor stub
	}

	public Consumo(Integer id, Insumo insumo, TipoConsumo tipoconsumo, Unidade unidadetipo, Double quantidadecon,
			Unidade unidadecon) {
		super();
		this.id = id;
		this.insumo = insumo;
		this.tipoconsumo = tipoconsumo;
		this.unidadetipo = unidadetipo;
		this.quantidadecon = quantidadecon;
		this.unidadecon = unidadecon;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public TipoConsumo getTipoconsumo() {
		return tipoconsumo;
	}

	public void setTipoconsumo(TipoConsumo tipoconsumo) {
		this.tipoconsumo = tipoconsumo;
	}

	public Unidade getUnidadetipo() {
		return unidadetipo;
	}

	public void setUnidadetipo(Unidade unidadetipo) {
		this.unidadetipo = unidadetipo;
	}

	public Double getQuantidadecon() {
		return quantidadecon;
	}

	public void setQuantidadecon(Double quantidadecon) {
		this.quantidadecon = quantidadecon;
	}

	public Unidade getUnidadecon() {
		return unidadecon;
	}

	public void setUnidadecon(Unidade unidadecon) {
		this.unidadecon = unidadecon;
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
		Consumo other = (Consumo) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
