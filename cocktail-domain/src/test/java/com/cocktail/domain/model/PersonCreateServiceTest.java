package com.cocktail.domain.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.cocktail.domain.exceptions.EmailAlreadyRegistredException;
import com.cocktail.domain.repository.PersonRepository;
import com.cocktail.domain.service.CreatePersonService;

class PersonCreateServiceTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testSavePersonService() {
		Person person = new PersonTestDataBuilder().build();
		PersonRepository personRepository =  Mockito.mock(PersonRepository.class);
		Mockito.when(personRepository.findByEmail(person.getEmail())).thenReturn(person);
		CreatePersonService personCreateService = new CreatePersonService(personRepository);
		assertTrue(personCreateService.save(person));
		Mockito.verify(personRepository,times(1)).save(person);
	}
	
	
	@Test
	void testSavePersonServiceMustThrowEmailAlreadyRegistredExceptionWhenEmailAssignedToAnotherUser() {
		Person person = new PersonTestDataBuilder().build();
		PersonRepository personRepository =  Mockito.mock(PersonRepository.class);
		Mockito.when(personRepository.findByEmail(person.getEmail())).thenReturn(new PersonTestDataBuilder().withId(100L).build());
		CreatePersonService personCreateService = new CreatePersonService(personRepository);
		assertThrows(EmailAlreadyRegistredException.class,()->personCreateService.save(person));
		Mockito.verify(personRepository,times(1)).findByEmail(person.getEmail());
	}
	
	@Test
	void testSavePersonServiceMustSaveWhenNoEmailFound() {
		Person person = new PersonTestDataBuilder().build();
		PersonRepository personRepository =  Mockito.mock(PersonRepository.class);
		Mockito.when(personRepository.findByEmail(person.getEmail())).thenReturn(null);
		CreatePersonService personCreateService = new CreatePersonService(personRepository);
		assertTrue(personCreateService.save(person));
		Mockito.verify(personRepository,times(1)).save(person);
	}
	
	@Test
	void testSavePersonServiceMustSaveWhenSamePersonFound() {
		Person person = new PersonTestDataBuilder().build();
		PersonRepository personRepository =  Mockito.mock(PersonRepository.class);
		Mockito.when(personRepository.findByEmail(person.getEmail())).thenReturn(person);
		CreatePersonService personCreateService = new CreatePersonService(personRepository);
		assertTrue(personCreateService.save(person));
		Mockito.verify(personRepository,times(1)).save(person);
	}

}
