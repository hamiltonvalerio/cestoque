package br.ipen.cestoque.domain.enums;

public enum Perfil {

	ADMIN(1, "ROLE_ADMIN", "ADMINISTRADOR"),
	BUFFER(2, "ROLE_BUFFER", "BUFFER"),
	PRODUCAO(3, "ROLE_PRODUCAO", "PRODUCAO"),
	QUALIDADE(4, "ROLE_QUALIDADE", "CONTROLE DE QUALIDADE"),
	ALMOXARIFADOCR(5, "ROLE_ALMOXARIFADOCR", "ALMOXARIFADO CR"),
	IRRADIACAO(6, "ROLE_IRRADIACAO", "IRRADIAÇÃO"),
	VISUALIZACAO(7, "ROLE_VISUALIZACAO", "VISUALIZAÇÃO");
	
	private int cod;
	private String descricao;
	private String nome;
	
	private Perfil(int cod, String descricao, String nome) {
		this.cod = cod;
		this.descricao = descricao;
		this.nome = nome;
	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public static Perfil toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(Perfil ep : Perfil.values()) {
			if(cod.equals(ep.getCod())) {
				return ep;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: "+cod);
	}

}
