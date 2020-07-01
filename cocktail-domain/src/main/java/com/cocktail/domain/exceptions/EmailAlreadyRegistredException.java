package com.cocktail.domain.exceptions;

public class EmailAlreadyRegistredException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EmailAlreadyRegistredException() {
		super("El email ya se encuentra registrado para otro usuario");
	}
}
