package com.Icwd.user.service.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.Icwd.user.service.entities.Hotel;
import com.Icwd.user.service.entities.Rating;
import com.Icwd.user.service.entities.User;
import com.Icwd.user.service.exceptions.ResourceNotFoundException;
import com.Icwd.user.service.external.services.HotelService;
import com.Icwd.user.service.external.services.RatingService;
import com.Icwd.user.service.repositories.UserServiceRepo;
import com.Icwd.user.service.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserServiceRepo userServiceRepo ;
	
	@Autowired
	RestTemplate restTemplate ;
	
	@Autowired
	HotelService hotelService ;
	
	@Autowired
	RatingService ratingService;
	
	@Override
	public User saveUser(User user) {
		// TODO Auto-generated method stub
		String id = UUID.randomUUID().toString();
		user.setUserId(id);
		return userServiceRepo.save(user);
	}

	@Override
	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		//restTemplate.getForObject("http://localhost:8083/rating/user/"+u.getUserId(), ArrayList.class)
		List<User> listOfUsers =  userServiceRepo.findAll() ;
		listOfUsers.stream().map(user -> {
			
			//call rating service
			//call hotel service
			//set hotel to rating
			//set rating to user
			
			//Rating[] rList = restTemplate.getForObject("http://localhost:8083/rating/user/"+user.getUserId(), Rating[].class);
			List<Rating> ratingList = ratingService.getRatings(user.getUserId());
			//List<Rating> ratingList = Arrays.asList(rList);
			ratingList.stream().map( rating -> {
				
				//Hotel hotel = restTemplate.getForObject("http://localhost:8082/hotels/"+rating.getHotelId(), Hotel.class);
				Hotel hotel = hotelService.getHotel(rating.getHotelId());
				rating.setHotel(hotel);
				return rating ;
			}).collect(Collectors.toList());
			user.setRatings(ratingList);
			return user ;
		}).collect(Collectors.toList());
		return listOfUsers ;
	}

	@Override
	@Cacheable(value="user-cache",key="#userId")
	public User getUserById(String userId) {
		// TODO Auto-generated method stub
		Optional<User> user = userServiceRepo.findById(userId) ;
		if(user.isPresent())
		{
			//http://localhost:8083/rating/user/41bda9d9-646d-43f5-8359-0735fafbe53e
			//Rating[] listOfRatings=restTemplate.getForObject("http://RATINGSERVICE/rating/user/"+userId, Rating[].class);
			//http://localhost:8082/hotels/dcdcc8b5-fa0f-4331-922c-ddb594d31dcb
			//List<Rating> list = Arrays.stream(listOfRatings).toList() ;
			List<Rating> list = ratingService.getRatings(userId);
			list.stream().map(rating ->{
				// call the hotel api
				//set the hotel details
				//Hotel hotel = restTemplate.getForObject("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
				Hotel hotel = hotelService.getHotel(rating.getHotelId());
				rating.setHotel(hotel);
				return rating;
			}).collect(Collectors.toList());
			
			user.get().setRatings(list);
			return user.get() ;
		}	
		else
			throw new ResourceNotFoundException("The given Id is not present");
	}

}
