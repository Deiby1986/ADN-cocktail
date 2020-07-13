package com.cocktail.infraestructure.controllers;

import java.util.List;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocktail.application.handlers.QueryPersonHandle;
import com.cocktail.domain.model.dto.PersonDto;

@RestController
@RequestMapping("/api/person")
@Cacheable("persons")
public class PersonQueryController {
	private QueryPersonHandle personHandle;

	public PersonQueryController(QueryPersonHandle personHandle) {
		this.personHandle = personHandle;
	}
	
	@GetMapping
	public List<PersonDto> listAll(){
		System.out.print("Llamado a listar");
		return personHandle.listall();		
	}

}
