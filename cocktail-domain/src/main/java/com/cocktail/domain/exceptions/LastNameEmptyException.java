package com.cocktail.domain.exceptions;

public class LastNameEmptyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public LastNameEmptyException() {
		super("El nombre no puede ser vacio");
	}

}
