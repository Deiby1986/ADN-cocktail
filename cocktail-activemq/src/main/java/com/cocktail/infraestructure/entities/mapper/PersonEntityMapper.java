package com.cocktail.infraestructure.entities.mapper;

import java.time.format.DateTimeFormatter;

import org.modelmapper.ModelMapper;

import com.cocktail.domain.model.Person;
import com.cocktail.domain.model.dto.PersonDto;
import com.cocktail.infraestructure.entities.PersonEntity;

public class PersonEntityMapper {
	
	
	public PersonEntity toPersonEntity(Person person) {
		if(person == null)
			return null;
		return new ModelMapper().map(person, PersonEntity.class);		
	}
	
	public Person toPerson(PersonEntity person) {
		if(person == null)
			return null;
		return new Person(person.getId(), person.getFullName(), person.getLastName(), person.getPhone(), person.getEmail(), person.getBirthDate());
	}
	
	public PersonDto toPersonDto(PersonEntity person) {
		if(person == null)
			return null;
		return new PersonDto(person.getId(), person.getFullName(), person.getLastName(), person.getPhone(), person.getEmail(), person.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
	}

}
