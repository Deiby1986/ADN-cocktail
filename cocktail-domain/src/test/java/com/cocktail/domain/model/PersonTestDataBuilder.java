package com.cocktail.domain.model;

import java.time.LocalDate;

public class PersonTestDataBuilder {
	Long id;
	String fullName;
	String lastName;
	String phone;
	String email;
	LocalDate birthDate;
	
	public PersonTestDataBuilder() {
		this.id = 1L;
		this.fullName = "Demo name";
		this.lastName = "Demo last";
		this.phone = "3133458972";
		this.email = "test@test.com";
		this.birthDate = LocalDate.now().minusYears(1L);
	}

	public PersonTestDataBuilder withId(Long id) {
		this.id = id;
		return this;
	}

	public PersonTestDataBuilder withFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}

	public PersonTestDataBuilder withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}

	public PersonTestDataBuilder withPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public PersonTestDataBuilder withEmail(String email) {
		this.email = email;
		return this;
	}

	public PersonTestDataBuilder withBirthDate(LocalDate birthDate) {
		this.birthDate = birthDate;
		return this;
	}
	
	public Person build() {
		return new Person(id, fullName, lastName, phone, email, birthDate);
	}
	
	
	
	
	

}
