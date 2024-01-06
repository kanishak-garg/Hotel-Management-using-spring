package com.personal.hotel.communicator;

import com.personal.hotel.exceptions.HttpRatingServiceNotFound;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
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
//        ResponseEntity<Long> response = restTemplate.getForEntity(url+id,Long.class);
        ResponseEntity<Long> response = restTemplate.exchange(url + id, HttpMethod.GET, null, Long.class);
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
        String url = "http://localhost:8081/rating/remove/id/";
        try{
            ResponseEntity<Object> response = restTemplate.exchange(url+id, HttpMethod.DELETE,null,Object.class);
        }catch (HttpClientErrorException e){
            throw new HttpRatingServiceNotFound(HttpStatusCode.valueOf(HttpStatus.NOT_FOUND.value()));
        }
    }


}
