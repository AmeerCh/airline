package com.quinnox.airline.service;

import java.util.List;

import com.quinnox.airline.dto.FlightDTO;
import com.quinnox.airline.entity.Flight;

public interface FlightService {
	
public boolean addFlight(FlightDTO flight);
	
	public List<Flight> getAllFlight();
	
	public boolean updateFlight(FlightDTO flight);
	
	public boolean deleteFlight(int id);
	
	public List<Flight> searchFlight(String source, String destination, String flightDay);


}
