package com.cocktail.infraestructure.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocktail.application.handlers.QueryPersonHandle;
import com.cocktail.domain.model.dto.PersonDto;

@RestController
@RequestMapping("/apiamq/person")
public class PersonRestController {
	
	private  QueryPersonHandle queryPersonHandle;

	public PersonRestController(QueryPersonHandle queryPersonHandle) {
		this.queryPersonHandle = queryPersonHandle;
	}
	
	@GetMapping
	public List<PersonDto> list(){
		return queryPersonHandle.listAll();
	}
	
	

}
