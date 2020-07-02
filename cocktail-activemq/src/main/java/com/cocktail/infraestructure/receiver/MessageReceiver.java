package com.cocktail.infraestructure.receiver;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.cocktail.application.commands.CommandPerson;
import com.cocktail.application.factory.PersonFactory;
import com.cocktail.domain.model.Person;
import com.cocktail.infraestructure.payload.PersonPayload;
import com.cocktail.infraestructure.payload.mapper.PersonPayloadMapper;

@Component
public class MessageReceiver {
	
	@JmsListener(destination = "cocktail-test")
	public void receiveQueue(PersonPayload person) {
		PersonPayloadMapper personPayloadMapper = new PersonPayloadMapper();
		CommandPerson commandPerson =  personPayloadMapper.mapToCommandPerson(person);
		System.out.println(person);
		System.out.println(commandPerson);
	}

}
