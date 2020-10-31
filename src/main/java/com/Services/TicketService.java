package com.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.DTO.TicketDTO;
import com.Entity.Showtimes;
import com.Entity.Ticket;

@Service
public interface TicketService {
	
	    Ticket add(Ticket ticket);

	    Ticket save(Ticket ticket);
	    
	    Ticket findTicketByCode(String code);
	    
	    Optional<Ticket> findById(Integer id);
	    
	    Ticket converToTicket(TicketDTO ticketDTO);
}
