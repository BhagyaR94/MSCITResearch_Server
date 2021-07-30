package com.bhagya.research.core.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bhagya.research.entity.RefreshToken;
import com.bhagya.research.entity.User;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Integer>{
	public String findBytoken(String token);

	public int deleteByUser(User user);

	public Optional<RefreshToken> findByToken(String token);
}
