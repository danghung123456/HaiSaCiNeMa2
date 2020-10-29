package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
<<<<<<< HEAD

import com.DTO.ViewDTO;
=======
>>>>>>> 6afbf360483d921cdd3533b8d03d15c40e343080
import com.Entity.Showtimes;

@Service
public interface ShowtimesService {
	
	public Page<Showtimes> getAll(Pageable pageable);

	public void deleteAll();

	public Showtimes add(Showtimes showtimes);
<<<<<<< HEAD

	public List<Showtimes> addAll(List<Showtimes> list);

	public Optional<Showtimes> findById(Integer id);

//    public List<Cinema> findByName(String name);

	public Showtimes save(Showtimes showtimes);

	public Page<Showtimes> findShowtimesByStatus(Integer status, Pageable pageable);

 List<ViewDTO> getViewShowtimes();
=======

	public List<Showtimes> addAll(List<Showtimes> list);

	public Optional<Showtimes> findById(Integer id);

	public Showtimes save(Showtimes showtimes);

	public Page<Showtimes> findShowtimesByStatus(Integer status, Pageable pageable);
>>>>>>> 6afbf360483d921cdd3533b8d03d15c40e343080
}
