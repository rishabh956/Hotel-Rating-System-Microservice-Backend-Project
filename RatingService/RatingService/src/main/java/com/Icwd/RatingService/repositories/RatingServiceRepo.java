package com.Icwd.RatingService.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.Icwd.RatingService.entities.Rating;

public interface RatingServiceRepo  extends MongoRepository<Rating,String> {

	//get rating by userId
	public List<Rating> findByUserId(String userId);
	
	//get rating By hotelId
	public List<Rating> findByHotelId(String hotelId);
}
