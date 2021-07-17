package com.bhagya.research.core.model;

public class AuthenticationResponse {
	private final String jwt;

	public AuthenticationResponse(String jwt) {
		this.jwt = jwt;
	}

	public String getJWT() {
		return jwt;
	}
}
