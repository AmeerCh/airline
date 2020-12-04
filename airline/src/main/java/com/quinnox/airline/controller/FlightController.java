package com.quinnox.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.airline.dto.FlightDTO;
import com.quinnox.airline.dto.FlightResponse;
import com.quinnox.airline.entity.Flight;
import com.quinnox.airline.service.FlightService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FlightController {
	
	@Autowired
	private FlightService service;
	
	@PostMapping("/add-flight")
	public FlightResponse addFlight(@RequestBody FlightDTO flight)
	{
		FlightResponse response = new FlightResponse();
		
		if(service.addFlight(flight))
		{
			response.setStatusCode(200);
			response.setMessage("Flight schedule added successfylly.");
			response.setDescription("Flight added.");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Flight schedule not added.");
			response.setDescription("Flight not added.");
		}
		
		return response;	
	}
	
	@GetMapping("/flights")
	public FlightResponse getAllFlight() {
		
		FlightResponse response = new FlightResponse();
		
		List<Flight> flight=service.getAllFlight();
		
		if(flight.size() != 0) {
			response.setStatusCode(200);
			response.setMessage("Flight details reteived successfully");
			response.setDescription("Getting Success");
			response.setFlight(flight);
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Flight details reteived failed");
			response.setDescription("Getting failed");
		}
		return response;
	}
	
	@DeleteMapping("/delete-flight/{flightId}")
	public FlightResponse deleteFlight(@PathVariable("flightId") int id) {
		
		FlightResponse response = new FlightResponse();
		if(service.deleteFlight(id)) {
			response.setStatusCode(200);
			response.setMessage("Flight deleted successfully");
			response.setDescription("Deleted Success");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Flight not deleted.");
			response.setDescription("Deletion Failed.");
		}
		return response;
	}
	
	@PutMapping("/update-flight")
	public FlightResponse updateFlight(@RequestBody FlightDTO flight){
		
		FlightResponse response = new FlightResponse();
		if(service.updateFlight(flight)) {
			response.setStatusCode(200);
			response.setMessage("Flight updated successfully");
			response.setDescription("updated Success");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Flight not updated.");
			response.setDescription("updation Failed.");
		}
		return response;
		
	}
	
	@GetMapping("/search-flight/{source}/{destination}/{flightDay}")
	public FlightResponse searchFlight(@PathVariable String source, @PathVariable String destination, @PathVariable String flightDay) {
		FlightResponse response = new FlightResponse();
		List<Flight> flight=service.searchFlight(source, destination, flightDay);
		if(flight.size() != 0) {
			response.setStatusCode(200);
			response.setMessage("Flight gettting successfully");
			response.setDescription("getiing Success");
			response.setFlight(flight);
		}
		else {
			response.setStatusCode(401);
			response.setMessage("Flight gettting failed");
			response.setDescription("getiing failed");
		}
		return response;
		
	}

}
