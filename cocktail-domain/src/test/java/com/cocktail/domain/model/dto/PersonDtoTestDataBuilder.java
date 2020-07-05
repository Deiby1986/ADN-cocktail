package com.cocktail.domain.model.dto;

public class PersonDtoTestDataBuilder {
	private Long id;
	private String fullName;
	private String lastName;
	private String phone;
	private String email;
	private String birthDate;
	public PersonDtoTestDataBuilder() {		
		this.id = 1L;
		this.fullName = "Test";
		this.lastName = "Last test";
		this.phone = "313133131313";
		this.email = "test@test.com";
		this.birthDate = "01/01/2020";
	}
	public PersonDtoTestDataBuilder withId(Long id) {
		this.id = id;
		return this;
	}
	public PersonDtoTestDataBuilder withFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}
	public PersonDtoTestDataBuilder withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}
	public PersonDtoTestDataBuilder withPhone(String phone) {
		this.phone = phone;
		return this;
	}
	public PersonDtoTestDataBuilder withEmail(String email) {
		this.email = email;
		return this;
	}
	public PersonDtoTestDataBuilder withBirthDate(String birthDate) {
		this.birthDate = birthDate;
		return this;
	}
	
	public PersonDto build() {
		return new PersonDto(id, fullName, lastName, phone, email, birthDate);
	}
	
	
	
	

}
