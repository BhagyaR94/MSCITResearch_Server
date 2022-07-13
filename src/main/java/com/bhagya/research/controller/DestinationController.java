package com.bhagya.research.controller;

import com.bhagya.research.business.destination.dto.DestinationCategory;
import com.bhagya.research.business.destination.dto.DestinationDTO;
import com.bhagya.research.business.destination.service.DestinationService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class DestinationController {

    @Autowired
    DestinationService destinationService;

    @PostMapping("/destination")
    public List<DestinationDTO> getDestination() throws JsonProcessingException {
        return destinationService.loadDestinationsByPreference();
    }

    @PostMapping("/loadDestinationCategories")
    public List<DestinationCategory> loadDestinationCategories() {
        return Arrays.asList(DestinationCategory.values());
    }

}
