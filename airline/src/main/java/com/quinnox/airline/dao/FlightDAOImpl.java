package com.quinnox.airline.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quinnox.airline.dto.FlightDTO;
import com.quinnox.airline.entity.Flight;

@Repository
public class FlightDAOImpl implements FlightDAO{
	
	@Autowired
	private EntityManager manager;

	@Override
	@Transactional
	public boolean addFlight(FlightDTO flight) {
		
		Flight flight2 = new Flight();
		BeanUtils.copyProperties(flight, flight2);
		manager.persist(flight2);		
		return true;
	}

	@Override
	public List<Flight> getAllFlight() {
		
		TypedQuery<Flight> flight= manager.createQuery("from Flight", Flight.class);
		return flight.getResultList();
	}

	@Override
	@Transactional
	public boolean updateFlight(FlightDTO flight) {
		
		Flight flight2 = manager.find(Flight.class, flight.getFlightId());
		BeanUtils.copyProperties(flight, flight2);
		return true;
	}

	@Override
	@Transactional
	public boolean deleteFlight(int id) {
		
		Flight flight = manager.find(Flight.class, id);
		manager.remove(flight);
		return true;
	}

	@Override
	public List<Flight> searchFlight(String source, String destination, String flightDay) {
	  TypedQuery<Flight> query	= manager.createQuery("select F from Flight F where F.source=?1 and F.destination=?2 and F.flightDay=?3", Flight.class);
		query.setParameter(1, source);
		query.setParameter(2, destination);
		query.setParameter(3, flightDay);
		
	  return query.getResultList();
	}

}
