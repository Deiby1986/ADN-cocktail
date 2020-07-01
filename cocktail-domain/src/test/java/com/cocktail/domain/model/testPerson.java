package com.cocktail.domain.model;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cocktail.domain.exceptions.DateEmptyException;
import com.cocktail.domain.exceptions.EmailEmptyException;
import com.cocktail.domain.exceptions.InvalidBirthDateException;
import com.cocktail.domain.exceptions.InvalidEmailException;
import com.cocktail.domain.exceptions.InvalidLastNameException;
import com.cocktail.domain.exceptions.InvalidNameException;
import com.cocktail.domain.exceptions.InvalidPhoneException;
import com.cocktail.domain.exceptions.LastNameEmptyException;
import com.cocktail.domain.exceptions.NameEmptyException;
import com.cocktail.domain.exceptions.PhoneEmptyException;

class testPerson {

	private PersonTestDataBuilder personDataBuilder;
	@BeforeEach
	void setUp() throws Exception {
		this.personDataBuilder = new PersonTestDataBuilder();
	}

	@Test
	void testPersonWithNameEmptyMustThrowNameEmptyException() {
		assertThrows(NameEmptyException.class,()-> personDataBuilder.withFullName(null).build());
	}
	
	@Test
	void testPersonWithNameTooShortMustThrowInvalidNameException() {
		assertThrows(InvalidNameException.class,()-> personDataBuilder.withFullName("a").build());
	}
	
	@Test
	void testPersonWithNameStoreCorrectly() {
		String name = "Person";
		Person person = personDataBuilder.withFullName(name).build();
		assertEquals(name, person.getFullName());
	}
	
	
	@Test
	void testPersonWithLastNameEmptyMustThrowLastNameEmptyException() {
		assertThrows(LastNameEmptyException.class,()-> personDataBuilder.withLastName(null).build());
	}
	
	@Test
	void testPersonWithLastNameTooShortMustThrowInvalidNameException() {
		assertThrows(InvalidLastNameException.class,()-> personDataBuilder.withLastName("a").build());
	}
	
	@Test
	void testPersonWithLastNameStoreCorrectly() {
		String name = "Person";
		Person person = personDataBuilder.withLastName(name).build();
		assertEquals(name, person.getLastName());
	}
	
	
	@Test
	void testPersonWithPhoneeEmptyMustThrowPhoneEmptyException() {
		assertThrows(PhoneEmptyException.class,()-> personDataBuilder.withPhone(null).build());
	}
	
	@Test
	void testPersonWithInvalidPhoneMustThrowInvalidPhoneException() {
		assertThrows(InvalidPhoneException.class,()-> personDataBuilder.withPhone("abcdea123").build());
	}
	
	@Test
	void testPersonWithPhoneStoreCorrectly() {
		String phoneNumber = "3134567892";
		Person person = personDataBuilder.withPhone(phoneNumber).build();
		assertEquals(phoneNumber, person.getPhone());
	}
	
	@Test
	void testPersonWithEmailEmptyMustThrowPhoneEmptyException() {
		assertThrows(EmailEmptyException.class,()-> personDataBuilder.withEmail(null).build());
	}
	
	@Test
	void testPersonWithInvalidEmailMustThrowInvalidInvalidEmailExceptionException() {
		assertThrows(InvalidEmailException.class,()-> personDataBuilder.withEmail("abcdea123").build());
	}
	
	@Test
	void testPersonWithEmailStoreCorrectly() {
		String email = "test@test.com";
		Person person = personDataBuilder.withEmail(email).build();
		assertEquals(email, person.getEmail());
	}
	
	@Test
	void testPersonWithBirthDateEmptyMustThrowDateEmptyException() {
		assertThrows(DateEmptyException.class,()-> personDataBuilder.withBirthDate(null).build());
	}
	
	@Test
	void testPersonWithInvalidBirthDateMustThrowInvalidBirthDateException() {
		assertThrows(InvalidBirthDateException.class,()-> personDataBuilder.withBirthDate(LocalDate.now()).build());
	}
	
	@Test
	void testPersonWithDateStoreCorrectly() {
		LocalDate testDate = LocalDate.of(2020, 01, 01);
		Person person = personDataBuilder.withBirthDate(testDate).build();
		assertTrue(testDate.compareTo(person.getBirthDate())==0 );
	}

}
