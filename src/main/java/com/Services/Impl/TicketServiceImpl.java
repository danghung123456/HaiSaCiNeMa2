package com.Services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.DTO.TicketDTO;
import com.DTO.view.TicketByMovieView;
import com.DTO.view.TicketByShowtimeView;
import com.Entity.Member;
import com.Entity.Showtimes;
import com.Entity.Ticket;
import com.Repository.MemberRepository;
import com.Repository.ShowtimesRepository;
import com.Repository.TicketRepository;
import com.Services.TicketService;

@Service
public class TicketServiceImpl implements TicketService {
	
	@Autowired
	TicketRepository repository;
	@Autowired
	MemberRepository memberRepository;
	@Autowired
	ShowtimesRepository showtimesRepository;

	@Override
	public Ticket add(Ticket ticket) {
		return repository.save(ticket);
	}

	@Override
	public Ticket save(Ticket ticket) {
		return repository.save(ticket);
	}

	@Override
	public Ticket findTicketByCode(String code) {
		return repository.findTicketByCode(code);
	}

	@Override
	public Ticket converToTicket(TicketDTO ticketDTO) {
		Showtimes showtimes = showtimesRepository.findById(ticketDTO.getShowtimeId()).orElse(null);
		Member member = memberRepository.findById(ticketDTO.getMemberId()).orElse(null);
		Ticket ticket = new Ticket();
		ticket.setShowtimes(showtimes);
		ticket.setMember(member);
		ticket.setTicketQuantity(ticketDTO.getTicketQuantity());
		ticket.setTicketPriceAmount(ticketDTO.getTicketPriceAmount());
		ticket.setCode(ticketDTO.getCode());
		ticket.setTotal(ticketDTO.getTotal());
		return ticket;
	}

	@Override
	public Optional<Ticket> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public List<Ticket> getAll() {
		return repository.findAll();
	}


}
