package com.cocktail.application.handlers;

import java.util.List;

import com.cocktail.domain.model.dto.PersonDto;
import com.cocktail.domain.repository.PersonRepository;

public class QueryPersonHandle {
	private PersonRepository personRepositoryActiveMQ;

	public QueryPersonHandle(PersonRepository personRepositoryActiveMQ) {
		this.personRepositoryActiveMQ = personRepositoryActiveMQ;
	}
	
	public List<PersonDto> listall(){
		return personRepositoryActiveMQ.list();		 
	}
	
	
	
	

}
