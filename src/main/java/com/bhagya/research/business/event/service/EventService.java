package com.bhagya.research.business.event.service;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bhagya.research.business.event.dto.EventDTO;
import com.bhagya.research.business.event.mapper.EventDTOMapper;
import com.bhagya.research.business.event.repository.EventRepository;
import com.bhagya.research.entity.Event;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventDTOMapper eventDTOMapper;

    private static final String EVENT_FILE_PATH = "uploads/events/";

    public Event createEvent(EventDTO eventDTO) throws IOException {
        Event createdEvent = eventRepository.save(eventDTOMapper.mapFrom(eventDTO));
        if (createdEvent.getId() != null && eventDTO.getThumbnail() != null) {
            String fileName = "EVT_" + createdEvent.getId() + eventDTO.getThumbnail().getFileExtension();
            byte[] imgArray = Base64.getDecoder().decode(eventDTO.getThumbnail().getEncodedBase64());
            FileUtils.writeByteArrayToFile(new File(EVENT_FILE_PATH + fileName), imgArray);
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
