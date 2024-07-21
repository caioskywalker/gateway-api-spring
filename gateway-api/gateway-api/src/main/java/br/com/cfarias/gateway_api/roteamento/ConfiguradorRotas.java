package br.com.cfarias.gateway_api.roteamento;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguradorRotas {
	
	@Bean
	public RouteLocator minhasRotas(RouteLocatorBuilder builder) {
		 return builder.routes()
	                .route("caio-get", p -> p
	                        .path( "/get")
	                        .filters(f -> f.addRequestHeader("Oi", "Caio"))
	                        .uri("https://httpbin.org"))
	                .route("caio-host", p -> p
	                        .host("*.ebac.com.br")
	                        .filters(f -> f.addRequestHeader("Origem", "Site da Ebac"))
	                        .uri("https://httpbin.org"))
	                .build();
	}
	

	
}
