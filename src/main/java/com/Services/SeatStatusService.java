package com.Services;

import org.springframework.stereotype.Service;
import com.Entity.SeatStatus;
import com.Entity.Showtimes;

@Service
public interface SeatStatusService {

	public Showtimes add(Showtimes showtimes);

	public SeatStatus save(SeatStatus seatStatus);
}
