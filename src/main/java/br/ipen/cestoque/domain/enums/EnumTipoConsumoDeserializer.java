package br.ipen.cestoque.domain.enums;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

public class EnumTipoConsumoDeserializer extends JsonDeserializer<TipoConsumo>{

	 	@Override
	    public TipoConsumo deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
	        JsonNode node = jsonParser.getCodec().readTree(jsonParser);
	        
	        String cod = node.get("id").asText();
	   
	        
	        for(TipoConsumo tc : TipoConsumo.values()) {
	        	if(tc.getId().equals(Integer.parseInt(cod))) {
	        		return tc;
	        	}
	        }
	        return null;
	        
	    }

}
