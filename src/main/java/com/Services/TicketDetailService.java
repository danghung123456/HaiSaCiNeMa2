package com.Services;


import org.springframework.stereotype.Service;
import com.Entity.TicketDetail;

@Service
public interface TicketDetailService {
	
	     TicketDetail add(TicketDetail ticketDetail);

	     TicketDetail save(TicketDetail ticketDetail);
}
