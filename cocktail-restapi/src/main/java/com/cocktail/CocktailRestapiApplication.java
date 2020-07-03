package com.cocktail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@SpringBootApplication
@EnableCircuitBreaker
//@EnableEurekaServer
public class CocktailRestapiApplication {
	public static void main(String[] args) {
		SpringApplication.run(CocktailRestapiApplication.class, args);
	}

}
