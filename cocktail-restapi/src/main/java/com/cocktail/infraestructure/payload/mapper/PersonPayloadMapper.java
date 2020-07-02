package com.cocktail.infraestructure.payload.mapper;

import java.time.format.DateTimeFormatter;

import com.cocktail.domain.model.Person;
import com.cocktail.infraestructure.payload.PersonPayload;

public class PersonPayloadMapper {
	
	public PersonPayload mapToPersonPayload(Person person) {
		return new PersonPayload(person.getId(), person.getFullName(), person.getLastName(), person.getPhone(), person.getEmail(), person.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}

}
