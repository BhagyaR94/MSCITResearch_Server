package com.bhagya.research.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bhagya.research.dashboard.user.dto.AppUserDTO;
import com.bhagya.research.dashboard.user.service.AppUserDetailsService;

@RestController
@CrossOrigin(maxAge = 3600, origins = "*", exposedHeaders = "**")
public class UserController {

	@Autowired
	AppUserDetailsService appUserService;

	@PostMapping("/saveUser")
	public void saveUser(@RequestBody AppUserDTO appUserDTO) {
		appUserService.saveUser(appUserDTO);
	}
}
