package com.bhagya.research.business.destination.service;

import com.bhagya.research.business.destination.dto.DestinationCategory;
import com.bhagya.research.business.destination.dto.DestinationDTO;
import com.bhagya.research.business.destination.dto.DestinationRequestDTO;
import com.bhagya.research.external.ExternalService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import java.util.Arrays;
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

        return Arrays.asList(objectMapper.readValue(externalService.getDataFromExternalSource("http://127.0.0.1:5000/loadOptimizedDestinations", object, headers), DestinationDTO[].class));
//        return Arrays.asList(objectMapper.readValue(externalService.getDataFromExternalSource("https://research-algorithm.herokuapp.com/loadOptimizedDestinations", object, headers), DestinationDTO[].class));
    }

}
