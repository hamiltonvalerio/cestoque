package br.ipen.cestoque.domain.enums;

public enum EstadoProducao {

	EMPRODUCAO(1, "Em produção"),
	FINALIZADO(2, "Finalizado");
	
	private int cod;
	private String descricao;
	
	private EstadoProducao(int cod, String descricao) {
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
	
	public static EstadoProducao toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(EstadoProducao ep : EstadoProducao.values()) {
			if(cod.equals(ep.getCod())) {
				return ep;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: "+cod);
	}
	
	
}
