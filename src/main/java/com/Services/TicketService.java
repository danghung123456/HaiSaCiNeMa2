package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.DTO.TicketDTO;
import com.DTO.view.TicketByMovieView;
import com.DTO.view.TicketByShowtimeView;
import com.Entity.Ticket;

@Service
public interface TicketService {

	List<Ticket> getAll();

	Ticket add(Ticket ticket);

	Ticket save(Ticket ticket);

	Ticket findTicketByCode(String code);

	Optional<Ticket> findById(Integer id);

	Ticket converToTicket(TicketDTO ticketDTO);
}
