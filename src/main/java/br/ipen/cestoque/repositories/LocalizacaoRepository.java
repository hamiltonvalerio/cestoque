package br.ipen.cestoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ipen.cestoque.domain.Localizacao;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer>{

	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT l FROM Localizacao l "
			+ "INNER JOIN InsumoLocalizacao ie ON (ie.id.localizacao.id = l.id) ")
	public List<Localizacao> findAllInsumoLocalizacao();

}
