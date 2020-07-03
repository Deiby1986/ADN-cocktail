package com.cocktail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableAutoConfiguration
@EnableJpaAuditing
@EnableJms
public class CocktailActivemqApplication {
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CocktailActivemqApplication.class, args);
	}	
	

}
