package br.ipen.cestoque.domain;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	@JoinColumn(name = "insumo_id", nullable=false)
	private Insumo insumo;
	
	@ManyToOne
	@JoinColumn(name = "unidadetipo_id", nullable = false)
	private Unidade unidadetipo;
	
	private Double quantidadecon;
	
	@ManyToOne
	@JoinColumn(name = "unidadecon_id", nullable = false)
	private Unidade unidadecon;

	@Basic
	private Integer tipoconsumo_id;
	
	private TipoConsumo tipoconsumo;

	public Consumo() {
		// TODO Auto-generated constructor stub
	}

	public Consumo(Integer id, Insumo insumo, Unidade unidadetipo, Double quantidadecon, Unidade unidadecon,
			int tipoconsumo_id, TipoConsumo tipoconsumo) {
		super();
		this.id = id;
		this.insumo = insumo;
		this.unidadetipo = unidadetipo;
		this.quantidadecon = quantidadecon;
		this.unidadecon = unidadecon;
		this.tipoconsumo_id = tipoconsumo_id;
		this.tipoconsumo = tipoconsumo;
	}
	
	/*@PostLoad
    void fillTransient() {
        if (tipoconsumo_id > 0) {
            this.tipoconsumo = TipoConsumo.of(tipoconsumo_id);
        }
    }

    @PrePersist
    void fillPersistent() {
        if (tipoconsumo != null) {
            this.tipoconsumo_id = tipoconsumo.getId();
        }
    }*/

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@JsonIgnore
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
	
	public Integer getTipoconsumo_id() {
			return tipoconsumo_id;
	}

	public void setTipoconsumo_id(Integer tipoconsumo_id) {
		this.tipoconsumo_id = this.tipoconsumo != null ? this.getTipoconsumo().getId() : null;
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
