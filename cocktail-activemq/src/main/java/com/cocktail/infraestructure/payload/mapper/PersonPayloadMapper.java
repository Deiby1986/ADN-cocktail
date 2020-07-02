package com.cocktail.infraestructure.payload.mapper;

import java.time.format.DateTimeFormatter;

import org.modelmapper.ModelMapper;

import com.cocktail.application.commands.CommandPerson;
import com.cocktail.domain.model.Person;
import com.cocktail.infraestructure.payload.PersonPayload;

public class PersonPayloadMapper {
	
	public CommandPerson mapToCommandPerson(PersonPayload person) {
		return new ModelMapper().map(person, CommandPerson.class);
	}

}
