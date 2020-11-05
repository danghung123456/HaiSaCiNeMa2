package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Entity.Seat;
import com.Entity.TicketDetail;

@Service
public interface TicketDetailService {
	
	     TicketDetail add(TicketDetail ticketDetail);

	     TicketDetail save(TicketDetail ticketDetail);

}
