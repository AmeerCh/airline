package com.quinnox.airline.dto;

import lombok.Data;

@Data
public class FlightDTO {
	
	private int flightId;

	private String source;
	
	private String destination;
	
	private String takeOffTime;
	
	private String arivalTime;
	
	private String priceOfFlight;
	
	private String flightDay;

}
