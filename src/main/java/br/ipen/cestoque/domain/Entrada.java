package br.ipen.cestoque.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.envers.Audited;
import org.hibernate.envers.NotAudited;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Audited
@Table(name = "entrada")
public class Entrada implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataEntrada;

	private String numeronf;

	private String numLIA;

	private String numProcesso;

	private String numRequisicao;

	private String loteRecebimento;

	private String usualt;
	private Date datalt;

	@ManyToOne
	@JoinColumn(name = "localizacao_id")
	private Localizacao localizacao;

	@OneToMany(mappedBy = "entrada")
	private List<InsumoEntrada> itens = new ArrayList<>();

	@OneToMany(mappedBy = "entrada")
	@NotAudited
	private List<EntradaArquivo> arquivos = new ArrayList<>();

	public Entrada() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Entrada(Integer id, Date dataEntrada, String numeronf, String numLIA, String numProcesso,
			String numRequisicao, String loteRecebimento, String usualt, Date datalt, Localizacao localizacao) {
		super();
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.numeronf = numeronf;
		this.numLIA = numLIA;
		this.numProcesso = numProcesso;
		this.numRequisicao = numRequisicao;
		this.setLoteRecebimento(loteRecebimento);
		this.usualt = usualt;
		this.datalt = datalt;
		this.localizacao = localizacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public String getNumeronf() {
		return numeronf;
	}

	public void setNumeronf(String numeronf) {
		this.numeronf = numeronf;
	}

	public String getNumLIA() {
		return numLIA;
	}

	public void setNumLIA(String numLIA) {
		this.numLIA = numLIA;
	}

	public String getNumProcesso() {
		return numProcesso;
	}

	public void setNumProcesso(String numProcesso) {
		this.numProcesso = numProcesso;
	}

	public String getNumRequisicao() {
		return numRequisicao;
	}

	public void setNumRequisicao(String numRequisicao) {
		this.numRequisicao = numRequisicao;
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

	public List<InsumoEntrada> getItens() {
		return itens;
	}

	public void setItens(List<InsumoEntrada> itens) {
		this.itens = itens;
	}

	public List<EntradaArquivo> getArquivos() {
		return arquivos;
	}

	public void setArquivos(List<EntradaArquivo> arquivos) {
		this.arquivos = arquivos;
	}

	public Localizacao getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}

	public String getLoteRecebimento() {
		return loteRecebimento;
	}

	public void setLoteRecebimento(String loteRecebimento) {
		this.loteRecebimento = loteRecebimento;
	}

}
