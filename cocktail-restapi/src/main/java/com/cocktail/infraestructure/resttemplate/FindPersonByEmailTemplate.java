package com.cocktail.infraestructure.resttemplate;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.cocktail.domain.model.dto.PersonDto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class FindPersonByEmailTemplate {
	RestTemplate restTemplate;
	private static String URL = "http://localhost:8181/apiamq/person/email";
	
	public FindPersonByEmailTemplate(RestTemplate restTemplate) {
		this.restTemplate = restTemplate;
	}
	
	@HystrixCommand(fallbackMethod = "callableMethod")
	public PersonDto findPersonByEmail(String email) {
		HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    HttpEntity <String> entity = new HttpEntity<String>(headers);
	    return restTemplate.exchange(URL+"?email="+email, HttpMethod.GET, entity, PersonDto.class).getBody();
	}
	
	public PersonDto callableMethod(String email){
		return null;
		
	}

}
