package br.ipen.cestoque;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import br.ipen.cestoque.services.ArmazenamentoService;

@SpringBootApplication(exclude = {MultipartAutoConfiguration.class})
@EnableAsync
@EnableConfigurationProperties(ApplicationProperties.class)
public class CestoqueApplication extends SpringBootServletInitializer{
	
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(CestoqueApplication.class);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(CestoqueApplication.class, args);
	}

	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver multipartResolver() {
	    CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
	    multipartResolver.setMaxUploadSize(10000000);
	    return multipartResolver;
	}
	
	@Bean
	ApplicationRunner init(ArmazenamentoService armazenamentoService) {
		return args -> {
			armazenamentoService.deleteAll();
			armazenamentoService.init();
		};
	}
	

}
