package br.ipen.cestoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ipen.cestoque.domain.InsumoMovimentacao;

@Repository
public interface InsumoMovimentacaoRepository extends JpaRepository<InsumoMovimentacao, Integer>{

	
	@Transactional(readOnly = true)
	@Query("SELECT im "
			+ "FROM InsumoMovimentacao im "
			+ "INNER JOIN im.localizacao l "
			+ "INNER JOIN im.localizacaoOrigem lo "
			+ "WHERE im.loteLEI LIKE :lotelei "
			+ "ORDER BY im.datalt ASC")
	public List<InsumoMovimentacao> movimentacoesPorLoteLEI(@Param("lotelei") String loteLEI);
		

	
	/*SELECT quantidade_origem, lo.nome as de, quantidade_movimentada, l.nome as para, im.datalt, im.usualt
	FROM public.insumomovimentacao im
	INNER JOIN public.localizacao l ON (l.id = localizacao_id)
	INNER JOIN public.localizacao lo ON (lo.id = localizacao_origem_id)
	WHERE im.lotelei LIKE 'LNJ60235T';*/
}
