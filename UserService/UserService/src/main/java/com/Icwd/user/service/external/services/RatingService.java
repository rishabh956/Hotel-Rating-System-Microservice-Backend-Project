package com.Icwd.user.service.external.services;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.Icwd.user.service.entities.Rating;


@Service
@FeignClient( name = "RATINGSERVICE")
public interface RatingService {
	
	@GetMapping("/rating/user/{userId}")
	List<Rating> getRatings(@PathVariable String userId);
	
	//create rating
	
	@PostMapping("/rating")
	Rating createRating(Rating rating);

}
