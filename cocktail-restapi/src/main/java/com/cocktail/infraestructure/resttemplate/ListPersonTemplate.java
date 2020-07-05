package com.cocktail.infraestructure.resttemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cocktail.domain.model.dto.PersonDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class ListPersonTemplate {
	RestTemplate restTemplate;
	private static String URL = "http://localhost:8181/apiamq/person";
	
	public ListPersonTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@HystrixCommand(fallbackMethod = "callableMethod")	
	public List<PersonDto> listAllPerson(){
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    ResponseEntity<PersonDto[]> response = restTemplate.exchange(URL, HttpMethod.GET, entity, PersonDto[].class);
	    return Arrays.asList(response.getBody());
	}
	
	public List<PersonDto> callableMethod(){
		return new ArrayList<>();
		
	}

}
