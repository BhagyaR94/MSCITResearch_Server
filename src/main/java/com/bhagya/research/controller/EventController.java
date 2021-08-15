package com.bhagya.research.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bhagya.research.business.event.dto.EventDTO;
import com.bhagya.research.business.event.service.EventService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@CrossOrigin(maxAge = 3600, origins = "*", exposedHeaders = "**")
public class EventController {

	@Autowired
	private EventService eventService;

	@PostMapping
	public ResponseEntity<?> getAllFutureEvents() {
		return ResponseEntity.ok(null);
	}

	@PostMapping("/createEvent")
	public ResponseEntity<?> createEvent(@RequestParam("eventDTO") String eventDetails,
			@RequestParam("thumbnail") MultipartFile file) throws IOException {
		EventDTO eventDTO = new ObjectMapper().readValue(eventDetails, EventDTO.class);
		return ResponseEntity.ok(eventService.createEvent(eventDTO, file));
	}

}
