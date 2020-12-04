package com.quinnox.airline.dto;

import java.util.List;

import com.quinnox.airline.entity.Flight;

import lombok.Data;

@Data
public class FlightResponse {
	
	private int statusCode;
	
	private String message;
	
	private String description;
	
	private List<Flight> flight;

}
