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
        List<Hotel> hotelList = hotelRepository.findAll();
        return hotelList;
//        List<HotelDTO> hotelDtoList = new ArrayList<>();
//        hotelList.forEach(hotel -> hotelDtoList.add(hotelMapper.convertHotelEntityToDto(hotel)));
//        System.out.println(hotelRepository);
//        return hotelDtoList;
    }

    public void deleteHotelById(int id) {
        hotelRepository.deleteById(id);
    }

    public void updateHotel(HotelDTO hotelDto) {
//        Hotel hotel = hotelMapper.convertHotelDtoToEntity(hotelDto);
//        Hotel hotelDB = hotelRepository.findOne(hotel).get();
//        hotelRepository.save(hotel);
    }

    public void updateHotelById(int id, HotelDTO hotelDto) {
//        Hotel hotelDB = hotelRepository.findById(id).get();
//        Hotel hotel = hotelMapper.convertHotelDtoToEntity(hotelDto);
//        hotelDB.setName(hotel.getName());
//        hotelRepository.save(hotel);
    }
}
