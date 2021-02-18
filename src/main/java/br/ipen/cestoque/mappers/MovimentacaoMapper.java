package br.ipen.cestoque.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import br.ipen.cestoque.domain.InsumoMovimentacao;
import br.ipen.cestoque.domain.Movimentacao;
import br.ipen.cestoque.dto.InsumoMovimentacaoDTO;
import br.ipen.cestoque.dto.MovimentacaoDTO;

@Mapper(componentModel = "spring", uses = {InsumoMovimentacaoMapper.class})
public interface MovimentacaoMapper{
	

	MovimentacaoDTO tomovimentacaoDTO(Movimentacao movimentacao);
	
	InsumoMovimentacaoDTO toinsumoMovimentacaoDTO(InsumoMovimentacao insumoMovimentacao);
	
	List<MovimentacaoDTO> tolistmovimentacaoDTO(List<Movimentacao> listaMovimentacao);
}
