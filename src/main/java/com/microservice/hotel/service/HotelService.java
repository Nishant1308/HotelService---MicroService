package com.microservice.hotel.service;

import java.util.List;

import com.microservice.hotel.entity.Hotel;

public interface HotelService {

	//create hotel
	Hotel create(Hotel hotel);
	
	//get all hotels
	List<Hotel> getAll();
	
	//get single hotel
	Hotel getSingle(String id);
}
