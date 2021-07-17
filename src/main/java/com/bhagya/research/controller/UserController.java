package com.bhagya.research.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bhagya.research.dashboard.user.dto.AppUserDTO;
import com.bhagya.research.dashboard.user.service.AppUserDetailsService;

@RestController
public class UserController {

	@Autowired
	AppUserDetailsService appUserService;
	
	@PostMapping("/saveUser")
	public void saveUser(@RequestParam AppUserDTO appUserDTO) {
		appUserService.saveUser(appUserDTO);
	}
	
}
