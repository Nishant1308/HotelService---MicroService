package com.microservice.hotel.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservice.hotel.entity.Hotel;
import com.microservice.hotel.exception.ResourceNotFoundException;
import com.microservice.hotel.repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	private HotelRepository hotelRepository;
	
	@Override
	public Hotel create(Hotel hotel) {
		String randomuserId = UUID.randomUUID().toString();
		hotel.setId(randomuserId);
		return hotelRepository.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		return hotelRepository.findAll();
	}

	@Override
	public Hotel getSingle(String id) {
		return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel not found on server !!"+ id));
	}

}
