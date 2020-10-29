package com.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Entity.Ticket;
import com.Repository.TicketRepository;
import com.Services.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	@Autowired
	TicketRepository repository;

	@Override
	public Ticket add(Ticket ticket) {
		return repository.save(ticket);
	}

	@Override
	public Ticket save(Ticket ticket) {
		return repository.saveAndFlush(ticket);
	}

}
