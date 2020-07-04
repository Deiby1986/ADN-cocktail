package com.cocktail.infraestructure.repository;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.cocktail.infraestructure.payload.PersonPayload;

@Component
public class ActiveMQSender {
	
	private JmsTemplate template;
	private static final String QUEUE_NAME = "cocktail-test";
	
	public ActiveMQSender(JmsTemplate template) {
		this.template = template;
	}




	public void sendMessage(PersonPayload person) {
		template.convertAndSend(QUEUE_NAME, person);
	}
	
	

}
