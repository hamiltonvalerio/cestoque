package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.ipen.cestoque.domain.Insumo;

public class InsumoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nomenclatura;
	private String nome;
	private Double valor;
	private Integer codigo_almox;
	private String observacao;
	private Boolean essencial;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date data_validade;
	
	private Double quantidade;
	
	private String codigo_barra;
	private String qrcode;
	private String rfid;
	
	private String usualt;	
	private Date datalt;
	
	public InsumoDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public InsumoDTO(Insumo obj) {
		id = obj.getId();
		nomenclatura = obj.getNomenclatura();
		nome = obj.getNome();
		valor = obj.getValor();
		observacao = obj.getObservacao();
		codigo_almox = obj.getCodigo_almox();
		essencial = obj.getEssencial();
		data_validade = obj.getData_validade();
		quantidade = obj.getQuantidade();
		codigo_barra = obj.getCodigo_barra();
		qrcode = obj.getQrcode();
		rfid = obj.getRfid();
		usualt = obj.getUsualt();	
		datalt = obj.getDatalt();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomenclatura() {
		return nomenclatura;
	}

	public void setNomenclatura(String nomenclatura) {
		this.nomenclatura = nomenclatura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Integer getCodigo_almox() {
		return codigo_almox;
	}

	public void setCodigo_almox(Integer codigo_almox) {
		this.codigo_almox = codigo_almox;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Boolean getEssencial() {
		return essencial;
	}

	public void setEssencial(Boolean essencial) {
		this.essencial = essencial;
	}

	public Date getData_validade() {
		return data_validade;
	}

	public void setData_validade(Date data_validade) {
		this.data_validade = data_validade;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public String getCodigo_barra() {
		return codigo_barra;
	}

	public void setCodigo_barra(String codigo_barra) {
		this.codigo_barra = codigo_barra;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public String getRfid() {
		return rfid;
	}

	public void setRfid(String rfid) {
		this.rfid = rfid;
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
	
	
}
