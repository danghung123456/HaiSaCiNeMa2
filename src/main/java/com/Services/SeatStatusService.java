package com.Services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Entity.Seat;
import com.Entity.SeatStatus;
import com.Entity.Showtimes;

@Service
public interface SeatStatusService {

	public Showtimes add(Showtimes showtimes);

	public SeatStatus save(SeatStatus seatStatus);

	public Optional<SeatStatus> findById(Integer seatStatusId);
}
