package com.bhagya.research.dashboard.user.mapper;

import com.bhagya.research.dashboard.user.dto.AppUserDTO;
import com.bhagya.research.entity.User;

public class UserDTOMapper {
	
	public AppUserDTO mapFromUser(User user) {
		AppUserDTO appUserDTO = new AppUserDTO();
		appUserDTO.setFirstName(user.getFirstName());
		appUserDTO.setLastName(user.getLastName());
		appUserDTO.setPassword(user.getPassword());
		appUserDTO.setUserLevel(user.getUserLevel());
		appUserDTO.setUserName(user.getUserName());
		appUserDTO.setActive(user.isActive());
		return appUserDTO;
	}
	
}
