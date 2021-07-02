package br.ipen.cestoque.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.ipen.cestoque.domain.Perfil;

@Repository
public interface PerfilRepository extends JpaRepository<Perfil, Integer>{

}
