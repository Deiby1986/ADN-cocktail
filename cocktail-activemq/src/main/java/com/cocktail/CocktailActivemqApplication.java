package com.cocktail;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

@SpringBootApplication
@EnableJms
public class CocktailActivemqApplication {
	
	
	
	public static void main(String[] args) {
		SpringApplication.run(CocktailActivemqApplication.class, args);
	}	
	

}
