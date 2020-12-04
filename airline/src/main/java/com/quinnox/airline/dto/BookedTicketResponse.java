package com.quinnox.airline.dto;

import java.util.List;

import com.quinnox.airline.entity.BookedTicket;

import lombok.Data;

@Data
public class BookedTicketResponse {
	
	private int statusCode;
	
	private String message;
	
	private String description;
	
	private List<BookedTicket> bookedTicket;

}
