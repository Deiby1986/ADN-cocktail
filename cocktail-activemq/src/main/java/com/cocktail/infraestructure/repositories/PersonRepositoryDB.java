package com.cocktail.infraestructure.repositories;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.cocktail.domain.model.Person;
import com.cocktail.domain.model.dto.PersonDto;
import com.cocktail.domain.repository.PersonRepository;
import com.cocktail.infraestructure.entities.PersonEntity;
import com.cocktail.infraestructure.entities.mapper.PersonEntityMapper;
import com.cocktail.infraestructure.jparepositories.PersonRepositoryJPA;

@Component
public class PersonRepositoryDB implements PersonRepository{
	
	PersonRepositoryJPA personRepositoryJPA;
	
	
	public PersonRepositoryDB(PersonRepositoryJPA personRepositoryJPA) {
		this.personRepositoryJPA = personRepositoryJPA;
	}

	@Override
	public void save(Person person) {
		PersonEntityMapper mapper = new PersonEntityMapper();
		this.personRepositoryJPA.save(mapper.toPersonEntity(person));
		
	}

	@Override
	public Person findByEmail(String email) {
		PersonEntity person = this.personRepositoryJPA.findByEmail(email);
		return new PersonEntityMapper().toPerson(person);
	}

	@Override
	public List<PersonDto> list() {		
		return this.personRepositoryJPA.findAll().stream().map(personEntity -> 
							new PersonEntityMapper().toPersonDto(personEntity)
							).collect(Collectors.toList());
	}

}
