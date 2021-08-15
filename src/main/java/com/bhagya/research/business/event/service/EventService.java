package com.bhagya.research.business.event.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bhagya.research.business.event.dto.EventDTO;
import com.bhagya.research.business.event.mapper.EventDTOMapper;
import com.bhagya.research.business.event.repository.EventRepository;
import com.bhagya.research.core.util.FileUploadUtil;
import com.bhagya.research.entity.Event;

@Service
public class EventService {

	@Autowired
	private EventRepository eventRepository;

	@Autowired
	private EventDTOMapper eventDTOMapper;
	
	private static final String EVENT_FILE_PATH = "uploads/events/";

	public Event createEvent(EventDTO eventDTO, MultipartFile file) throws IOException {
		Event createdEvent = eventRepository.save(eventDTOMapper.mapFrom(eventDTO));
		if (createdEvent.getId() != null && file.getOriginalFilename() != null) {
			String fileName = FileUploadUtil.getFileNameWithExtension("EVT_" + createdEvent.getId().toString(), file.getOriginalFilename());
			FileUploadUtil.saveFile(EVENT_FILE_PATH, fileName, file);
			createdEvent.setThumbnail(EVENT_FILE_PATH + fileName);
			eventRepository.save(createdEvent);
		}
		return createdEvent;
	}

	public List<EventDTO> getAllEvents() {
		return eventRepository.findAll().stream().map(eventDTOMapper::mapTo).collect(Collectors.toList());
	}

	public List<EventDTO> getEventsAfter(Date date) {
		return eventRepository.findByStart(date).stream().map(eventDTOMapper::mapTo).collect(Collectors.toList());
	}

}
