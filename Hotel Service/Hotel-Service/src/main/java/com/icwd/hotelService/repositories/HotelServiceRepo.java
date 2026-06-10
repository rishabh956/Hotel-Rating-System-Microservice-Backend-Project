package com.icwd.hotelService.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icwd.hotelService.entities.Hotel;

public interface HotelServiceRepo extends JpaRepository<Hotel,String>{

}
