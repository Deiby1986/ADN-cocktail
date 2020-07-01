package com.cocktail.domain.service;

import com.cocktail.domain.exceptions.EmailAlreadyRegistredException;
import com.cocktail.domain.model.Person;
import com.cocktail.domain.repository.PersonRepository;

public class CreatePersonService {
	
	private PersonRepository repository;

	public CreatePersonService(PersonRepository repository) {
		this.repository = repository;
	}
	
	
	public boolean save(Person person) {
		this.validPerson(person);
		this.repository.save(person);
		return true;
	}
	
	private void validPerson(Person person) {
		Person emailPerson = this.repository.findByEmail(person.getEmail());
		if(emailPerson == null)
			return;
		if(emailPerson.getId().longValue() != person.getId().longValue()) {
			throw new EmailAlreadyRegistredException();
		}
	}
}
