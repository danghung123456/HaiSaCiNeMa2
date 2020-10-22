package com.Services;


import org.springframework.stereotype.Service;
import com.Entity.TicketDetail;



@Service
public interface TicketDetailService {
	
	    public TicketDetail add(TicketDetail ticketDetail);

	    public TicketDetail save(TicketDetail ticketDetail);
}
