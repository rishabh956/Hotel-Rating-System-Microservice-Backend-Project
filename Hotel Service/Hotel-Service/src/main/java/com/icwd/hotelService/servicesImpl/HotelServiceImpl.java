package com.icwd.hotelService.servicesImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icwd.hotelService.entities.Hotel;
import com.icwd.hotelService.exceptions.HotelNotFoundException;
import com.icwd.hotelService.repositories.HotelServiceRepo;
import com.icwd.hotelService.services.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelServiceRepo hotelServiceRepo ;
	@Override
	public Hotel createHotel(Hotel hotel) {
		// TODO Auto-generated method stub
		String id = UUID.randomUUID().toString();
		hotel.setId(id);
		return hotelServiceRepo.save(hotel);
	}

	@Override
	public Hotel getOneHotel(String id) {
		// TODO Auto-generated method stub
		
			Optional<Hotel> hotel = hotelServiceRepo.findById(id) ;
		    if(hotel.isPresent())
		    	return hotel.get();
		    else
		    	throw new HotelNotFoundException("Hotel is not found with given ID ::"+id);
		
	}

	@Override
	public List<Hotel> getAllHotel() {
		// TODO Auto-generated method stub
		return hotelServiceRepo.findAll();
	}

}
