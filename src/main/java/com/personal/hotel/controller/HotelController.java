package com.personal.hotel.controller;

import com.personal.hotel.model.Hotel;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HotelController {

    @PostMapping("/create")
    public void createHotel(Hotel hotel){

    }
}
