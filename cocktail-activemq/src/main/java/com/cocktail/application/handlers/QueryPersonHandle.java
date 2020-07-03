package com.cocktail.application.handlers;

import java.util.List;

import com.cocktail.domain.model.dto.PersonDto;
import com.cocktail.domain.repository.PersonRepository;

public class QueryPersonHandle {
	PersonRepository personRepository;

	public QueryPersonHandle(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public List<PersonDto> listAll(){
		return personRepository.list();
	}
	
	

}
