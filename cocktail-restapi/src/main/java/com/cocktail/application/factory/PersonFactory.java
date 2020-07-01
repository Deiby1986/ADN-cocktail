package com.cocktail.application.factory;

import org.modelmapper.ModelMapper;

import com.cocktail.application.commands.CommandPerson;
import com.cocktail.domain.model.Person;

public class PersonFactory {
	public Person toPerson(CommandPerson commandPerson) {
		return new ModelMapper().map(commandPerson, Person.class);
	}

}
