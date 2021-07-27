package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import br.ipen.cestoque.domain.Categoria;
import br.ipen.cestoque.domain.Insumo;
import br.ipen.cestoque.domain.Orgao;
import br.ipen.cestoque.domain.Unidade;

public class InsumoDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nomenclatura;
	private String nome;
	private Double valor;
	private String codigoalmox;
	private String observacao;
	private Boolean essencial;

	private Date datavalidade;

	private Double quantidade;
	private Double taxadeconsumo;
	private String codigobarra;
	private String qrcode;
	private String rfid;

	private String usualt;
	private Date datalt;

	private Unidade unidade;

	private Integer codinsumofornecedor;
	private Boolean irradiado;
	private Date datairradiado;
	private Boolean amostracq;
	private Date dataamostracq;
	private String lote;
	private String nomecodalmox;

	private Double quantidadeTotalAtual;

	private List<Categoria> categorias = new ArrayList<>();

	private Boolean precisairradiacao;

	private Boolean precisacontrolequalidade;
	
	private Boolean controlado;

	private List<Orgao> orgaos = new ArrayList<>();

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
		codigoalmox = obj.getCodigoalmox();
		essencial = obj.getEssencial();
		datavalidade = obj.getDatavalidade();
		quantidade = obj.getQuantidade();
		taxadeconsumo = obj.getTaxadeconsumo();
		codigobarra = obj.getCodigobarra();
		qrcode = obj.getQrcode();
		rfid = obj.getRfid();
		usualt = obj.getUsualt();
		datalt = obj.getDatalt();
		unidade = obj.getUnidade();
		codinsumofornecedor = obj.getCodinsumofornecedor();
		irradiado = obj.getIrradiado();
		datairradiado = obj.getDatairradiado();
		amostracq = obj.getAmostracq();
		dataamostracq = obj.getDataamostracq();
		lote = obj.getLote();
		nomecodalmox = obj.getNome() + " - " + obj.getCodigoalmox();
		categorias = obj.getCategorias();
		quantidadeTotalAtual = obj.getQuantidadeTotalAtual();
		precisairradiacao = obj.getPrecisairradiacao();
		precisacontrolequalidade = obj.getPrecisacontrolequalidade();
		orgaos = obj.getOrgaos();
		controlado = obj.getControlado();
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

	public String getCodigoalmox() {
		return codigoalmox;
	}

	public void setCodigoalmox(String codigoalmox) {
		this.codigoalmox = codigoalmox;
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

	public Date getDatavalidade() {
		return datavalidade;
	}

	public void setDatavalidade(Date datavalidade) {
		this.datavalidade = datavalidade;
	}

	public Double getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Double quantidade) {
		this.quantidade = quantidade;
	}

	public String getCodigobarra() {
		return codigobarra;
	}

	public void setCodigobarra(String codigobarra) {
		this.codigobarra = codigobarra;
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

	public Double getTaxadeconsumo() {
		return taxadeconsumo;
	}

	public void setTaxadeconsumo(Double taxadeconsumo) {
		this.taxadeconsumo = taxadeconsumo;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public Integer getCodinsumofornecedor() {
		return codinsumofornecedor;
	}

	public void setCodinsumofornecedor(Integer codinsumofornecedor) {
		this.codinsumofornecedor = codinsumofornecedor;
	}

	public Boolean getIrradiado() {
		return irradiado;
	}

	public void setIrradiado(Boolean irradiado) {
		this.irradiado = irradiado;
	}

	public Date getDatairradiado() {
		return datairradiado;
	}

	public void setDatairradiado(Date datairradiado) {
		this.datairradiado = datairradiado;
	}

	public Boolean getAmostracq() {
		return amostracq;
	}

	public void setAmostracq(Boolean amostracq) {
		this.amostracq = amostracq;
	}

	public Date getDataamostracq() {
		return dataamostracq;
	}

	public void setDataamostracq(Date dataamostracq) {
		this.dataamostracq = dataamostracq;
	}

	public String getLote() {
		return lote;
	}

	public void setLote(String lote) {
		this.lote = lote;
	}

	public String getNomecodalmox() {
		return nomecodalmox;
	}

	public void setNomecodalmox(String nomecodalmox) {
		this.nomecodalmox = nomecodalmox;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

	public Double getQuantidadeTotalAtual() {
		return quantidadeTotalAtual;
	}

	public void setQuantidadeTotalAtual(Double quantidadeTotalAtual) {
		this.quantidadeTotalAtual = quantidadeTotalAtual;
	}

	public Boolean getPrecisairradiacao() {
		return precisairradiacao;
	}

	public void setPrecisairradiacao(Boolean precisairradiacao) {
		this.precisairradiacao = precisairradiacao;
	}

	public Boolean getPrecisacontrolequalidade() {
		return precisacontrolequalidade;
	}

	public void setPrecisacontrolequalidade(Boolean precisacontrolequalidade) {
		this.precisacontrolequalidade = precisacontrolequalidade;
	}

	public List<Orgao> getOrgaos() {
		return orgaos;
	}

	public void setOrgaos(List<Orgao> orgaos) {
		this.orgaos = orgaos;
	}

	public Boolean getControlado() {
		return controlado;
	}

	public void setControlado(Boolean controlado) {
		this.controlado = controlado;
	}

}
