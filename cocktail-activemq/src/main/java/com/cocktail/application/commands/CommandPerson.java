package com.cocktail.application.commands;

import lombok.Getter;


@Getter
public class CommandPerson {
	private Long id;
	private String fullName;
	private String lastName;
	private String phone;
	private String email;
	private String birthDate;



	public CommandPerson(Long id, String fullName, String lastName, String phone, String email, String birthDate) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.birthDate = birthDate;
	}
	
	

}
