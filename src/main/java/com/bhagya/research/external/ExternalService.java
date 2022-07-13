package com.bhagya.research.external;

import com.bhagya.research.business.destination.dto.DestinationRequestDTO;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class ExternalService {

    public String getDataFromExternalSource(String url, String parameters, HttpHeaders httpHeaders) {
        RestTemplate restTemplate = new RestTemplate();
        HttpEntity<String> request =
                new HttpEntity<String>(parameters, httpHeaders);
        return restTemplate.postForObject(url, request, String.class);
    }

}
