package com.icwd.hotelService.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.icwd.hotelService.entities.Hotel;
import com.icwd.hotelService.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelServiceController {

	@Autowired
	HotelService hotelService ;
	
	//create hotel
	@PostMapping()
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.createHotel(hotel));
	}
	//get one Hotel
	@GetMapping("/{hotel_id}")
	public ResponseEntity<Hotel> getOneHotel(@PathVariable String hotel_id)
	{
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getOneHotel(hotel_id));
	}
	
	//get all hotels
	@GetMapping()
	public ResponseEntity<List<Hotel>> getAllHotels()
	{
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAllHotel());
	}
	
}
