package com.bhagya.research.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

	@GetMapping("/")
	public String firstSlash(){
		return "Hello";
	} 
	
	@GetMapping("/landing1")
	public String secondSlash(){
		return "Hello";
	} 
	
}
