package com.Icwd.RatingService.services;

import java.util.List;

import com.Icwd.RatingService.entities.Rating;

public interface RatingService {

	//create
	public Rating createRating(Rating rating);
	
	//get all rating
	public List<Rating> getAllRating();
	
	//get all the rating based on user_id
	public List<Rating> getAllRatingByUserId(String userId);
	
	//get all the rating based on hotel_id
	public List<Rating> getAllRatingByHotelId(String hotelId);
}
