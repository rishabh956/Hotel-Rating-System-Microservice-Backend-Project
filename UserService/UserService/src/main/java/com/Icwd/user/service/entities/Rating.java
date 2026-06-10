package com.Icwd.user.service.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Rating {
	
	private String userId ;
	private String hotelId;
	private String ratingId;
	private int rating ;
	private String feedback ;
	private Hotel hotel;

}
