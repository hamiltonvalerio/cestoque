package br.ipen.cestoque.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.ipen.cestoque.domain.Localizacao;

@Repository
public interface LocalizacaoRepository extends JpaRepository<Localizacao, Integer>{

	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT l FROM Localizacao l "
			+ "INNER JOIN InsumoLocalizacao ie ON (ie.localizacao.id = l.id) ")
	public List<Localizacao> findAllInsumoLocalizacao();

	public List<Localizacao> findAllByOrderByNome();
	
	@Query("SELECT CASE WHEN COUNT(l) > 0 THEN true ELSE false END FROM Localizacao l "
			+ "WHERE l.almoxarifadoprincipal = true")
	public boolean validaAlmoxarifadoPrincipal();

	@Query("SELECT l FROM Localizacao l "
			+ "WHERE l.almoxarifadoprincipal = true")
	public Localizacao findAlmoxPrincipal();

	@Query(value="SELECT * FROM localizacao "
			+  "WHERE objlocalizacaofilha_id = :id "
			+ " AND utilizado = true ", 
			nativeQuery = true)
	public Localizacao findByLocalizacaoUtilizado(@Param("id") Integer id);
	
	@Query(value="SELECT * FROM localizacao  "
			+ " WHERE objlocalizacaofilha_id = :id "
			+ " AND descarte = true ", 
			nativeQuery = true)
	public Localizacao findByLocalizacaoDescartado(@Param("id") Integer id);

	public List<Localizacao> findByAprovacaoTrue();

	@Query(value="SELECT * FROM localizacao "
			+  "WHERE objlocalizacaofilha_id = :id ", 
				nativeQuery = true) 
	public List<Localizacao> findAllLocalizacoesFilhasByLocalizacaoPai(@Param("id") Integer id);

}
