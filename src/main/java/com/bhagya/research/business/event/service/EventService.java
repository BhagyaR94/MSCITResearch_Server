package com.bhagya.research.business.event.service;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import com.bhagya.research.core.dto.ImageDTO;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bhagya.research.business.event.dto.EventDTO;
import com.bhagya.research.business.event.mapper.EventDTOMapper;
import com.bhagya.research.business.event.repository.EventRepository;
import com.bhagya.research.entity.Event;

import javax.persistence.EntityNotFoundException;

@Service
public class EventService {

    @Autowired
    private EventRepository eventRepository;

    @Autowired
    private EventDTOMapper eventDTOMapper;

    private static final String EVENT_FILE_PATH = "uploads/events/";
    private static final String EVENT_PREFIX = "EVT_";
    private static final String SLASH = "/";

    public Event createEvent(EventDTO eventDTO) throws IOException {
        Event eventToBeCreated = eventDTOMapper.mapFrom(eventDTO);
        if (eventDTO.getId() != null && !eventDTO.getId().equals("")) {
            eventToBeCreated.setId(Long.parseLong(eventDTO.getId()));
        }
        Event createdEvent = eventRepository.save(eventToBeCreated);

        if (createdEvent.getId() != null && eventDTO.getThumbnail() != null) {
            String dirPath = EVENT_FILE_PATH + EVENT_PREFIX + createdEvent.getId();
            String fileName = EVENT_PREFIX + createdEvent.getId() + eventDTO.getThumbnail().getFileExtension();
            storeThumbnail(dirPath, eventDTO.getThumbnail().getEncodedBase64(), fileName);
            createdEvent.setThumbnail(dirPath + SLASH + fileName);
            eventRepository.save(createdEvent);
        }

        return createdEvent;
    }

    public void storeThumbnail(String dirPath, String base64Encode, String fileName) throws IOException {
        if (!new File(dirPath).exists()) {
            new File(dirPath);
        }
        File fileToSave = new File(dirPath + SLASH + fileName);

        if (new File(dirPath).exists()) {
            File[] listOfFiles = new File(dirPath).listFiles();
            assert listOfFiles != null;
            for (File file : listOfFiles) {
                file.delete();
            }
        }
        FileUtils.writeByteArrayToFile(fileToSave, Base64.getDecoder().decode(base64Encode));
    }

    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream().map(eventDTOMapper::mapTo).collect(Collectors.toList());
    }

    public Event getEventById(String id) {
        return eventRepository.findById(Long.parseLong(id)).orElseThrow(() -> new EntityNotFoundException("Unable to find entity by " + id));
    }


    public List<EventDTO> getEventsAfter(Date date) {
        return eventRepository.findByStart(date).stream().map(eventDTOMapper::mapTo).collect(Collectors.toList());
    }

    public ImageDTO loadImageByEventId(String id) throws IOException {
        Event event = eventRepository.findById(Long.parseLong(id)).orElseThrow(() -> new EntityNotFoundException("Unable to find entity by " + id));
        File thumbnail = new File(event.getThumbnail());
        ImageDTO imageDTO = new ImageDTO();
        imageDTO.setEncodedBase64(Base64.getEncoder().encodeToString(FileUtils.readFileToByteArray(thumbnail)));
        imageDTO.setFileExtension(thumbnail.getPath().substring(thumbnail.getPath().lastIndexOf('.')));
        return imageDTO;
    }

}
