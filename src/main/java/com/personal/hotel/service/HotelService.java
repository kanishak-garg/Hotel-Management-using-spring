package com.personal.hotel.service;

import com.personal.hotel.communicator.RatingServiceCommunicator;
import com.personal.hotel.exceptions.HotelNotFoundException;
import com.personal.hotel.model.Hotel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelService {
    List<Hotel> hotelList = new ArrayList<>();
    Map<String,Hotel> hotelMap = new HashMap<>();

    @Autowired
    RatingServiceCommunicator ratingServiceCommunicator;

    public void createHotel(Hotel hotel){
        if(hotelMap.containsKey(hotel.getId())){
            return;
        }
        hotelList.add(hotel);
        hotelMap.put(hotel.getId(),hotel);

        Map<String,Long> ratingMap= new HashMap<String,Long>();
        ratingMap.put(hotel.getId(),hotel.getRating());
        ratingServiceCommunicator.addRating(ratingMap);
    }

    public Hotel getHotelById(String id) {
        if(ObjectUtils.isEmpty(hotelMap.get(id))){
            throw new HotelNotFoundException("hotel not found with id: " + id);
        }
        Hotel hotel = hotelMap.get(id);
        hotel.setRating(ratingServiceCommunicator.getRating(id));
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
            ratingServiceCommunicator.deleteRating(id);
        }
        return;
    }

    public void updateHotel(Hotel hotel) {
        if(hotelMap.containsKey(hotel.getId())){
            Hotel hotelInDb = hotelMap.get(hotel.getId());
            if(hotel.getRating() != hotelInDb.getRating()){
                Map<String,Long> ratingMap= new HashMap<String,Long>();
                ratingMap.put(hotel.getId(),hotel.getRating());
                ratingServiceCommunicator.updateRating(ratingMap);
            }
            hotelList.remove(hotelInDb);
            hotelMap.put(hotel.getId(),hotel);
            hotelList.add(hotel);
        }
    }

    public void updateHotelById(String id, Hotel hotel) {
        if(hotelMap.containsKey(hotel.getId())) {
            Hotel hotelInDb = hotelMap.get(id);
            hotelList.remove(hotelInDb);
            hotel.setId(id);
            hotelMap.put(id, hotel);
            hotelList.add(hotel);
        }
    }
}
