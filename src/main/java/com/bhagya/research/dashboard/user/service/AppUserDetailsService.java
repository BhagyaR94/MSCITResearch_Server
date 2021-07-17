package com.bhagya.research.dashboard.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bhagya.research.dashboard.user.dto.AppUserDTO;
import com.bhagya.research.dashboard.user.dto.AppUserDetails;
import com.bhagya.research.dashboard.user.mapper.UserDTOMapper;
import com.bhagya.research.dashboard.user.mapper.UserEntityMapper;
import com.bhagya.research.dashboard.user.repository.UserRepository;
import com.bhagya.research.entity.User;


@Service
public class AppUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Optional<User> user = userRepository.findByUserName(username);
		user.orElseThrow(() -> new UsernameNotFoundException(username));
		return new AppUserDetails(new UserDTOMapper().mapFromUser(user.get()));
	}
	
	public void saveUser(AppUserDTO appUserDTO) {
		userRepository.save(new UserEntityMapper().mapFromUserDTO(appUserDTO));
	}

}
