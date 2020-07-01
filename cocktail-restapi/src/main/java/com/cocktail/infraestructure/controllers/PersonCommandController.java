package com.cocktail.infraestructure.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocktail.application.commands.CommandPerson;
import com.cocktail.application.handlers.CreatePersonHandle;

@RestController
@RequestMapping("/api/person")
public class PersonCommandController {
	private CreatePersonHandle personHandle;

	public PersonCommandController(CreatePersonHandle personHandle) {
		this.personHandle = personHandle;
	}
	
	
	@PostMapping
	public void save(@RequestBody CommandPerson commandPerson) {
		this.personHandle.save(commandPerson);
	}
	
	
	

}