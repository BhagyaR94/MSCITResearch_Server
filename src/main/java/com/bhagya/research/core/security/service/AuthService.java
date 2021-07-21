package com.bhagya.research.core.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhagya.research.core.security.JWTUtil;

@Service
public class AuthService {
	private final int STANDARD_USER_TOKEN_DURATION = 1000 * 60 * 60 * 10;
	
	@Autowired
	private JWTUtil jwtUtil;

	public String generateJWTToken(String userName) {
		return jwtUtil.generateToken(userName, STANDARD_USER_TOKEN_DURATION);
	}
	
}
