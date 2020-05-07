package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

import br.ipen.cestoque.domain.enums.EstadoProducao;

@Entity
public class Producao implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

		@Id
		private Integer id;
		private EstadoProducao estadoProducao;
		
		private String usualt;
		private Date datalt;
		
		@OneToOne
		@JoinColumn(name = "produto_id")
		@MapsId
		private Produto produto;
		
		public Producao() {
			super();
			// TODO Auto-generated constructor stub
		}

		

		public Producao(Integer id, EstadoProducao estadoProducao, String usualt, Date datalt, Produto produto) {
			super();
			this.id = id;
			this.estadoProducao = estadoProducao;
			this.usualt = usualt;
			this.datalt = datalt;
			this.setProduto(produto);
		}



		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public EstadoProducao getEstadoProducao() {
			return estadoProducao;
		}

		public void setEstadoProducao(EstadoProducao estadoProducao) {
			this.estadoProducao = estadoProducao;
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
			Producao other = (Producao) obj;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			return true;
		}



		public Produto getProduto() {
			return produto;
		}



		public void setProduto(Produto produto) {
			this.produto = produto;
		}
		
		
		
		
}
