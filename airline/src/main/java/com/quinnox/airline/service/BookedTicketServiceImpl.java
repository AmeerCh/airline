package com.quinnox.airline.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.quinnox.airline.dao.BookedTicketDAO;
import com.quinnox.airline.dto.BookedTicketDTO;
import com.quinnox.airline.entity.BookedTicket;

@Service
public class BookedTicketServiceImpl implements BookedTicketService{
	
	@Autowired
	private BookedTicketDAO dao;

	@Override
	public boolean bookticket(BookedTicketDTO bookedTicketDTO) {
		if(dao.bookticket(bookedTicketDTO)) {
			return true;
		}
		return false;
	}

	@Override
	public List<BookedTicket> purchasedTickets() {
		return dao.purchasedTickets();
	}

	@Override
	public boolean cancleTicket(int id) {
		dao.cancleTicket(id);
		return true;
	}

}
