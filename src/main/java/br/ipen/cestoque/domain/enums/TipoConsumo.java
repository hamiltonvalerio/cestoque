package br.ipen.cestoque.domain.enums;

public enum TipoConsumo {

	MOVIMENTO(1, "Como eu movimento"),
	CONSUMO(2, "Como eu consumo"),
	ENTRADA(3, "Como eu dou entrada"),
	SAIDA(4, "Como eu dou saída");
	
	private int cod;
	private String descricao;
	
	private TipoConsumo(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
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
	
	public static TipoConsumo toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(TipoConsumo ep : TipoConsumo.values()) {
			if(cod.equals(ep.getCod())) {
				return ep;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
	
	
}
