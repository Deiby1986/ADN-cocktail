package com.cocktail.infraestructure.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cocktail.CocktailRestapiApplication;
import com.cocktail.application.handlers.QueryPersonHandle;
import com.cocktail.domain.model.dto.PersonDto;
import com.cocktail.domain.model.dto.PersonDtoTestDataBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;

@ExtendWith(SpringExtension.class)   //@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
classes = CocktailRestapiApplication.class)
@AutoConfigureMockMvc
class TestPersonQueryController {
	
	/*@Autowired
	private WebApplicationContext webApplicationContext;*/
	
	@Autowired
	private MockMvc mockMvc;
	
	@Mock
	private QueryPersonHandle queryPersonHandle;
	
	@InjectMocks
	private PersonQueryController personQueryController;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(personQueryController).build();

	}
	
	
	/*@BeforeEach
	public void setup() throws Exception {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}*/

	@Test
	void testPersonQueryController() throws JsonProcessingException, Exception {
		PersonDto personDto = new PersonDtoTestDataBuilder().build();
		List<PersonDto> persons = Arrays.asList(personDto);		
		Mockito.when(queryPersonHandle.listall()).thenReturn(persons);		
		MvcResult result = mockMvc.perform(get("/api/person")).
				andExpect(status().isOk()).				
				andExpect(jsonPath("$[0].fullName").value(personDto.getFullName())).
				andExpect(jsonPath("$[0].lastName").value(personDto.getLastName())).
				andExpect(jsonPath("$[0].phone").value(personDto.getPhone())).
				andExpect(jsonPath("$[0].email").value(personDto.getEmail()))
				.andReturn();
		System.out.print(result.getResponse().getContentAsString());
	}

}
