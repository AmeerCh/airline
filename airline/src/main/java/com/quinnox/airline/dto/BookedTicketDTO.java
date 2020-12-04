package com.quinnox.airline.dto;

import lombok.Data;

@Data
public class BookedTicketDTO {
	
	private int ticketId;
	
	private int customerId;
	
	private int flightId;
	
	private String source;
	
	private String destination;
	
	private String dateOfBooking;
	
	private String takeOffTime;
	
	private String arivalTime;
	

}
