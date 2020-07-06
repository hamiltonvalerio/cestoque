package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.ipen.cestoque.domain.Unidade;


public class InsumoNewDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String nomenclatura;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private String nome;
	
	private Double valor;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private Integer codigo_almox;
	
	
	private String observacao;
	
	@NotEmpty(message = "Preenchimento obrigatório!")
	private Boolean essencial;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date data_validade;
	
	
	private Double quantidade;
	
	private Double taxa_de_consumo;
	
	private String codigo_barra;
	
	private String qrcode;
	
	private String rfid;
	
	private String usualt;	
	private Date datalt;
	
	private Unidade unidade;
	
	public InsumoNewDTO() {
		super();
		// TODO Auto-generated constructor stub
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

	public Double getTaxa_de_consumo() {
		return taxa_de_consumo;
	}

	public void setTaxa_de_consumo(Double taxa_de_consumo) {
		this.taxa_de_consumo = taxa_de_consumo;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}
	
	
}
