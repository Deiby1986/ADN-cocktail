package com.cocktail.domain.model;

import java.time.LocalDate;

import com.cocktail.domain.model.validators.PersonValidator;

public class Person {
	private Long id;
	private String fullName;
	private String lastName;
	private String phone;
	private String email;
	private LocalDate birthDate;
	
	public Person() {		
	}
	
	public Person(Long id, String fullName, String lastName, String phone, String email, LocalDate birthDate) {
		this.id = id;
		this.fullName = fullName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.birthDate = birthDate;
		PersonValidator.validateName(fullName);
		PersonValidator.validateLastName(lastName);
		PersonValidator.validatePhone(phone);
		PersonValidator.validateEmail(email);
		PersonValidator.validateBirthDate(birthDate);
		
	}

	public Long getId() {
		return id;
	}

	public String getFullName() {
		return fullName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getPhone() {
		return phone;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	

}
