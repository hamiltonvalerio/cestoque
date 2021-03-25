package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.DynamicUpdate;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@DynamicUpdate
public class InsumoLocalizacao implements Serializable {

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

	@ManyToOne
	@JoinColumn(name = "localizacao_id", nullable = false)
	private Localizacao localizacao;

	private Double quantidade;

	private Double quantidademinima;

	private String loteFornecedor;

	private String loteCR;

	private String loteProducao;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataIrradiacao;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dataValidade;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataAprovacao;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataReprovacao;

	private Boolean aprovado;

	@Transient
	private String nomedoinsumo;
	
	private String loteRecebimento; 
	
	@Transient
	private String foiaprovado;
	
	@Transient
	private String emaprovacao;

	/*
	 * @ManyToMany
	 * 
	 * @JoinTable(name = "INSUMOS_LOCALIZACOES", joinColumns = @JoinColumn(name =
	 * "insumolocalizacao_id"), inverseJoinColumns = @JoinColumn(name =
	 * "localizacao_id") ) private List<Localizacao> localizacoes = new
	 * ArrayList<>();
	 */

	// private Localizacao localizacao;

	public InsumoLocalizacao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public InsumoLocalizacao(Integer id, Insumo insumo, Localizacao localizacao, Double quantidade,
			Double quantidademinima, String loteFornecedor, String loteCR, String loteProducao, Date dataIrradiacao,
			Date dataValidade, Date dataAprovacao, Date dataReprovacao, Boolean aprovado, String loteRecebimento) {
		super();
		this.id = id;
		this.insumo = insumo;
		this.localizacao = localizacao;
		this.quantidade = quantidade;
		this.quantidademinima = quantidademinima;
		this.loteFornecedor = loteFornecedor;
		this.loteCR = loteCR;
		this.loteProducao = loteProducao;
		this.dataIrradiacao = dataIrradiacao;
		this.dataValidade = dataValidade;
		this.dataAprovacao = dataAprovacao;
		this.dataReprovacao = dataReprovacao;
		this.aprovado = aprovado;
		this.setNomedoinsumo(insumo.getNome());
		this.loteRecebimento = loteRecebimento;
	}

	public Insumo getInsumo() {
		return insumo;
	}

	public void setInsumo(Insumo insumo) {
		this.insumo = insumo;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	/*
	 * public List<Localizacao> getLocalizacoes() { return localizacoes; }
	 * 
	 * public void setLocalizacoes(List<Localizacao> localizacoes) {
	 * this.localizacoes = localizacoes; }
	 */

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public Double getQuantidademinima() {
		return quantidademinima;
	}

	public void setQuantidademinima(Double quantidademinima) {
		this.quantidademinima = quantidademinima;
	}

	public String getLoteCR() {
		return loteCR;
	}

	public void setLoteCR(String loteCR) {
		this.loteCR = loteCR;
	}

	public Date getDataIrradiacao() {
		return dataIrradiacao;
	}

	public void setDataIrradiacao(Date dataIrradiacao) {
		this.dataIrradiacao = dataIrradiacao;
	}

	public Date getDataValidade() {
		return dataValidade;
	}

	public void setDataValidade(Date dataValidade) {
		this.dataValidade = dataValidade;
	}

	public Date getDataAprovacao() {
		return dataAprovacao;
	}

	public void setDataAprovacao(Date dataAprovacao) {
		this.dataAprovacao = dataAprovacao;
	}

	public Date getDataReprovacao() {
		return dataReprovacao;
	}

	public void setDataReprovacao(Date dataReprovacao) {
		this.dataReprovacao = dataReprovacao;
	}

	public Boolean getAprovado() {
		return aprovado;
	}

	public void setAprovado(Boolean aprovado) {
		this.aprovado = aprovado;
	}

	public String getLoteProducao() {
		return loteProducao;
	}

	public void setLoteProducao(String loteProducao) {
		this.loteProducao = loteProducao;
	}

	public String getLoteFornecedor() {
		return loteFornecedor;
	}

	public void setLoteFornecedor(String loteFornecedor) {
		this.loteFornecedor = loteFornecedor;
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
		InsumoLocalizacao other = (InsumoLocalizacao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomedoinsumo() {
		if (this.getInsumo().getNome() != null) {
			this.nomedoinsumo = this.getInsumo().getNome() + " Lote Fornecedor:" + this.getLoteFornecedor()
					+ " Data Validade:" + this.getDataValidade();

		}
		return nomedoinsumo;
	}

	public void setNomedoinsumo(String nomedoinsumo) {
		this.nomedoinsumo = nomedoinsumo;
	}

	public String getLoteRecebimento() {
		return loteRecebimento;
	}

	public void setLoteRecebimento(String loteRecebimento) {
		this.loteRecebimento = loteRecebimento;
	}

	public String getFoiaprovado() {
		if(this.aprovado != null) {
			if(this.aprovado == true) {
				this.foiaprovado = "SIM";
			}else {
				this.foiaprovado = "NÃO";
			}
		}
		return foiaprovado;
	}

	public void setFoiaprovado(String foiaprovado) {
		this.foiaprovado = foiaprovado;
	}
	

}
