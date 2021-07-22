package com.bhagya.research.core.model;

import com.bhagya.research.entity.enums.UserLevel;

public class AuthenticationResponse {
	private final String jwt;
	private final String userName;
	private final UserLevel userLevel;

	public AuthenticationResponse(String jwt, String userName, UserLevel userLevel) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}

	public String getUserName() {
		return userName;
	}

	public UserLevel getUserLevel() {
		return userLevel;
	}
	
}
