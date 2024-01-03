package com.personal.hotel.controller;

import com.personal.hotel.model.Hotel;
import com.personal.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping("/create")
    public void createHotel(Hotel hotel){
        hotelService.createHotel(hotel);
    }
}
