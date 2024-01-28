package com.personal.hotel.service;

import com.personal.hotel.communicator.RatingServiceCommunicator;
import com.personal.hotel.dto.HotelDTO;
import com.personal.hotel.exceptions.HotelNotFoundException;
import com.personal.hotel.mapper.HotelMapper;
import com.personal.hotel.model.Hotel;
import com.personal.hotel.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class HotelService {

    @Autowired
    HotelMapper hotelMapper;

    @Autowired
    HotelRepository hotelRepository;

    public void createHotel(HotelDTO hotelDto){
        Hotel hotel = hotelMapper.convertHotelDtoToEntity(hotelDto);
        hotelRepository.save(hotel);
    }

    public HotelDTO getHotelById(int id) {
        Hotel hotel = hotelRepository.findById(id).get();
        return hotelMapper.convertHotelEntityToDto(hotel);

    }

    public List<Hotel> getAllHotels() {
        return hotelList;
    }

    public void deleteHotelById(int id) {
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

    public void updateHotelById(int id, Hote hotelDto) {
        if(hotelMap.containsKey(hotel.getId())) {
            Hotel hotelInDb = hotelMap.get(id);
            hotelList.remove(hotelInDb);
            hotel.setId(id);
            hotelMap.put(id, hotel);
            hotelList.add(hotel);
        }
    }
}
