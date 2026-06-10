package com.Icwd.user.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.Icwd.user.service.entities.Rating;
import com.Icwd.user.service.external.services.RatingService;

@SpringBootTest
class UserServiceApplicationTests {

	@Autowired
	RatingService ratingService ;
	@Test
	void contextLoads() {
	}
	
//	@Test
//	void testPost()
//	{
//		Rating rating = Rating.builder().userId("Demo_user_id").hotelId("Demo_hotel_id").ratingId("Demo-R").feedback("Hypothetical").hotel(null).build();
//		Rating rating1  = ratingService.createRating(rating);
//		System.out.println("Rating is Created");
//		Assertions.assertEqual(rating.getRatingId(),rating1);
//		
//		
//	}

}
