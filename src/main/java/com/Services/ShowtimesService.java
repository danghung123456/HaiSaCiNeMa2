package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.DTO.ViewDTO;
import com.Entity.Showtimes;

@Service
public interface ShowtimesService {
	public Page<Showtimes> getAll(Pageable pageable);

	public void deleteAll();

	public Showtimes add(Showtimes showtimes);

	public List<Showtimes> addAll(List<Showtimes> list);

	public Optional<Showtimes> findById(Integer id);

//    public List<Cinema> findByName(String name);

	public Showtimes save(Showtimes showtimes);

	public Page<Showtimes> findShowtimesByStatus(Integer status, Pageable pageable);

 List<ViewDTO> getViewShowtimes();
}
