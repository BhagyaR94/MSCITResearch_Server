package com.bhagya.research.dashboard.user.dto;

import com.bhagya.research.entity.User;
import com.bhagya.research.entity.enums.UserLevel;

public class AppUserDTO {

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private UserLevel userLevel;
	private boolean isActive;
	private String temporaryUserName;

	public AppUserDTO(User user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.isActive = user.isActive();
		this.temporaryUserName = user.getTemporaryUserName();
	}

	public AppUserDTO() {

	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserLevel getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(UserLevel userLevel) {
		this.userLevel = userLevel;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public String getTemporaryUserName() {
		return temporaryUserName;
	}

	public void setTemporaryUserName(String temporaryUserName) {
		this.temporaryUserName = temporaryUserName;
	}

}
