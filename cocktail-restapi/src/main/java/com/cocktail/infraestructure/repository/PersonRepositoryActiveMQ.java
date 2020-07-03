package com.cocktail.infraestructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cocktail.domain.model.Person;
import com.cocktail.domain.model.dto.PersonDto;
import com.cocktail.domain.repository.PersonRepository;
import com.cocktail.infraestructure.payload.mapper.PersonPayloadMapper;
import com.cocktail.infraestructure.resttemplate.ListPersonTemplate;

@Component
public class PersonRepositoryActiveMQ implements PersonRepository {
	
	private ActiveMQSender activeMQSender;
	private ListPersonTemplate listPersonTemplate;	

	public PersonRepositoryActiveMQ(ActiveMQSender activeMQSender, ListPersonTemplate listPersonTemplate) {
		super();
		this.activeMQSender = activeMQSender;
		this.listPersonTemplate = listPersonTemplate;
	}

	@Override
	public void save(Person person) {
		PersonPayloadMapper mapper = new PersonPayloadMapper();
		activeMQSender.sendMessage(mapper.mapToPersonPayload(person));		
	}

	@Override
	public Person findByEmail(String email) {       
		return null;
	}

	@Override
	public List<PersonDto> list() {			 
		return listPersonTemplate.listAllPerson();
	}

}
