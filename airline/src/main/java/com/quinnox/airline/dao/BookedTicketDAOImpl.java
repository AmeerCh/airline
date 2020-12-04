package com.quinnox.airline.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.quinnox.airline.dto.BookedTicketDTO;
import com.quinnox.airline.entity.BookedTicket;

@Repository
public class BookedTicketDAOImpl implements BookedTicketDAO{
	
	@Autowired
	private EntityManager manager;

	@Override
	@Transactional
	public boolean bookticket(BookedTicketDTO bookedTicketDTO) {
		BookedTicket ticket = new BookedTicket();
		BeanUtils.copyProperties(bookedTicketDTO, ticket);
		manager.persist(ticket);
		return true;
	}

	@Override
	public List<BookedTicket> purchasedTickets() {
		TypedQuery<BookedTicket> query = manager.createQuery("from BookedTicket", BookedTicket.class);
		return query.getResultList();
	}

	@Override
	@Transactional
	public boolean cancleTicket(int id) {

		BookedTicket ticket = manager.find(BookedTicket.class, id);
		manager.remove(ticket);
		return true;
	}

}
