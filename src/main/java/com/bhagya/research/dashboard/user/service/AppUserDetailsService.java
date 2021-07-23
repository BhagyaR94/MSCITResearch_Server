package com.bhagya.research.dashboard.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bhagya.research.dashboard.user.dto.AppUserDTO;
import com.bhagya.research.dashboard.user.dto.AppUserDetails;
import com.bhagya.research.dashboard.user.mapper.EnrolledUserDTOMapper;
import com.bhagya.research.dashboard.user.mapper.UserDTOMapper;
import com.bhagya.research.dashboard.user.mapper.UserEntityMapper;
import com.bhagya.research.dashboard.user.repository.EnrolledUserRepository;
import com.bhagya.research.dashboard.user.repository.UserRepository;
import com.bhagya.research.entity.User;
import com.bhagya.research.entity.enums.UserLevel;

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
		AppUserDetails appUserDetail = new AppUserDetails(new UserDTOMapper().mapFromUser(user.get()));

		checkUserActive(user.get().isActive());

		return appUserDetail;
	}
	
	public void setUserInactive(String userName) {
		Optional<User> user = userRepository.findByUserName(userName);
		user.orElseThrow(() -> new UsernameNotFoundException(userName));
		if (user.isPresent() && user.get().getUserLevel() == UserLevel.TEMPORARY) {
			user.get().setActive(false);
			userRepository.save(user.get());
		}
	}

	private boolean checkUserActive(boolean userActive) throws RuntimeException {
		if (!userActive) {
			throw new RuntimeException("Inactive User! Please contact system admistrator.");
		}
		return userActive;
	}

	public void saveUser(AppUserDTO appUserDTO) {
		userRepository.save(new UserEntityMapper().mapFromUserDTO(appUserDTO));
	}

}
