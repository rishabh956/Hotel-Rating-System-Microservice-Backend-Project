package com.icwd.hotelService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.icwd.hotelService.payloads.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(HotelNotFoundException.class)
	public ResponseEntity<ApiResponse> handleHotelNotFound(HotelNotFoundException ex)
	{
		String message = ex.getMessage();
		ApiResponse apiresponse = ApiResponse.builder().message(message).success(false).status(HttpStatus.NOT_FOUND).build();
		return  new ResponseEntity<>(apiresponse,HttpStatus.NOT_FOUND);
	}

}
