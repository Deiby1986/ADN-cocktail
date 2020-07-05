package com.cocktail.infraestructure.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public class PersonPayload {
	private Long id;
	private String fullName;
	private String lastName;
	private String phone;
	private String email;
	private String birthDate;

}
