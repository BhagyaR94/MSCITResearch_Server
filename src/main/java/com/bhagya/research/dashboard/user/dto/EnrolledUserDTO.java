package com.bhagya.research.dashboard.user.dto;

import com.bhagya.research.entity.User;
import com.bhagya.research.entity.enums.UserLevel;

public class EnrolledUserDTO {

	private String email;
	private String tempPassword;
	private UserLevel userLevel;
	private String createdBy;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTempPassword() {
		return tempPassword;
	}

	public void setTempPassword(String tempPassword) {
		this.tempPassword = tempPassword;
	}

	public UserLevel getUserLevel() {
		return userLevel;
	}

	public void setUserLevel(UserLevel userLevel) {
		this.userLevel = userLevel;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

}
