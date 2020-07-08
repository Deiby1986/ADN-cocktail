package com.cocktail.infraestructure.security;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cocktail.domain.model.Person;
import com.cocktail.infraestructure.repository.PersonRepositoryActiveMQ;

@Service
public class UserService implements UserDetailsService {
	
	@Autowired
	PersonRepositoryActiveMQ personRepositoryActiveMQ;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Person person = personRepositoryActiveMQ.findByEmail(username);
		if(person == null) {
			throw new UsernameNotFoundException("User "+username+" not found");
		}
		GrantedAuthority authority = new SimpleGrantedAuthority("USER");
		return new User(person.getEmail(), person.getEmail(), Arrays.asList(authority));
	}

}
