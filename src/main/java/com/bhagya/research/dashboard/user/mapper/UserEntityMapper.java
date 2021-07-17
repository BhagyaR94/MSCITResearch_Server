package com.bhagya.research.dashboard.user.mapper;

import com.bhagya.research.dashboard.user.dto.AppUserDTO;
import com.bhagya.research.entity.User;

public class UserEntityMapper {
	
	public User mapFromUserDTO(AppUserDTO appUserDTO) {
		User user = new User();
		user.setFirstName(appUserDTO.getFirstName());
		user.setLastName(appUserDTO.getLastName());
		user.setPassword(appUserDTO.getPassword());
		user.setUserName(appUserDTO.getUsername());
		user.setUserLevel(appUserDTO.getUserLevel());
		return user;
	}

}
