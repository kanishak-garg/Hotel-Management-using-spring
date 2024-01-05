package com.personal.hotel.communicator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
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
//        ResponseEntity<Object> response = restTemplate.postForEntity(url,ratingMap,Object.class);
        HttpEntity<Map<String,Long>> requestEntity = new HttpEntity<>(ratingMap);
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.POST,requestEntity,Object.class);
    }

    public void updateRating(Map<String, Long> ratingMap) {
        String url = "http://localhost:8081/rating/update";
        HttpEntity<Map<String,Long>> requestEntity = new HttpEntity<>(ratingMap);
        ResponseEntity<Object> response = restTemplate.exchange(url, HttpMethod.PUT,requestEntity,Object.class);
    }
    public void deleteRating(String id) {
        String url = "http://localhost:8081/rating/id/";
        ResponseEntity<Object> response = restTemplate.exchange(url+id, HttpMethod.DELETE,null,Object.class);
    }


}
