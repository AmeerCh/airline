package com.quinnox.airline.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class BookedTicket {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ticketId;
	
	private int customerId;
	
	private int flightId;
	
	private String source;
	
	private String destination;
	
	private String dateOfBooking;
	
	private String takeOffTime;
	
	private String arivalTime;
	
	

}
