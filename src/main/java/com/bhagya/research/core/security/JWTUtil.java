package com.bhagya.research.core.security;

import java.util.Date;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JWTUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(JWTUtil.class);

	 private String SECRET_KEY = "secret";

	    public String extractUsername(String token) {
	        return extractClaim(token, Claims::getSubject);
	    }

	    public Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }

	    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimsResolver.apply(claims);
	    }
	    private Claims extractAllClaims(String token) {
	        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	    }

	    private Boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }

	    public String generateToken(String userName, int duration) {
	        Map<String, Object> claims = new HashMap<>();
	        return createToken(claims, userName, duration);
	    }

	    private String createToken(Map<String, Object> claims, String subject, int duration) {

	        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + duration))
	                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	    }

		public boolean validateToken(String token, UserDetails userDetails) {
			boolean isTokenValid = false;
			try {
				final String username = extractUsername(token);
				isTokenValid = (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
			} catch (SignatureException e) {
				logger.error("Invalid JWT signature: {}", e.getMessage());
			} catch(MalformedJwtException  e) {
				logger.error("Invalid JWT token: {}", e.getMessage());
			} catch(ExpiredJwtException e) {
				logger.error("JWT token is expired: {}", e.getMessage());
			} catch(UnsupportedJwtException e) {
				logger.error("JWT token is unsupported: {}", e.getMessage());
			} catch(IllegalArgumentException e) {
				logger.error("JWT claims string is empty: {}", e.getMessage());
			}
			return isTokenValid;
		}
}
