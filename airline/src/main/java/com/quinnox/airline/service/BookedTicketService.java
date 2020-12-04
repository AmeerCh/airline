package com.quinnox.airline.service;

import java.util.List;

import com.quinnox.airline.dto.BookedTicketDTO;
import com.quinnox.airline.entity.BookedTicket;

public interface BookedTicketService {
	
	public boolean bookticket(BookedTicketDTO bookedTicketDTO);
	
	public List<BookedTicket> purchasedTickets();
	
	public boolean cancleTicket(int id);

}
