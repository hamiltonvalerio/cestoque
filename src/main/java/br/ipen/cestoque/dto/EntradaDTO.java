package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.ipen.cestoque.domain.Entrada;
import br.ipen.cestoque.domain.InsumoEntrada;

public class EntradaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataEntrada;
	
	private String numeronf;

	private String numLIA;
	
	private String numProcesso;
	
	private String numRequisicao;
	
	private String usualt;
	private Date datalt;
	
	private Boolean show;
	
	private Set<InsumoEntrada> itens = new HashSet<>();
	
	public EntradaDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public EntradaDTO(Entrada obj) {
		super();
		this.id = obj.getId();
		this.dataEntrada = obj.getDataEntrada();
		this.numeronf = obj.getNumeronf();
		this.numLIA = obj.getNumLIA();
		this.numProcesso = obj.getNumProcesso();
		this.numRequisicao = obj.getNumRequisicao();
		this.usualt = obj.getUsualt();
		this.datalt = obj.getDatalt();
		this.itens.addAll(obj.getItens());
		this.show = false;
	}
	
	


	public EntradaDTO(Integer id, Date dataEntrada, String numeronf, String  numLIA, String numProcesso, String numRequisicao, String usualt, Date datalt,
			Set<InsumoEntrada> itens) {
		super();
		this.id = id;
		this.dataEntrada = dataEntrada;
		this.numeronf = numeronf;
		this.numLIA = numLIA;
		this.numProcesso = numProcesso;
		this.numRequisicao = numRequisicao;
		this.usualt = usualt;
		this.datalt = datalt;
		this.itens = itens;
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

	public Set<InsumoEntrada> getItens() {
		return itens;
	}

	public void setItens(Set<InsumoEntrada> itens) {
		this.itens = itens;
	}

	public Boolean getShow() {
		return show;
	}

	public void setShow(Boolean show) {
		this.show = show;
	}
	
	
	
}
