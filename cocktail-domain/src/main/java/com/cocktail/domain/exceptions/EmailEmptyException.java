package com.cocktail.domain.exceptions;

public class EmailEmptyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public EmailEmptyException() {
		super("El nombre no puede ser vacio");
	}

}
