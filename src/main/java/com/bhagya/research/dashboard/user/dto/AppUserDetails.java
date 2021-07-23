package com.bhagya.research.dashboard.user.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


public class AppUserDetails implements UserDetails {
	
	private AppUserDTO appUserDTO;

	public AppUserDetails(AppUserDTO appUserDTO) {
		this.appUserDTO = appUserDTO;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return appUserDTO.getPassword();
	}

	@Override
	public String getUsername() {
		return appUserDTO.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public AppUserDTO getAppUserDTO() {
		return appUserDTO;
	}

	public void setAppUserDTO(AppUserDTO appUserDTO) {
		this.appUserDTO = appUserDTO;
	}

}
