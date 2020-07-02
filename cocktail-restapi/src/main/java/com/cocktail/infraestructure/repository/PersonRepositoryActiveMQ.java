package com.cocktail.infraestructure.repository;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cocktail.domain.model.Person;
import com.cocktail.domain.repository.PersonRepository;
import com.cocktail.infraestructure.payload.mapper.PersonPayloadMapper;

@Component
public class PersonRepositoryActiveMQ implements PersonRepository {
	
	private ActiveMQSender activeMQSender;
	
	

	public PersonRepositoryActiveMQ(ActiveMQSender activeMQSender) {
		this.activeMQSender = activeMQSender;
	}

	@Override
	public void save(Person person) {
		PersonPayloadMapper mapper = new PersonPayloadMapper();
		activeMQSender.sendMessage(mapper.mapToPersonPayload(person));		
	}

	@Override
	public Person findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Person> list() {
		// TODO Auto-generated method stub
		return null;
	}

}
