package com.personal.hotel.communicator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RatingServiceCommunicator {

    private final RestTemplate restTemplate;

    @Autowired
    public RatingServiceCommunicator(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public long getRating(String id){
        String url = "http://localhost:8081/rating/id/";
        ResponseEntity<Long> response = restTemplate.getForEntity(url,Long.class);
        return response.getBody();
    }

}
