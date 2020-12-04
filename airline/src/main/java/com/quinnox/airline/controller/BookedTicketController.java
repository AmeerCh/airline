package com.quinnox.airline.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.quinnox.airline.dto.BookedTicketDTO;
import com.quinnox.airline.dto.BookedTicketResponse;
import com.quinnox.airline.entity.BookedTicket;
import com.quinnox.airline.service.BookedTicketService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class BookedTicketController {
	
	@Autowired
	private BookedTicketService service;
	
	@PostMapping("/ticket-booking")
	public BookedTicketResponse bookTicket(@RequestBody BookedTicketDTO bookedTicketDTO) {
		
		BookedTicketResponse response = new BookedTicketResponse();
		
		if(service.bookticket(bookedTicketDTO)) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription("Ticket is booked.");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("Ticket is not booked.");
		}
		return response;
	}
	
	@GetMapping("/all-booked-tickets")
	public BookedTicketResponse purchasedTickets() {
		
		BookedTicketResponse response = new BookedTicketResponse();
		List<BookedTicket> bookedTicket = service.purchasedTickets();
		
		if(service.purchasedTickets().size() != 0) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription("Booked tickets retrived succssfully.");
			response.setBookedTicket(bookedTicket);
		}
		else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("Booked tickets retrived failed.");
		}
		return response;
	}
	
	@DeleteMapping("/cancle-booked-ticket/{ticketId}")
	public BookedTicketResponse cancleTicket(@PathVariable("ticketId") int ticketId) {
		
		BookedTicketResponse response = new BookedTicketResponse();
		
		if(service.cancleTicket(ticketId)) {
			response.setStatusCode(200);
			response.setMessage("success");
			response.setDescription("ticket cancled successfully.");
		}
		else {
			response.setStatusCode(401);
			response.setMessage("failed");
			response.setDescription("ticket cancellation failed");
		}
		return response;
	}

}
  