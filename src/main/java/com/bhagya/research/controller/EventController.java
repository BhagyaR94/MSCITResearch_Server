package com.bhagya.research.controller;

import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.bhagya.research.business.event.dto.EventDTO;
import com.bhagya.research.business.event.service.EventService;

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
	public ResponseEntity<?> createEvent(@RequestBody EventDTO eventDTO) throws IOException {
		return ResponseEntity.ok(eventService.createEvent(eventDTO));
	}

}
