package com.cocktail.infraestructure.payload.mapper;

import com.cocktail.application.commands.CommandPerson;
import com.cocktail.infraestructure.payload.PersonPayload;

public class PersonPayloadMapper {
	
	public CommandPerson mapToCommandPerson(PersonPayload person) {
		return new CommandPerson(person.getId(), person.getFullName(), person.getLastName(), person.getPhone(), person.getEmail(), person.getBirthDate());
	}

}
