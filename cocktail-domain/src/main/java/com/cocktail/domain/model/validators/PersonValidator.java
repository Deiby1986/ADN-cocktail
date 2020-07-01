package com.cocktail.domain.model.validators;

import java.time.LocalDate;

import com.cocktail.domain.exceptions.DateEmptyException;
import com.cocktail.domain.exceptions.EmailEmptyException;
import com.cocktail.domain.exceptions.InvalidBirthDateException;
import com.cocktail.domain.exceptions.InvalidEmailException;
import com.cocktail.domain.exceptions.InvalidLastNameException;
import com.cocktail.domain.exceptions.InvalidNameException;
import com.cocktail.domain.exceptions.InvalidPhoneException;
import com.cocktail.domain.exceptions.LastNameEmptyException;
import com.cocktail.domain.exceptions.NameEmptyException;
import com.cocktail.domain.exceptions.PhoneEmptyException;

public class PersonValidator {

	private PersonValidator() {

	}
	
	
	public static boolean validateName(String name) {
		if(name == null || name.trim().isEmpty()) {
			throw new NameEmptyException();
		}
		
		if(name.length() < 2) {
			throw new InvalidNameException();
		}
		return true;
	}
	
	public static boolean validateLastName(String lastname) {
		if(lastname == null || lastname.trim().isEmpty()) {
			throw new LastNameEmptyException();
		}
		
		if(lastname.length() < 2) {
			throw new InvalidLastNameException();
		}
		return true;
	}
	
	
	public static boolean validatePhone(String phone) {
		if(phone == null || phone.trim().isEmpty()) {
			throw new PhoneEmptyException();
		}
		
		if(!phone.matches("^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$")) {
			throw new InvalidPhoneException();
		}
		return true;
	}
	
	public static boolean validateEmail(String email) {
		if(email == null || email.trim().isEmpty()) {
			throw new EmailEmptyException();
		}
		
		if(!email.matches("(^[a-zA-Z0-9_.+-]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$)")) {
			throw new InvalidEmailException();
		}
		return true;
	}


	public static boolean validateBirthDate(LocalDate birthDate) {
		if(birthDate == null) {
			throw new DateEmptyException();
		}
		
		if(birthDate.isAfter(LocalDate.now().minusDays(1L))) {
			throw new InvalidBirthDateException();
		}
		return true;
	}
	
	

}
