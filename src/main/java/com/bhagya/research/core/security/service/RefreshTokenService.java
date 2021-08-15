package com.bhagya.research.core.security.service;

import java.time.Instant;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bhagya.research.core.exception.TokenRefreshException;
import com.bhagya.research.core.repository.RefreshTokenRepository;
import com.bhagya.research.dashboard.user.repository.UserRepository;
import com.bhagya.research.entity.RefreshToken;

@Service
public class RefreshTokenService {

	private static final int REFRESH_TOKEN_EXPIRATION = 1000 * 60 * 60 * 24;

	@Autowired
	private RefreshTokenRepository refreshTokenRepository;

	@Autowired
	private UserRepository userRepository;

	public Optional<RefreshToken> findByToken(String token) {
		return refreshTokenRepository.findByToken(token);
	}

	public Optional<RefreshToken> findByUser(String userName) {
		return refreshTokenRepository.findByUser(userRepository.findUserByUserName(userName));
	}

	public RefreshToken createRefreshTokenService(String userName) {
		RefreshToken refreshToken = new RefreshToken();
		refreshToken.setUser(userRepository.findUserByUserName(userName));
		refreshToken.setExpiresOn(Instant.now().plusMillis(REFRESH_TOKEN_EXPIRATION));
		refreshToken.setToken(UUID.randomUUID().toString());
		refreshTokenRepository.save(refreshToken);
		return refreshToken;
	}

	public RefreshToken verifyExpiration(RefreshToken token) {
		if (token.getExpiresOn().compareTo(Instant.now()) < 0) {
			refreshTokenRepository.delete(token);
			throw new TokenRefreshException(token.getToken(),
					"Refresh token was expired. Please make a new signin request");
		}

		return token;
	}

	public void deleteRefreshToken(RefreshToken refreshToken) {
		refreshTokenRepository.delete(refreshToken);
	}

}
