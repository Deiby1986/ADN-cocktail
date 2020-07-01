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
	
	public CommandPerson() {		
	}
	
	

}
