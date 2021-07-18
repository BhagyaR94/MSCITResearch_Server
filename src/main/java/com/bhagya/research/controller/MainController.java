package com.bhagya.research.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bhagya.research.core.model.AuthenticationRequest;
import com.bhagya.research.core.model.AuthenticationResponse;
import com.bhagya.research.core.security.JWTUtil;
import com.bhagya.research.dashboard.user.service.AppUserDetailsService;

@CrossOrigin(maxAge = 3600)
@RestController
public class MainController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AppUserDetailsService appUserdetailsService;

	@Autowired
	private JWTUtil jwtUtil;

	@GetMapping("/hello")
	public String helloMethod() {
		return "<h1>Hello</h1>";
	}

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException badCredentialsException) {
			throw new Exception("Username or Password incorrect", badCredentialsException);
		}

		final UserDetails userDetails = appUserdetailsService.loadUserByUsername(authenticationRequest.getUserName());
		final String jwt = jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok(new AuthenticationResponse(jwt));
	}

}
