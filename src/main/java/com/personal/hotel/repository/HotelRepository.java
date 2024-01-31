package com.personal.hotel.repository;

import com.personal.hotel.model.Hotel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface HotelRepository extends JpaRepository<Hotel,Integer> {
}
