package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Seat;
import com.Entity.SeatStatus;
import com.Entity.Showtimes;
import com.Repository.SeatStatusRepository;
import com.Repository.ShomtimesRepository;
import com.Services.SeatStatusService;

@Service
public class SeatStatusServiceImpl implements SeatStatusService {
	@Autowired
	SeatStatusRepository repository;
	@Autowired
	ShomtimesRepository ShowtimesRepository;

	@Override
	public Showtimes add(Showtimes showtimes) {
		// roomID = > findById => listSeat 
		List<Seat> seatList = showtimes.getRoom().getSeat();
		List<SeatStatus> list = new ArrayList<SeatStatus>();
		for(Seat seat : seatList) {
			SeatStatus seatStatus = new SeatStatus();
			seatStatus.setShowtimes(showtimes);
			seatStatus.setSeat(seat);
			seatStatus.setStatus(false);
			repository.save(seatStatus);
		}
		return ShowtimesRepository.findByShowtimesId(showtimes.getShowtimeId()).get();
	}

	@Override
	public SeatStatus save(SeatStatus seatStatus) {
		return repository.saveAndFlush(seatStatus);
	}

}
