package com.cocktail.application.factory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.modelmapper.ModelMapper;

import com.cocktail.application.commands.CommandPerson;
import com.cocktail.domain.model.Person;

public class PersonFactory {
	public Person toPerson(CommandPerson commandPerson) {
		LocalDate birthDate = LocalDate.parse(commandPerson.getBirthDate(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return new Person(commandPerson.getId(), commandPerson.getFullName(), commandPerson.getLastName(),
				commandPerson.getPhone(), commandPerson.getEmail(), birthDate);

	}

}
