package com.cocktail.application.commands.factory;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import com.cocktail.application.commands.CommandPerson;
import com.cocktail.application.commands.factory.builder.CommandPersonBuilder;
import com.cocktail.domain.model.Person;

class TestPersonFactory {

	@Test
	void test() {
		PersonFactory personFactory = new PersonFactory();
		CommandPerson commandPerson = new CommandPersonBuilder().build();
		Person person = personFactory.toPerson(commandPerson);
		
		assertThat(commandPerson.getId()).isEqualTo(person.getId());
		assertThat(commandPerson.getBirthDate()).isEqualTo(person.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		assertThat(commandPerson.getEmail()).isEqualTo(person.getEmail());
		assertThat(commandPerson.getFullName()).isEqualTo(person.getFullName());
		assertThat(commandPerson.getLastName()).isEqualTo(person.getLastName());
		assertThat(commandPerson.getPhone()).isEqualTo(person.getPhone());
		
	}

}
