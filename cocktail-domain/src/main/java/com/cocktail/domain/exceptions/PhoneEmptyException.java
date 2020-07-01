package com.cocktail.domain.exceptions;

public class PhoneEmptyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public PhoneEmptyException() {
		super("Telefono no puede ser vacio");
	}

}
