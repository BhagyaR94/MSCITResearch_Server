package com.bhagya.research.core.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhagya.research.core.security.JWTUtil;

@Service
public class AuthService {
	private static final int JWT_EXPIRATION = 1000 * 60 * 60 * 10;
	
	@Autowired
	private JWTUtil jwtUtil;

	public String generateJWTToken(String userName) {
		return jwtUtil.generateToken(userName, JWT_EXPIRATION);
	}
	
}
