package com.personal.hotel.communicator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class RatingServiceCommunicator {

    private final RestTemplate restTemplate;

    @Autowired
    public RatingServiceCommunicator(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    public long getRating(String id){
        String url = "http://localhost:8081/rating/id/";
        ResponseEntity<Long> response = restTemplate.getForEntity(url+id,Long.class);
        return response.getBody();
    }

    public void addRating(Map<String,Long> ratingMap){
        String url = "http://localhost:8081/rating/add";
        ResponseEntity<Object> response = restTemplate.postForEntity(url,ratingMap,Object.class);
    }

}
