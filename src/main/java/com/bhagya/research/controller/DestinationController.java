package com.bhagya.research.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DestinationController {

	@GetMapping("/destination")
	public String getDestination() {
		return "Destination Here";
	}

}
