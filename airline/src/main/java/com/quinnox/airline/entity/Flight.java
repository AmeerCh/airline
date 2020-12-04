package com.quinnox.airline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Flight {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int flightId;

	private String source;
	
	private String destination;
	
	private String takeOffTime;
	
	private String arivalTime;
	
	private String priceOfFlight;
	
	private String flightDay;
	
	

}
