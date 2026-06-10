package com.Icwd.RatingService.servicesImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Icwd.RatingService.entities.Rating;
import com.Icwd.RatingService.repositories.RatingServiceRepo;
import com.Icwd.RatingService.services.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	RatingServiceRepo ratingServiceRepo ;
	
	@Override
	public Rating createRating(Rating rating) {
		// TODO Auto-generated method stub
		return ratingServiceRepo.save(rating);
	}

	@Override
	public List<Rating> getAllRating() {
		// TODO Auto-generated method stub
		return ratingServiceRepo.findAll();
	}

	@Override
	public List<Rating> getAllRatingByUserId(String userId) {
		// TODO Auto-generated method stub
		return this.ratingServiceRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getAllRatingByHotelId(String hotelId) {
		// TODO Auto-generated method stub
		return this.ratingServiceRepo.findByHotelId(hotelId);
	}

}
