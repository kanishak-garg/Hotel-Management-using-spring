package com.personal.hotel.mapper;

import com.personal.hotel.dto.HotelDTO;
import com.personal.hotel.model.Hotel;

public class HotelMapper {

    public Hotel convertHotelDtoToEntity(HotelDTO hotelDTO){
        Hotel hotel = new Hotel();
        hotel.setRating(hotelDTO.getRating());
        hotel.setCity(hotelDTO.getCity());
        hotel.setName(hotelDTO.getName());
        return hotel;
    }

    public HotelDTO convertHotelEntityToDto(Hotel hotel){
        HotelDTO hotelDTO = new HotelDTO();
        hotelDTO.setRating(hotel.getRating());
        hotelDTO.setCity(hotel.getCity());
        hotelDTO.setName(hotel.getName());
        return hotelDTO;
    }


}
