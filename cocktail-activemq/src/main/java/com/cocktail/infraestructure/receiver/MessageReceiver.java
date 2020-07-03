package com.cocktail.infraestructure.receiver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.cocktail.application.commands.CommandPerson;
import com.cocktail.application.handlers.CreatePersonHandle;
import com.cocktail.infraestructure.payload.PersonPayload;
import com.cocktail.infraestructure.payload.mapper.PersonPayloadMapper;

@Component
public class MessageReceiver {
	
	@Autowired
	CreatePersonHandle createPersonHandle;	
	

	@JmsListener(destination = "cocktail-test")
	public void receiveQueue(PersonPayload person) {
		CommandPerson commandPerson =  new PersonPayloadMapper().mapToCommandPerson(person);
		createPersonHandle.save(commandPerson);
		
	}

}
