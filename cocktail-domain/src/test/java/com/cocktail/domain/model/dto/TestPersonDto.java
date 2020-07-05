package com.cocktail.domain.model.dto;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class TestPersonDto {
	
	private PersonDtoTestDataBuilder personDtoTestDataBuilder;
	@BeforeEach
	void setUp() throws Exception {
		this.personDtoTestDataBuilder = new PersonDtoTestDataBuilder();
	}
	
	@Test
	public void testPersonDtoIsOk() {
		Long id = 1L;
		String fullName = "Test";
		String lastName = "Last test";
		String phone = "313133131313";
		String email = "test@test.com";
		String birthDate = "01/01/2020";
		
		PersonDto personDto = personDtoTestDataBuilder.
								withBirthDate(birthDate).
								withEmail(email).
								withFullName(fullName).
								withId(id).
								withLastName(lastName).
								withPhone(phone).build();
		assertThat(id).isEqualTo(personDto.getId());
		assertThat(personDto.getBirthDate()).isEqualTo(birthDate);
		assertThat(personDto.getEmail()).isEqualTo(email);
		assertThat(personDto.getFullName()).isEqualTo(fullName);
		assertThat(personDto.getLastName()).isEqualTo(lastName);
		assertThat(personDto.getPhone()).isEqualTo(phone);
	}

}
