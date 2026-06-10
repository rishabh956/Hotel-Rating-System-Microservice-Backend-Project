package com.icwd.hotelService.exceptions;

public class HotelNotFoundException extends RuntimeException{
	
	public HotelNotFoundException()
	{
		super();
	}
	
	public HotelNotFoundException(String s)
	{
		super(s);
	}

}
