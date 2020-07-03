package com.cocktail.infraestructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import com.cocktail.application.factory.PersonFactory;
import com.cocktail.application.handlers.CreatePersonHandle;
import com.cocktail.application.handlers.QueryPersonByEmailHandle;
import com.cocktail.application.handlers.QueryPersonHandle;
import com.cocktail.domain.repository.PersonRepository;
import com.cocktail.domain.service.CreatePersonService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;



@Configuration
public class SpringConfiguration {	
	
	@Bean
	public MessageConverter getJacksonMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
	
	@Bean
	public ObjectMapper getObjectMapper() {
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.registerModule(new JavaTimeModule());
		return objectMapper;
	}
	
	@Bean
	public CreatePersonHandle getCreatePersonHandle(CreatePersonService createPersonService) {
		return new CreatePersonHandle(createPersonService, new PersonFactory());
	}
	
	@Bean
	public CreatePersonService getCreatePersonService(PersonRepository repository) {
		return new CreatePersonService(repository);
	}
	
	@Bean
	public QueryPersonHandle getQueryPersonHandle(PersonRepository personRepository) {
		return new QueryPersonHandle(personRepository);
	}
	
	@Bean
	public QueryPersonByEmailHandle getQueryPersonByEmailHandle(PersonRepository personRepository) {
		return new QueryPersonByEmailHandle(personRepository);
	}


}
