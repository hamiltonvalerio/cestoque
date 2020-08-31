package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CNPJ;

import br.ipen.cestoque.domain.Fornecedor;

public class FornecedorDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private String cod_fornecedor;

	@NotEmpty(message = "Preenchimento obrigatório!")
	private String nome;

	@NotEmpty(message = "Preenchimento obrigatório!")
	@CNPJ
	private String cnpj;

	private String usualt;

	private Date datalt;

	public FornecedorDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FornecedorDTO(Fornecedor obj) {
		id = obj.getId();
		nome = obj.getNome();
		cnpj = obj.getCnpj();
		usualt = obj.getUsualt();
		datalt = obj.getDatalt();
		cod_fornecedor = obj.getCod_fornecedor();
	}

	
	
	public FornecedorDTO(Integer id, String cod_fornecedor,
			@NotEmpty(message = "Preenchimento obrigatório!") String nome,
			@NotEmpty(message = "Preenchimento obrigatório!") @CNPJ String cnpj, String usualt, Date datalt) {
		super();
		this.id = id;
		this.cod_fornecedor = cod_fornecedor;
		this.nome = nome;
		this.cnpj = cnpj;
		this.usualt = usualt;
		this.datalt = datalt;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
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

	public String getCod_fornecedor() {
		return cod_fornecedor;
	}

	public void setCod_fornecedor(String cod_fornecedor) {
		this.cod_fornecedor = cod_fornecedor;
	}

}
