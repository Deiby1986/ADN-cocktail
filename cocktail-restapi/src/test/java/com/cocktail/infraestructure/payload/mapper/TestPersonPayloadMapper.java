package com.cocktail.infraestructure.payload.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;

import com.cocktail.domain.model.Person;
import com.cocktail.domain.model.PersonTestDataBuilder;
import com.cocktail.infraestructure.payload.PersonPayload;

class TestPersonPayloadMapper {

	@Test
	void testMapToPersonPayload() {
		PersonPayloadMapper personPayloadMapper = new PersonPayloadMapper();
		Person person = new PersonTestDataBuilder().build();  
		PersonPayload personPayload = personPayloadMapper.mapToPersonPayload(person);
		
		assertThat(personPayload.getId()).isEqualTo(person.getId());
		assertThat(personPayload.getBirthDate()).isEqualTo(person.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		assertThat(personPayload.getEmail()).isEqualTo(person.getEmail());
		assertThat(personPayload.getFullName()).isEqualTo(person.getFullName());
		assertThat(personPayload.getLastName()).isEqualTo(person.getLastName());
		assertThat(personPayload.getPhone()).isEqualTo(person.getPhone());
		
		
	}

}
