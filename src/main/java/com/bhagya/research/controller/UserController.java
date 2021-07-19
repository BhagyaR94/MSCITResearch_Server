package com.bhagya.research.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bhagya.research.dashboard.user.dto.AppUserDTO;
import com.bhagya.research.dashboard.user.dto.EnrolledUserDTO;
import com.bhagya.research.dashboard.user.service.AppUserDetailsService;

import javassist.NotFoundException;

@RestController
public class UserController {

	@Autowired
	AppUserDetailsService appUserService;
	
	@PostMapping("/saveUser")
	public void saveUser(@RequestBody AppUserDTO appUserDTO) {
		appUserService.saveUser(appUserDTO);
	}
	
	@PostMapping("/enrollNewUser")
	public void enrollNewUser(@RequestBody EnrolledUserDTO enrolledUserDTO) {
		appUserService.enrollNewUser(enrolledUserDTO);
	}
	
	@PostMapping("/validateEnrolledUser")
	public boolean validateEnrolledUser(@RequestBody EnrolledUserDTO enrolledUserDTO) throws NotFoundException {
		return appUserService.validateEnrolledUser(enrolledUserDTO);
	}
	
}
