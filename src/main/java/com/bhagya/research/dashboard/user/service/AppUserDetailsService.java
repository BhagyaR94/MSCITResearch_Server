package com.bhagya.research.dashboard.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bhagya.research.dashboard.user.dto.AppUserDTO;
import com.bhagya.research.dashboard.user.dto.AppUserDetails;
import com.bhagya.research.dashboard.user.dto.EnrolledUserDTO;
import com.bhagya.research.dashboard.user.mapper.EnrolledUserDTOMapper;
import com.bhagya.research.dashboard.user.mapper.UserDTOMapper;
import com.bhagya.research.dashboard.user.mapper.UserEntityMapper;
import com.bhagya.research.dashboard.user.repository.EnrolledUserRepository;
import com.bhagya.research.dashboard.user.repository.UserRepository;
import com.bhagya.research.entity.EnrolledUser;
import com.bhagya.research.entity.User;
import com.bhagya.research.entity.enums.UserLevel;

import javassist.NotFoundException;

@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	EnrolledUserRepository enrolledUserRepository;

	@Autowired
	EnrolledUserDTOMapper enrolledUserDTOMapper;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUserName(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username));
		return new AppUserDetails(new UserDTOMapper().mapFromUser(user.get()));
	}

	public void saveUser(AppUserDTO appUserDTO) {
		userRepository.save(new UserEntityMapper().mapFromUserDTO(appUserDTO));
	}
	
	public boolean validateEnrolledUser(EnrolledUserDTO enrolledUserDTO) throws NotFoundException {
		Optional<EnrolledUser> enrolledUser = enrolledUserRepository.findByEmail(enrolledUserDTO.getEmail());
		enrolledUser.orElseThrow(() -> new NotFoundException("No records available for the provided email "
				+ enrolledUserDTO.getEmail() + ". Please contact system Administrator!"));
		return enrolledUser.get().getTempPassword().equals(enrolledUserDTO.getTempPassword());
	}

	public void enrollNewUser(EnrolledUserDTO enrolledUserDTO) {
		if (enrolledUserDTO.getUserLevel() != UserLevel.ADMINISTRATOR) {
			User responsibleUser = userRepository.findUserByUserName(enrolledUserDTO.getCreatedBy());
			EnrolledUser enrollingUser = enrolledUserDTOMapper.mapFromEnrolledUserDTO(enrolledUserDTO);
			enrollingUser.setCreatedBy(responsibleUser);
			enrolledUserRepository.save(enrollingUser);
		}
	}

}
