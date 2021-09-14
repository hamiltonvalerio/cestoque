package br.ipen.cestoque.domain.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.stream.*;

@JsonFormat(shape = JsonFormat.Shape.OBJECT) // custom serializer
@JsonDeserialize(using = EnumTipoConsumoDeserializer.class) // custom deserializer
public enum TipoConsumo{

	MOVIMENTO(1, "Como eu movimento"),
	CONSUMO(2, "Como eu consumo"),
	ENTRADA(3, "Como eu dou entrada"),
	SAIDA(4, "Como eu dou saída");
	
	private Integer id;
	private String nome;
	
	private TipoConsumo(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
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
	
	public static TipoConsumo toEnum(Integer cod) {
		
		if(cod == null) {
			return null;
		}
		
		for(TipoConsumo ep : TipoConsumo.values()) {
			if(cod.equals(ep.getId())) {
				return ep;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: "+cod);
	}

	public static TipoConsumo of(int tipoconsumo) {
        return Stream.of(TipoConsumo.values())
          .filter(p -> p.getId() == tipoconsumo)
          .findFirst()
          .orElseThrow(IllegalArgumentException::new);
    }
	
	
}
