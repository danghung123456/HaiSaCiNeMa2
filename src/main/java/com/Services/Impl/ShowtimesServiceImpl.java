package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
<<<<<<< HEAD

import com.DTO.ViewDTO;
=======
>>>>>>> 6afbf360483d921cdd3533b8d03d15c40e343080
import com.Entity.Showtimes;
import com.Repository.ShomtimesRepository;
import com.Services.ShowtimesService;

@Service
public class ShowtimesServiceImpl implements ShowtimesService {
	@Autowired
<<<<<<< HEAD
    ShomtimesRepository repository;

	
=======
	ShomtimesRepository repository;

>>>>>>> 6afbf360483d921cdd3533b8d03d15c40e343080
	@Override
	public Page<Showtimes> getAll(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public void deleteAll() {
		repository.deleteAll();

	}

	@Override
	public Showtimes add(Showtimes showtimes) {
<<<<<<< HEAD
=======

>>>>>>> 6afbf360483d921cdd3533b8d03d15c40e343080
		return repository.save(showtimes);
	}

	@Override
	public List<Showtimes> addAll(List<Showtimes> list) {
		List<Showtimes> res = new ArrayList<>();
		for (Showtimes showtimes : list) {
			res.add(add(showtimes));
		}
		return res;
	}

	@Override
	public Optional<Showtimes> findById(Integer id) {
		return repository.findById(id);
	}

	@Override
	public Showtimes save(Showtimes showtimes) {
		return repository.saveAndFlush(showtimes);
	}

	@Override
	public Page<Showtimes> findShowtimesByStatus(Integer status, Pageable pageable) {
		return repository.findShowtimesByStatus(status, pageable);
	}

	@Override
	public List<ViewDTO> getViewShowtimes() {
		// TODO Auto-generated method stub
		return repository.getViewShowTimes();
	}



//	@Override
//	public List<showMovieDTO> findAll() {
//		// TODO Auto-generated method stub
//		return repoView.myView();
//	}








}
