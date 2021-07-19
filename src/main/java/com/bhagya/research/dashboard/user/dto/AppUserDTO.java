package com.bhagya.research.dashboard.user.dto;

import com.bhagya.research.entity.User;
import com.bhagya.research.entity.enums.UserLevel;

public class AppUserDTO {

	private String firstName;
	private String lastName;
	private String userName;
	private String password;
	private UserLevel userLevel;

	public AppUserDTO(User user) {
		this.userName = user.getUserName();
		this.password = user.getPassword();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
	};

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

//	@Override
//	public Collection<? extends GrantedAuthority> getAuthorities() {
//		return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMINISTRATOR"));
//	}
//
//	@JsonProperty(value = "password")
//	@Override
//	public String getPassword() {
//		return password;
//	}
//
//	@JsonProperty(value = "userName")
//	@Override
//	public String getUsername() {
//		return userName;
//	}
//
//	@Override
//	public boolean isAccountNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isAccountNonLocked() {
//		return true;
//	}
//
//	@Override
//	public boolean isCredentialsNonExpired() {
//		return true;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		return true;
//	}
//
//	@JsonProperty(value = "firstName")
//	public String getFirstName() {
//		return this.firstName;
//	}
//
//	@JsonProperty(value = "lastName")
//	public String getLastName() {
//		return this.lastName;
//	}
//
//	@JsonProperty(value = "userLevel")
//	public UserLevel getUserLevel() {
//		return userLevel;
//	}
//
//	@JsonProperty(value = "userLevel")
//	public void setUserLevel(UserLevel userLevel) {
//		this.userLevel = userLevel;
//	}
	
	

}
