package com.cocktail.application.commands.factory.builder;

import com.cocktail.application.commands.CommandPerson;

public class CommandPersonBuilder {
	private Long id;
	private String fullName;
	private String lastName;
	private String phone;
	private String email;
	private String birthDate;
	
	

	public CommandPersonBuilder() {
		this.id = 1L;
		this.fullName = "Test";
		this.lastName = "Test test";
		this.phone = "3110123456";
		this.email = "test@test.com";
		this.birthDate = "03/03/2020";
	}
	
	



	public CommandPersonBuilder withId(Long id) {
		this.id = id;
		return this;
	}





	public CommandPersonBuilder withFullName(String fullName) {
		this.fullName = fullName;
		return this;
	}





	public CommandPersonBuilder withLastName(String lastName) {
		this.lastName = lastName;
		return this;
	}





	public CommandPersonBuilder withPhone(String phone) {
		this.phone = phone;
		return this;
	}





	public CommandPersonBuilder withEmail(String email) {
		this.email = email;
		return this;
	}





	public CommandPersonBuilder withBirthDate(String birthDate) {
		this.birthDate = birthDate;
		return this;
	}





	public CommandPerson build() {
		return new CommandPerson(id, fullName, lastName, phone, email, birthDate);
	}

}
