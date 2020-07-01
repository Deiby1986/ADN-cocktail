package com.cocktail.domain.exceptions;

public class InvalidNameException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;

	public InvalidNameException() {
		super("Nombre invalido");
	}
}
