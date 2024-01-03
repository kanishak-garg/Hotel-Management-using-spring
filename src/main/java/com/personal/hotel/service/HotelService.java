package com.personal.hotel.service;

import com.personal.hotel.model.Hotel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelService {

    List<Hotel> hotelList = new ArrayList<>();
    Map<String,Hotel> hotelMap = new HashMap<>();

    public void createHotel(Hotel hotel){
        hotelList.add(hotel);
        hotelMap.put(hotel.getId(),hotel);
    }

}
