package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.Unidade;

public class InsumoDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nomenclatura;
	private String nome;
	private Double valor;
	private String codigo_almox;
	private String observacao;
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
	
	private Integer cod_insumo_fornecedor;
	private Boolean irradiado;
	private Date data_irradiado;
	private Boolean amostra_cq;
	private Date data_amostra_cq;
	private String lote;
	private String nome_codalmox;
	
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
		taxa_de_consumo = obj.getTaxa_de_consumo();
		codigo_barra = obj.getCodigo_barra();
		qrcode = obj.getQrcode();
		rfid = obj.getRfid();
		usualt = obj.getUsualt();	
		datalt = obj.getDatalt();
		unidade = obj.getUnidade();
		cod_insumo_fornecedor = obj.getCod_insumo_fornecedor();
		irradiado = obj.getIrradiado();
		data_irradiado = obj.getData_irradiado();
		amostra_cq = obj.getAmostra_cq();
		data_amostra_cq = obj.getData_amostra_cq();
		lote = obj.getLote();
		nome_codalmox = obj.getNome() +" - "+ obj.getCodigo_almox();
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

	public String getCodigo_almox() {
		return codigo_almox;
	}

	public void setCodigo_almox(String codigo_almox) {
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

	public Integer getCod_insumo_fornecedor() {
		return cod_insumo_fornecedor;
	}

	public void setCod_insumo_fornecedor(Integer cod_insumo_fornecedor) {
		this.cod_insumo_fornecedor = cod_insumo_fornecedor;
	}

	public Boolean getIrradiado() {
		return irradiado;
	}

	public void setIrradiado(Boolean irradiado) {
		this.irradiado = irradiado;
	}

	public Date getData_irradiado() {
		return data_irradiado;
	}

	public void setData_irradiado(Date data_irradiado) {
		this.data_irradiado = data_irradiado;
	}

	public Boolean getAmostra_cq() {
		return amostra_cq;
	}

	public void setAmostra_cq(Boolean amostra_cq) {
		this.amostra_cq = amostra_cq;
	}

	public Date getData_amostra_cq() {
		return data_amostra_cq;
	}

	public void setData_amostra_cq(Date data_amostra_cq) {
		this.data_amostra_cq = data_amostra_cq;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getNome_codalmox() {
		return nome_codalmox;
	}

	public void setNome_codalmox(String nome_codalmox) {
		this.nome_codalmox = nome_codalmox;
	}
	
	
}
