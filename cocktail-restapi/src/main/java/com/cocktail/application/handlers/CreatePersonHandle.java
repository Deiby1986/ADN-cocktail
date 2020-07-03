package com.cocktail.application.handlers;

import com.cocktail.application.commands.CommandPerson;
import com.cocktail.application.commands.factory.PersonFactory;
import com.cocktail.domain.model.Person;
import com.cocktail.domain.service.CreatePersonService;

public class CreatePersonHandle {
	
	CreatePersonService createPersonService;
	PersonFactory personFactory;
	public CreatePersonHandle(CreatePersonService createPersonService, PersonFactory personFactory) {
		this.createPersonService = createPersonService;
		this.personFactory = personFactory;
	}
	
	
	public void save(CommandPerson commandPerson) {
		Person person = this.personFactory.toPerson(commandPerson);
		this.createPersonService.save(person);
		
	}
	
	

}
