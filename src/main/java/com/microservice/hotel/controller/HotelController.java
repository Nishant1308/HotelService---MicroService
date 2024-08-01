package com.microservice.hotel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.hotel.entity.Hotel;
import com.microservice.hotel.service.HotelService;

@RestController
@RequestMapping("/hotel")
public class HotelController {

	@Autowired
	private HotelService hotelService;
	
	@PostMapping("/addHotel")
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel h){
		Hotel hotel = hotelService.create(h);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotel);
	}
	
	@GetMapping("/getHotel/{id}")
	public ResponseEntity<Hotel> getSingleHotel(@PathVariable("id") String id){
		Hotel hotel = hotelService.getSingle(id);
		return ResponseEntity.ok(hotel);
	}
	
	@GetMapping("/getHotels")
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> hotel = hotelService.getAll();
		return ResponseEntity.ok(hotel);
	}
}
