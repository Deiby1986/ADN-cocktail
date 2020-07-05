package com.cocktail.domain.model.dto;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cocktail.domain.model.Person;
import com.cocktail.domain.model.PersonTestDataBuilder;
import com.cocktail.domain.model.dto.mapper.PersonDtoMapper;

public class TestPersonDtoMapper {
	
	
	private PersonDtoTestDataBuilder personDtoTestDataBuilder;
	private PersonTestDataBuilder PersonTestDataBuilder;
	@BeforeEach
	void setUp() throws Exception {
		this.personDtoTestDataBuilder = new PersonDtoTestDataBuilder();
		this.PersonTestDataBuilder = new PersonTestDataBuilder();
	}
	
	@Test
	public void testPersonToDtoMapper() {
		Person person = PersonTestDataBuilder.build();
		PersonDtoMapper mapper = new PersonDtoMapper();
		PersonDto personDto = mapper.converToDto(person);
		assertThat(personDto.getId()).isEqualTo(person.getId());
		assertThat(personDto.getBirthDate()).isEqualTo(person.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		assertThat(personDto.getEmail()).isEqualTo(person.getEmail());
		assertThat(personDto.getFullName()).isEqualTo(person.getFullName());
		assertThat(personDto.getLastName()).isEqualTo(person.getLastName());
		assertThat(personDto.getPhone()).isEqualTo(person.getPhone());
	}
	
	@Test
	public void testPersonToDtoMapperMustReturnNullWhenInputIsNull() {
		Person person = null;
		PersonDtoMapper mapper = new PersonDtoMapper();
		PersonDto personDto = mapper.converToDto(person);
		assertThat(personDto).isNull();
		
	}
	
	
	@Test
	public void testPersonDtoToDomainEntityMapper() {
		PersonDto personDto = personDtoTestDataBuilder.build();
		PersonDtoMapper mapper = new PersonDtoMapper();
		Person person = mapper.converToPerson(personDto);
		assertThat(personDto.getId()).isEqualTo(person.getId());
		assertThat(personDto.getBirthDate()).isEqualTo(person.getBirthDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		assertThat(personDto.getEmail()).isEqualTo(person.getEmail());
		assertThat(personDto.getFullName()).isEqualTo(person.getFullName());
		assertThat(personDto.getLastName()).isEqualTo(person.getLastName());
		assertThat(personDto.getPhone()).isEqualTo(person.getPhone());
	}
	
	@Test
	public void testPersonDtoToDomainEntityMapperMustReturnNullWhenInputIsNull() {
		PersonDto personDto = null;
		PersonDtoMapper mapper = new PersonDtoMapper();
		Person person = mapper.converToPerson(personDto);
		assertThat(person).isNull();
		
	}

}
