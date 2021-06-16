package br.ipen.cestoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ipen.cestoque.domain.LocalizacaoFilha;

@Repository
public interface LocalizacaoFilhaRepository extends JpaRepository<LocalizacaoFilha, Integer>{

	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT l FROM LocalizacaoFilha l "
			+ "INNER JOIN InsumoLocalizacao ie ON (ie.localizacao.id = l.id) ")
	public List<LocalizacaoFilha> findAllInsumoLocalizacao();

	public List<LocalizacaoFilha> findAllByOrderByNome();
	
	public List<LocalizacaoFilha> findAllByLocalizacao_idOrderByNome(Integer localizacao_id);

}
