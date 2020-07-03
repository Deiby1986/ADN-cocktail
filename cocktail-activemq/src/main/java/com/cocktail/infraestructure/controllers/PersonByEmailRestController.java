package com.cocktail.infraestructure.controllers;

import javax.websocket.server.PathParam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocktail.application.handlers.QueryPersonByEmailHandle;
import com.cocktail.domain.model.dto.PersonDto;

@RestController
@RequestMapping("/apiamq/person/email")
public class PersonByEmailRestController {
	private QueryPersonByEmailHandle queryPersonByEmailHandle;

	public PersonByEmailRestController(QueryPersonByEmailHandle queryPersonByEmailHandle) {
		this.queryPersonByEmailHandle = queryPersonByEmailHandle;
	}
	
	@GetMapping
	public PersonDto findByEmail(@PathParam(value = "email") String email) {
		return queryPersonByEmailHandle.findByemail(email);
	}
	
	

}
