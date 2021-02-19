package br.ipen.cestoque.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.springframework.context.annotation.Bean;

import br.ipen.cestoque.domain.InsumoMovimentacao;
import br.ipen.cestoque.domain.Movimentacao;
import br.ipen.cestoque.dto.InsumoMovimentacaoDTO;
import br.ipen.cestoque.dto.MovimentacaoDTO;

@Mapper(componentModel = "spring", uses = {InsumoMovimentacaoMapper.class})
public interface MovimentacaoMapper{
	
	@Bean
	MovimentacaoDTO tomovimentacaoDTO(Movimentacao movimentacao);
	@Bean
	InsumoMovimentacaoDTO toinsumoMovimentacaoDTO(InsumoMovimentacao insumoMovimentacao);
	@Bean
	List<MovimentacaoDTO> tolistmovimentacaoDTO(List<Movimentacao> listaMovimentacao);
}
