package com.cocktail.domain.exceptions;

public class InvalidBirthDateException extends RuntimeException {	
	
	private static final long serialVersionUID = 1L;

	public InvalidBirthDateException() {
		super("FEcha de nacimiento no valida");
	}
}
