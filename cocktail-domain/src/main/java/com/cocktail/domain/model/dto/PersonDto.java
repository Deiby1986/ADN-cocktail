package com.cocktail.domain.model.dto;

public class PersonDto {
	private Long id;
	private String fullName;
	private String lastName;
	private String phone;
	private String email;
	private String birthDate;
	public PersonDto() {
	}
	public PersonDto(Long id, String fullName, String lastName, String phone, String email, String birthDate) {
		super();
		this.id = id;
		this.fullName = fullName;
		this.lastName = lastName;
		this.phone = phone;
		this.email = email;
		this.birthDate = birthDate;
	}
	public Long getId() {
		return id;
	}
	public String getFullName() {
		return fullName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	public String getBirthDate() {
		return birthDate;
	}
	
	
}
