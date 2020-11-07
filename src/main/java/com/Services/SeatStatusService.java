package com.Services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.Entity.SeatStatus;
import com.Entity.Showtimes;

@Service
public interface SeatStatusService {

	Showtimes add(Showtimes showtimes);

	SeatStatus save(SeatStatus seatStatus);

	Optional<SeatStatus> findById(Integer seatStatusId);
}
