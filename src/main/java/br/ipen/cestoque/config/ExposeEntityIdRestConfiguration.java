package br.ipen.cestoque.config;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

import br.ipen.cestoque.domain.InsumoLocalizacao;

@Component
public class ExposeEntityIdRestConfiguration implements RepositoryRestConfigurer{
	
	@Override
      public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        config.exposeIdsFor(InsumoLocalizacao.class);
        //config.exposeIdsFor(Library.class);
      }

	
}
