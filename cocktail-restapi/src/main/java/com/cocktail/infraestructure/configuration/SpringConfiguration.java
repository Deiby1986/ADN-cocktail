package com.cocktail.infraestructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;
import org.springframework.web.client.RestTemplate;

import com.cocktail.application.commands.factory.PersonFactory;
import com.cocktail.application.handlers.CreatePersonHandle;
import com.cocktail.application.handlers.QueryPersonHandle;
import com.cocktail.domain.repository.PersonRepository;
import com.cocktail.domain.service.CreatePersonService;

@Configuration
public class SpringConfiguration {
	
	@Bean
	public CreatePersonHandle createPersonHandle(CreatePersonService createPersonService) {
		return new CreatePersonHandle(createPersonService,new PersonFactory());
	}
	@Bean
	public QueryPersonHandle createQueryPersonHandle(PersonRepository personRepository) {
		return new QueryPersonHandle(personRepository);
	}
	
	
	@Bean
	public CreatePersonService createPersonService(PersonRepository personRepository) {
		return new CreatePersonService(personRepository);
	}
	
	@Bean
	public MessageConverter getJacksonMessageConverter() {
		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
		converter.setTargetType(MessageType.TEXT);
		converter.setTypeIdPropertyName("_type");
		return converter;
	}
	
	@Bean 
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
