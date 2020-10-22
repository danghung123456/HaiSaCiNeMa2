package com.Services;


import org.springframework.stereotype.Service;

import com.Entity.Ticket;

@Service
public interface TicketService {
	
	    public Ticket add(Ticket ticket);

	    public Ticket save(Ticket ticket);
}
