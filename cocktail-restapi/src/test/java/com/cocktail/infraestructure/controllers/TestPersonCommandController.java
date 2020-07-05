package com.cocktail.infraestructure.controllers;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cocktail.CocktailRestapiApplication;
import com.cocktail.application.commands.CommandPerson;
import com.cocktail.application.commands.factory.builder.CommandPersonBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@ExtendWith(SpringExtension.class)   //@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
classes = CocktailRestapiApplication.class)
@AutoConfigureMockMvc
public class TestPersonCommandController {
	
	@Autowired
	private WebApplicationContext webApplicationContext;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objetcMapper;
	
	@BeforeEach
	public void setup() throws Exception {
	    this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
	}
	
	@Test
	public void testPersonCommandController() throws JsonProcessingException, Exception {
		CommandPerson commandPerson= new CommandPersonBuilder().build();
		mockMvc.perform(post("/api/person").
				contentType(MediaType.APPLICATION_JSON).
				content(objetcMapper.writeValueAsString(commandPerson))).
				andExpect(status().isOk());
	}

}
