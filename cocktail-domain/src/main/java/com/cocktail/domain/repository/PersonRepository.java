package com.cocktail.domain.repository;

import java.util.List;

import com.cocktail.domain.model.Person;

public interface PersonRepository {
	public Person save(Person person);
	public Person findByEmail(String email);
	public List<Person> list();

}
