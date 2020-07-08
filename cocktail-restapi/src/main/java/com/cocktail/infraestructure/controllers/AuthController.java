package com.cocktail.infraestructure.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cocktail.infraestructure.models.AuthRequest;
import com.cocktail.infraestructure.security.jwt.JwtAuthenticationService;

@RestController
@RequestMapping("/api/auth")
public class AuthController {


	JwtAuthenticationService jwtAuthService;
	
	
	public AuthController(JwtAuthenticationService jwtAuthService) {
		this.jwtAuthService = jwtAuthService;
	}


	@PostMapping
	public ResponseEntity<?> autenticate(@RequestBody AuthRequest request) throws Exception {
		return jwtAuthService.createAutenticationToken(request);
	}
}
