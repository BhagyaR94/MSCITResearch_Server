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
		// TODO Auto-generated method stub
		return appUserDTO.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return appUserDTO.getUserName();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public AppUserDTO getAppUserDTO() {
		return appUserDTO;
	}

	public void setAppUserDTO(AppUserDTO appUserDTO) {
		this.appUserDTO = appUserDTO;
	}

}
