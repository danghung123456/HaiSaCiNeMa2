package com.Services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.Entity.SeatStatus;
import com.Repository.SeatStatusRepository;
import com.Services.SeatStatusService;

@Service
public class SeatStatusServiceImpl implements SeatStatusService {
	@Autowired
	SeatStatusRepository repository;

	@Override
	public SeatStatus add(SeatStatus seatStatus) {
		return repository.save(seatStatus);
	}

	@Override
	public SeatStatus save(SeatStatus seatStatus) {
		return repository.saveAndFlush(seatStatus);
	}

}
