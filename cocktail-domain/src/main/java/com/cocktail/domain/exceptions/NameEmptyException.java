package com.cocktail.domain.exceptions;

public class NameEmptyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public NameEmptyException() {
		super("El nombre no puede ser vacio");
	}

}
