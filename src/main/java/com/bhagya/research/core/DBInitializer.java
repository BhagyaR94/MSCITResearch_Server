package com.bhagya.research.core;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.bhagya.research.dashboard.user.repository.UserRepository;
import com.bhagya.research.entity.User;
import com.bhagya.research.entity.enums.UserLevel;

@Component
public class DBInitializer implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	public DBInitializer(UserRepository repository) {
		this.userRepository = userRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		this.userRepository.deleteAll();
		
		User user = new User();
		user.setFirstName("Bhagya");
		user.setLastName("Rathnayake");
		user.setUserName("BRathnayake");
		user.setPassword("Welcome123");
		user.setUserLevel(UserLevel.ADMINISTRATOR);
		userRepository.save(user);
		
	}
	
	

}
