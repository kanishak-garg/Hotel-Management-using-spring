package com.personal.hotel.controller;

import com.personal.hotel.model.Hotel;
import com.personal.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping("/create")
    public void createHotel(@RequestBody Hotel hotel){
        hotelService.createHotel(hotel);
    }

    @GetMapping("/id/{id}")
    public Hotel getHotelById(@PathVariable String id){
        return hotelService.getHotelById(id);
    }
}
