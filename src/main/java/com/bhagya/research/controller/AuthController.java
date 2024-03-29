package com.bhagya.research.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhagya.research.core.exception.TokenRefreshException;
import com.bhagya.research.core.model.AuthenticationRequest;
import com.bhagya.research.core.model.AuthenticationResponse;
import com.bhagya.research.core.model.TokenRefreshRequest;
import com.bhagya.research.core.security.service.AuthService;
import com.bhagya.research.core.security.service.RefreshTokenService;
import com.bhagya.research.dashboard.user.dto.AppUserDetails;
import com.bhagya.research.dashboard.user.service.AppUserDetailsService;
import com.bhagya.research.entity.RefreshToken;
import com.bhagya.research.entity.enums.UserLevel;

@RestController
@CrossOrigin(maxAge = 3600, origins = "*", exposedHeaders = "**")
public class AuthController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private AppUserDetailsService appUserdetailsService;

	@Autowired
	private AuthService authService;

	@Autowired
	private RefreshTokenService refreshTokenService;

	@PostMapping("/authenticate")
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

		refreshTokenService.findByUser(userDetails.getUsername()).stream().forEach(refreshToken -> {
			refreshTokenService.deleteRefreshToken(refreshToken);
		});

		return ResponseEntity.ok(new AuthenticationResponse(authService.generateJWTToken(userDetails.getUsername()),
				userDetails.getUsername(), userDetails.getAppUserDTO().getUserLevel(),
				refreshTokenService.createRefreshTokenService(userDetails.getUsername()).getToken()));
	}

	@PostMapping("/refreshtoken")
	public ResponseEntity<?> refreshtoken(@RequestBody TokenRefreshRequest request) {
		String requestRefreshToken = request.getRefreshToken();

		return refreshTokenService.findByToken(requestRefreshToken).map(refreshTokenService::verifyExpiration)
				.map(RefreshToken::getUser).map(user -> {
					String token = authService.generateJWTToken(user.getUserName());
					return ResponseEntity.ok(new AuthenticationResponse(token, user.getUserName(), user.getUserLevel(),
							requestRefreshToken));
				})
				.orElseThrow(() -> new TokenRefreshException(requestRefreshToken, "Refresh token is not in database!"));
	}

	@PostMapping("/signout")
	public ResponseEntity<?> logout(@RequestBody TokenRefreshRequest request) {
		return ResponseEntity.ok(new AuthenticationResponse("", "", null, ""));
	}

}
