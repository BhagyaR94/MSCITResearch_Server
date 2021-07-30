package com.bhagya.research.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class RefreshToken {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(name = "token")
	private String token;

	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	@Column(name = "expires_on")
	private Instant expiresOn;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Instant getExpiresOn() {
		return expiresOn;
	}

	public void setExpiresOn(Instant expiresOn) {
		this.expiresOn = expiresOn;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

}
