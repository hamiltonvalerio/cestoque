package br.ipen.cestoque.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import br.ipen.cestoque.domain.InsumoMovimentacao;
import br.ipen.cestoque.dto.InsumoMovimentacaoDTO;

@Mapper(componentModel = "spring", uses = {MovimentacaoMapper.class})
public interface InsumoMovimentacaoMapper {
	
	 List<InsumoMovimentacaoDTO> toDto(final List<InsumoMovimentacao> book);

}
