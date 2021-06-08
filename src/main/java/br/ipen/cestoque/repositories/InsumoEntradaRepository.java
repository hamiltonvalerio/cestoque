package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.InsumoEntrada;

@Repository
public interface InsumoEntradaRepository extends JpaRepository<InsumoEntrada, Integer>{
	
	@Query(value="SELECT true FROM insumoentrada ie "
			+ "	WHERE "
			+ "	ie.lotelei =:lotelei ", 
			nativeQuery = true)
	public Boolean findTrueByLoteLEI(
			@Param("lotelei") String lotelei);
}
