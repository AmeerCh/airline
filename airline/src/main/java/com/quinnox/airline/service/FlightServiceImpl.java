package com.quinnox.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.airline.dao.FlightDAO;
import com.quinnox.airline.dto.FlightDTO;
import com.quinnox.airline.entity.Flight;

@Service
public class FlightServiceImpl implements FlightService{
	
	@Autowired
	private FlightDAO dao;

	@Override
	public boolean addFlight(FlightDTO flight) {
		
		
		if(dao.addFlight(flight)) {
			return true;
		}
		return false;
	}

	@Override
	public List<Flight> getAllFlight() {

		return dao.getAllFlight();
	}

	@Override
	public boolean updateFlight(FlightDTO flight) {
		
		dao.updateFlight(flight);
		return true;
	}

	@Override
	public boolean deleteFlight(int id) {
		dao.deleteFlight(id);
		return true;
	}

	@Override
	public List<Flight> searchFlight(String source, String destination, String flightDay) {
		List<Flight> flight = dao.searchFlight(source, destination, flightDay);
		if(flight != null) {
			return flight;
		}
		else {
			return null;
		}
	}

}
