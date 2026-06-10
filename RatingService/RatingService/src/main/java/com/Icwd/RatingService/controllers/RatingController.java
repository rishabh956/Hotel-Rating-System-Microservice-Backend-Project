package com.Icwd.RatingService.controllers;

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

import com.Icwd.RatingService.entities.Rating;
import com.Icwd.RatingService.services.RatingService;

@RestController
@RequestMapping("/rating")
public class RatingController {
	
	@Autowired
	RatingService ratingService ;
	
	//create
	@PostMapping
	public ResponseEntity<Rating> createRating(@RequestBody Rating rating)
	{
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
	}
	//get all rating
	@GetMapping
	public ResponseEntity<List<Rating>> getAllRating()
	{
		return ResponseEntity.ok(ratingService.getAllRating());
	}
	
	//get all rating by user id
	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Rating>> getAllratingByUserId(@PathVariable String userId)
	{
		return ResponseEntity.ok(ratingService.getAllRatingByUserId(userId));
	}
	
	//get all rating by hotel id
	@GetMapping("/hotel/{hotelId}")
	public ResponseEntity<List<Rating>> getAllratingByHotelId(@PathVariable String hotelId)
	{
		return ResponseEntity.ok(ratingService.getAllRatingByHotelId(hotelId));
	}

}
