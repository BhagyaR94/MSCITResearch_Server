package com.bhagya.research.core.model;

import com.bhagya.research.entity.enums.UserLevel;

public class AuthenticationResponse {
	private final String jwt;
	private final String userName;
	private final UserLevel userLevel;
	private final String refreshToken;

	public AuthenticationResponse(String jwt, String userName, UserLevel userLevel, String refreshToken) {
		this.jwt = jwt;
		this.userName = userName;
		this.userLevel = userLevel;
		this.refreshToken = refreshToken;
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

	public String getRefreshToken() {
		return refreshToken;
	}
	
}
