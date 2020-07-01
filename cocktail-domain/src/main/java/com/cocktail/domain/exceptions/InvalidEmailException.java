package com.cocktail.domain.exceptions;

public class InvalidEmailException extends RuntimeException {	
	
	private static final long serialVersionUID = 1L;

	public InvalidEmailException() {
		super("Email invalido");
	}
}
