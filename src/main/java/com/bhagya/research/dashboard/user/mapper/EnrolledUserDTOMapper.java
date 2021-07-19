package com.bhagya.research.dashboard.user.mapper;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.bhagya.research.dashboard.user.dto.EnrolledUserDTO;
import com.bhagya.research.entity.EnrolledUser;

@Component
public class EnrolledUserDTOMapper {
	public EnrolledUser mapFromEnrolledUserDTO(EnrolledUserDTO enrolledUserDTO) {
		EnrolledUser enrolledUser = new EnrolledUser();
		enrolledUser.setActivated(false);
		enrolledUser.setCreatedOn(new Date());
		enrolledUser.setEmail(enrolledUserDTO.getEmail());
		enrolledUser.setTempPassword(enrolledUserDTO.getTempPassword());
		enrolledUser.setUserLevel(enrolledUserDTO.getUserLevel());
		return enrolledUser;
	}
}
