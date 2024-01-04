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

    public Hotel getHotelById(String id) {
        return hotelMap.get(id);
    }

    public List<Hotel> getAllHotels() {
        return hotelList;
    }

    public void deleteHotelById(String id) {
        if(hotelMap.containsKey(id)){
            Hotel hotel = getHotelById(id);
            hotelList.remove(hotel);
            hotelMap.remove(id);
        }
        return;
    }

    public void updateHotel(Hotel hotel) {
        if(hotelMap.containsKey(hotel.getId())){
            Hotel hotelInDb = hotelMap.get(hotel.getId());
            hotelList.remove(hotelInDb);
            hotelMap.put(hotel.getId(),hotel);
            hotelList.add(hotel);
        }
    }
}
