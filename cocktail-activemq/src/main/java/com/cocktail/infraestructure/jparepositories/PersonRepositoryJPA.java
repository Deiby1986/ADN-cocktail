package com.cocktail.infraestructure.jparepositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cocktail.infraestructure.entities.PersonEntity;

@Repository
public interface PersonRepositoryJPA extends JpaRepository<PersonEntity, Long>  {
	public PersonEntity findByEmail(String email);

}
