package com.cocktail.domain.model.dto.mapper;

import java.time.format.DateTimeFormatter;

import com.cocktail.domain.model.Person;
import com.cocktail.domain.model.dto.PersonDto;

public class PersonDtoMapper {
	
	public PersonDto converToDto(Person person) {
		if(person == null)
			return null;
		return new PersonDto(person.getId(), person.getFullName(), person.getLastName(), person.getLastName(), person.getLastName(), person.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}

}
