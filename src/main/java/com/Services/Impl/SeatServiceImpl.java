package com.Services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Entity.Seat;
import com.Repository.SeatRepository;
import com.Services.SeatService;

@Service
public class SeatServiceImpl implements SeatService {
<<<<<<< HEAD
//	@Autowired
//	SeatRepository repository;
//
//	@Override
//	public Page<Seat> findAll(Pageable pageable) {
//		// TODO Auto-generated method stub
//		return repository.findAll(pageable);
//	}
//
//	@Override
//	public List<Seat> findAll() {
//		// TODO Auto-generated method stub
//		return repository.findAll();
//	}
//
//	@Override
//	public Seat save(Seat seat) {
//		// TODO Auto-generated method stub
//		return repository.save(seat);
//	}
//
//	@Override
//	public List<Seat> findByName(String name) {
//		// TODO Auto-generated method stub
//		return repository.findByName(name);
//	}
//
//	@Override
//	public Optional<Seat> findById(Integer id) {
//		// TODO Auto-generated method stub
//		return repository.findById(id);
//	}
=======
	@Autowired
	SeatRepository repository;

	@Override
	public Page<Seat> findAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return repository.findAll(pageable);
	}

	@Override
	public List<Seat> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Seat save(Seat seat) {
		// TODO Auto-generated method stub
		return repository.save(seat);
	}

	@Override
	public List<Seat> findByName(String name) {
		// TODO Auto-generated method stub
		return repository.findBySeatName(name);
	}

	@Override
	public Optional<Seat> findById(Integer id) {
		// TODO Auto-generated method stub
		return repository.findBySeatId(id);
	}
>>>>>>> ductai

}
