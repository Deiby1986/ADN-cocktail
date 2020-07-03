package com.cocktail.domain.repository;

import java.util.List;

import com.cocktail.domain.model.Person;
import com.cocktail.domain.model.dto.PersonDto;

public interface PersonRepository {
	public void save(Person person);
	public Person findByEmail(String email);
	public List<PersonDto> list();

}
