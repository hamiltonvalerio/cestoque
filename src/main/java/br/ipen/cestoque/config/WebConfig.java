package br.ipen.cestoque.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {

	/*@Autowired
	EntradaServiceInterceptor entradaServiceInterceptor;*/

	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("http://10.0.14.7:8081").allowedMethods("GET", "POST", "PUT");
	}

	/*@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(entradaServiceInterceptor).addPathPatterns("/entradas");
	}*/

}
