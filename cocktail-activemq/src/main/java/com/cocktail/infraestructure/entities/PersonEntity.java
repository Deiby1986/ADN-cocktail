package com.cocktail.infraestructure.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


@EntityListeners(AuditingEntityListener.class)
@Entity
@Table(name="Person")
@NamedNativeQuery(name = "PersonEntity.findByEmail", query = "SELECT * FROM person WHERE email = ?", resultClass = PersonEntity.class)
public class PersonEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="fullName")
	private String fullName;
	
	@Column(name="LastName",nullable = false)
	private String lastName;
	
	@Column(name="phone",nullable = false)
	private String phone;
	
	@Column(name="email",nullable = false)
	private String email;
	
	@Column(name="birthDate",nullable = false)
	private LocalDate birthDate;
	
	@CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
	
	@LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
	
	

}
