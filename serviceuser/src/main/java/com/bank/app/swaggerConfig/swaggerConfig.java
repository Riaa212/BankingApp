package com.bank.app.swaggerConfig;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class swaggerConfig {

	 @Bean
	    public OpenAPI customOpenAPI() {
	        return new OpenAPI()
	            .info(new Info()
	                .title("My App API")
	                .version("1.0.0")
	                .description("API documentation for My Spring Boot App"));
	    }
}
