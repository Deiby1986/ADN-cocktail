package com.cocktail.domain.exceptions;

public class InvalidLastNameException extends RuntimeException {	
	
	private static final long serialVersionUID = 1L;

	public InvalidLastNameException() {
		super("Nombre invalido");
	}
}
