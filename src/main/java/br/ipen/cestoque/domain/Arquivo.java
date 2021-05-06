package br.ipen.cestoque.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.hibernate.annotations.Type;

@Entity
public class Arquivo implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String tipo;
	
	@Type(type="org.hibernate.type.BinaryType") 
	private byte[] data;

	public Arquivo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Arquivo(String nome, String tipo) {
		super();
		this.nome = nome;
		this.tipo = tipo;
	}

	public Arquivo(Integer id, String nome, String tipo, byte[] data) {
		super();
		this.id = id;
		this.nome = nome;
		this.tipo = tipo;
		this.data = data;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
	
}
