package com.cocktail.infraestructure.payload;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor

public class PersonPayload {
	private Long id;
	private String fullName;
	private String lastName;
	private String phone;
	private String email;
	private String birthDate;
	
	public String toString() {
		return "{id:"+id+",fullName:"+fullName+",lastName:"+lastName+",phone:"+phone+",email:"+email+",birthDate:"+birthDate+"}";
	}

}
