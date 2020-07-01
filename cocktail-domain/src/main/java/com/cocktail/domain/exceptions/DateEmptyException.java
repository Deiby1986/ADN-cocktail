package com.cocktail.domain.exceptions;

public class DateEmptyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DateEmptyException() {
		super("FEcha no puede ser vacia");
	}

}
