package com.personal.hotel.controller;

import com.personal.hotel.model.Hotel;
import com.personal.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/hotel")
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

    @GetMapping("/getAll")
    public List<Hotel> getALlHotels(){
        return hotelService.getAllHotels();
    }

    @DeleteMapping("/remove/id/{id}")
    public void deleteHotelById(@PathVariable String id){
        hotelService.deleteHotelById(id);
    }

}
