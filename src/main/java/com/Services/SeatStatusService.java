package com.Services;

import org.springframework.stereotype.Service;
import com.Entity.SeatStatus;

@Service
public interface SeatStatusService {

	public SeatStatus add(SeatStatus seatStatus);

	public SeatStatus save(SeatStatus seatStatus);
}
