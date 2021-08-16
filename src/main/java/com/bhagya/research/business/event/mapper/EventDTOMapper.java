package com.bhagya.research.business.event.mapper;

import org.springframework.stereotype.Component;

import com.bhagya.research.business.event.dto.EventDTO;
import com.bhagya.research.entity.Event;

@Component
public class EventDTOMapper {

	public EventDTO mapTo(Event event) {
		EventDTO eventDTO = new EventDTO();
		eventDTO.setName(event.getName());
		eventDTO.setDescription(event.getDescription());
		eventDTO.setStart(event.getStart());
		eventDTO.setEnd(event.getEnd());
		eventDTO.setCategory(event.getCategory());
		eventDTO.setLatitude(event.getLatitude());
		eventDTO.setLongitude(event.getLongitude());
		eventDTO.setCity(event.getCity());
		eventDTO.setCountry(event.getCountry());
		eventDTO.setDressCode(event.getDressCode());
		eventDTO.setHashTags(event.getHashTags());
		eventDTO.setPrerequisits(event.getPrerequisits());
		eventDTO.setRegistration(event.getRegistration());
		eventDTO.setPaymentInfo(event.getPaymentInfo());
		eventDTO.setPaymentMethod(event.getPaymentMethod());
		eventDTO.setFoodAndDrinks(event.getFoodAndDrinks());
		eventDTO.setMinAge(event.getMinAge());
		eventDTO.setOrganizers(event.getOrganizers());
		eventDTO.setFacilities(event.getFacilities());
		eventDTO.setRiskLevel(event.getRiskLevel());
//		eventDTO.setThumbnail(event.getThumbnail());
		return eventDTO;
	}

	public Event mapFrom(EventDTO eventDTO) {
		Event event = new Event();
		event.setName(eventDTO.getName());
		event.setDescription(eventDTO.getDescription());
		event.setStart(eventDTO.getStart());
		event.setEnd(eventDTO.getEnd());
		event.setCategory(eventDTO.getCategory());
		event.setLatitude(eventDTO.getLatitude());
		event.setLongitude(eventDTO.getLongitude());
		event.setCity(eventDTO.getCity());
		event.setCountry(eventDTO.getCountry());
		event.setDressCode(eventDTO.getDressCode());
		event.setHashTags(eventDTO.getHashTags());
		event.setPrerequisits(eventDTO.getPrerequisits());
		event.setRegistration(eventDTO.getRegistration());
		event.setPaymentInfo(eventDTO.getPaymentInfo());
		event.setPaymentMethod(eventDTO.getPaymentMethod());
		event.setFoodAndDrinks(eventDTO.getFoodAndDrinks());
		event.setMinAge(eventDTO.getMinAge());
		event.setOrganizers(eventDTO.getOrganizers());
		event.setFacilities(eventDTO.getFacilities());
		event.setRiskLevel(eventDTO.getRiskLevel());
//		event.setThumbnail(eventDTO.getThumbnail());
		return event;
	}

}
