package com.icwd.hotelService.services;

import java.util.List;

import com.icwd.hotelService.entities.Hotel;

public interface HotelService {
	
	//create 
	public Hotel createHotel(Hotel hotel) ;
	
	// get one hotel
	public Hotel getOneHotel(String id);
	
	//get all the hotel details
	public List<Hotel> getAllHotel() ;

}
