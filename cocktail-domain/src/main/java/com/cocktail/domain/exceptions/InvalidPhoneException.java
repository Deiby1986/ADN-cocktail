package com.cocktail.domain.exceptions;

public class InvalidPhoneException extends RuntimeException {	
	
	private static final long serialVersionUID = 1L;

	public InvalidPhoneException() {
		super("Telefono invalido");
	}
}
