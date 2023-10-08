package com.bhagya.research.business.destination.service;

import com.bhagya.research.business.destination.dto.DestinationDTO;
import com.bhagya.research.business.destination.dto.DestinationRequestDTO;
import com.bhagya.research.core.dto.ImageButtonDTO;
import com.bhagya.research.external.ExternalService;
import com.bhagya.research.external.ExternalUtils;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class DestinationService {

    @Autowired
    private ExternalService externalService;

    public List<DestinationDTO> loadDestinationsByPreference(DestinationRequestDTO destinationRequestDTO) throws JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        ObjectMapper objectMapper = new ObjectMapper();
        String object = objectMapper.writeValueAsString(destinationRequestDTO);

        return Arrays.asList(objectMapper.readValue(externalService.getDataFromExternalSource(ExternalUtils.ALGO_SERVER + "loadOptimizedDestinations", object, headers), DestinationDTO[].class));
    }

    public List<ImageButtonDTO> loadDestinationCategories() {
        return populateDestinationCategories();
    }

    private List<ImageButtonDTO> populateDestinationCategories() {
        List<ImageButtonDTO> destinationCategories = new ArrayList<>();
        destinationCategories.add(new ImageButtonDTO("Waterfall", "waterfall"));
        destinationCategories.add(new ImageButtonDTO("Train", "train"));
        destinationCategories.add(new ImageButtonDTO("Surfing", "surfing"));
        destinationCategories.add(new ImageButtonDTO("Shooting", "shooting"));
        destinationCategories.add(new ImageButtonDTO("Sea", "sea"));
        destinationCategories.add(new ImageButtonDTO("Scenic", "scenic"));
        destinationCategories.add(new ImageButtonDTO("Safari", "safari"));
        destinationCategories.add(new ImageButtonDTO("Rivers", "rivers"));
        destinationCategories.add(new ImageButtonDTO("Rafting", "rafting"));
        destinationCategories.add(new ImageButtonDTO("None", "none"));
        destinationCategories.add(new ImageButtonDTO("Nature", "nature"));
        destinationCategories.add(new ImageButtonDTO("Mountain", "mountain"));
        destinationCategories.add(new ImageButtonDTO("Liquor", "liquor"));
        destinationCategories.add(new ImageButtonDTO("Jungle", "jungle"));
        destinationCategories.add(new ImageButtonDTO("Hunting", "hunting"));
        destinationCategories.add(new ImageButtonDTO("Hiking", "hiking"));
        destinationCategories.add(new ImageButtonDTO("Heritage", "heritage"));
        destinationCategories.add(new ImageButtonDTO("Food", "food"));
        destinationCategories.add(new ImageButtonDTO("Elephants", "elephants"));
        destinationCategories.add(new ImageButtonDTO("Drinks", "Drinks"));
        destinationCategories.add(new ImageButtonDTO("Cruise", "cruise"));
        destinationCategories.add(new ImageButtonDTO("City", "city"));
        destinationCategories.add(new ImageButtonDTO("Buddhism", "buddhism"));
        destinationCategories.add(new ImageButtonDTO("Beach", "beach"));
        destinationCategories.add(new ImageButtonDTO("Arts", "arts"));
        destinationCategories.add(new ImageButtonDTO("Animals", "animals"));
        destinationCategories.add(new ImageButtonDTO("Adventure", "adventure"));
        Collections.reverse(destinationCategories);
        return destinationCategories;
    }

}
