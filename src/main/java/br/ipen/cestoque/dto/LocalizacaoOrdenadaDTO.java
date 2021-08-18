package br.ipen.cestoque.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.ipen.cestoque.domain.Localizacao;

public class LocalizacaoOrdenadaDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Localizacao localizacao;
	
	private List<Localizacao> localizacoesfilhas = new ArrayList<>();
	
	

	public LocalizacaoOrdenadaDTO() {
		// TODO Auto-generated constructor stub
	}



	public Localizacao getLocalizacao() {
		return localizacao;
	}



	public void setLocalizacao(Localizacao localizacao) {
		this.localizacao = localizacao;
	}



	public List<Localizacao> getLocalizacoesfilhas() {
		return localizacoesfilhas;
	}



	public void setLocalizacoesfilhas(List<Localizacao> localizacoesfilhas) {
		this.localizacoesfilhas = localizacoesfilhas;
	}
	
	
	

}
