package com.bhagya.research.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bhagya.research.core.model.AuthenticationRequest;
import com.bhagya.research.core.model.AuthenticationResponse;
import com.bhagya.research.core.security.service.AuthService;
import com.bhagya.research.dashboard.user.dto.AppUserDetails;
import com.bhagya.research.dashboard.user.service.AppUserDetailsService;
import com.bhagya.research.entity.enums.UserLevel;

@CrossOrigin(maxAge = 3600)
@RestController
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AppUserDetailsService appUserdetailsService;

	@Autowired
	private AuthService authService;

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest)
			throws Exception {

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
					authenticationRequest.getUserName(), authenticationRequest.getPassword()));
		} catch (BadCredentialsException badCredentialsException) {
			throw new Exception("Username or Password incorrect", badCredentialsException);
		}

		final AppUserDetails userDetails = (AppUserDetails) appUserdetailsService
				.loadUserByUsername(authenticationRequest.getUserName());
		if (userDetails.getAppUserDTO().getUserLevel().equals(UserLevel.TEMPORARY)) {
			appUserdetailsService.setUserInactive(userDetails.getUsername());
		}
		return ResponseEntity.ok(new AuthenticationResponse(authService.generateJWTToken(userDetails.getUsername()), userDetails.getUsername(),
				userDetails.getAppUserDTO().getUserLevel()));
	}

}
