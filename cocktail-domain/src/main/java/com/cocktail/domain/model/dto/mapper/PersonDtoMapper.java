package com.cocktail.domain.model.dto.mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.cocktail.domain.model.Person;
import com.cocktail.domain.model.dto.PersonDto;

public class PersonDtoMapper {
	
	public PersonDto converToDto(Person person) {
		if(person == null)
			return null;
		return new PersonDto(person.getId(), person.getFullName(), person.getLastName(), person.getPhone(), person.getEmail(), person.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}
	
	public Person converToPerson(PersonDto person) {
		if(person == null)
			return null;
		LocalDate birthDate = LocalDate.parse(person.getBirthDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return new Person(person.getId(), person.getFullName(), person.getLastName(), person.getPhone(), person.getEmail(),birthDate);
	}

}
