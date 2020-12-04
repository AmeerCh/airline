package com.quinnox.airline.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.quinnox.airline.dto.BookedTicketDTO;
import com.quinnox.airline.entity.BookedTicket;

@Repository
public interface BookedTicketDAO {
	
	public boolean bookticket(BookedTicketDTO bookedTicketDTO);
	
	public List<BookedTicket> purchasedTickets();
	
	public boolean cancleTicket(int id);

}
