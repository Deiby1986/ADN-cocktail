package com.cocktail.application.handlers;

import com.cocktail.domain.model.dto.PersonDto;
import com.cocktail.domain.model.dto.mapper.PersonDtoMapper;
import com.cocktail.domain.repository.PersonRepository;

public class QueryPersonByEmailHandle {
	PersonRepository personRepository;

	public QueryPersonByEmailHandle(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}
	
	public PersonDto findByemail(String email){
		return new PersonDtoMapper().converToDto(personRepository.findByEmail(email));
	}
	
	

}
