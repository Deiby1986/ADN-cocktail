package com.cocktail.infraestructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.cocktail.application.factory.PersonFactory;
import com.cocktail.application.handlers.CreatePersonHandle;
import com.cocktail.domain.repository.PersonRepository;
import com.cocktail.domain.service.CreatePersonService;

@Configuration
public class SpringConfiguration {
	
	@Bean
	public CreatePersonHandle createPersonHandle(CreatePersonService createPersonService) {
		return new CreatePersonHandle(createPersonService,new PersonFactory());
	}
	
	
	@Bean
	public CreatePersonService createPersonService(PersonRepository personRepository) {
		return new CreatePersonService(personRepository);
	}

}
