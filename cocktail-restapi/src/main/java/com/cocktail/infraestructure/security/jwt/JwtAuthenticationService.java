package com.cocktail.infraestructure.security.jwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.cocktail.infraestructure.models.AuthRequest;
import com.cocktail.infraestructure.models.AuthResponse;

@Service
public class JwtAuthenticationService {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	public ResponseEntity<AuthResponse> createAutenticationToken(AuthRequest authenticationRequest) throws Exception{
		 authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
		    final UserDetails userDetails =
		        userDetailsService.loadUserByUsername(authenticationRequest.getUsername());
		    final String token = jwtUtil.generateToken(userDetails);
		    return ResponseEntity.ok(new AuthResponse(token));
	}
	
	private void authenticate(String username, String password) throws Exception {
	    try {
	      authenticationManager.authenticate(
	          new UsernamePasswordAuthenticationToken(username, password));
	    } catch (DisabledException e) {
	      throw new Exception("USER_DISABLED", e);
	    } catch (BadCredentialsException e) {
	      throw new Exception("INVALID_CREDENTIALS", e);
	    }
	  }

}
