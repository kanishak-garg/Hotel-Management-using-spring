package com.personal.hotel.controller;

import com.personal.hotel.exceptions.BadRequestException;
import com.personal.hotel.model.Hotel;
import com.personal.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.nio.file.Path;
import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    HotelService hotelService;

    @PostMapping("/create")
    public void createHotel(@Valid @RequestBody Hotel hotel, BindingResult bindingResult) throws BadRequestException {
        if(bindingResult.hasErrors()){
            throw new BadRequestException("The Request is Invalid:\\n hotel name should be min 3 char\\nrating should be 1 to 10");
        }
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

    @PutMapping("/update")
    public void updateHotel(@RequestBody Hotel hotel){
        hotelService.updateHotel(hotel);
    }

    @PutMapping("/update/id/{id}")
    public void updateHotelById(@PathVariable String id,@RequestBody Hotel hotel){
        hotelService.updateHotelById(id,hotel);
    }


}
