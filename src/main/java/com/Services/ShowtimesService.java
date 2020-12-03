package com.Services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.DTO.ShowtimePeriodDTO;
import com.DTO.ShowtimesDTO;
import com.DTO.ShowtimesMovieDTO;
import com.Entity.Employee;
import com.Entity.Period;
import com.Entity.Showtimes;

@Service
public interface ShowtimesService {
	/**
	 * Find all entity Showtimes
	 * 
	 * @return List<Showtimes>
	 */
	List<Showtimes> getAllShowtimes();

	/**
	 * Delete all entity Showtimes already exists
	 * 
	 * @return void
	 */
	void deleteAll();

	/**
	 * Saves an entity Showtimes
	 * 
	 * @return entity Showtimes
	 */
	Showtimes add(Showtimes showtimes);

	/**
	 * Saves all entity Showtimes from list showtimes
	 * 
	 * @return List<Showtimes>
	 */
	List<Showtimes> addAll(List<Showtimes> list);

	/**
	 * Search an entity Showtimes by its id
	 * 
	 * @return the entity with the ShowtimesId entered or Optional#empty() if none
	 *         found.
	 */
	Optional<Showtimes> findById(Integer id);

	/**
	 * Saves an entity and flushes changes instantly.
	 * 
	 * @return entity Showtimes
	 */
	Showtimes save(Showtimes showtimes);

	/**
	 * Find all entity Showtimes by status(present or unpresent) entered
	 * 
	 * @return List<Showtimes>
	 */
	List<Showtimes> findShowtimesByStatus(Integer status);

	/**
	 * Convert from ShowtimesDTO to entity Showtimes
	 * 
	 * @return entity Showtimes
	 */
	Showtimes convert(ShowtimesDTO dto);

	List<ShowtimesMovieDTO> listShowtime(Integer movieId);

	/**
	 * The function that will update status of entity Showtimes after a schedule
	 * 
	 * @return void
	 */
	void updateShowtimeByPreviousDate();

	/**
	 * Find all entity Showtimes by cinemaId of entity Cinema
	 * 
	 * @param cinemaId of entity Cinema
	 * @return List<Showtimes>
	 */
	List<Showtimes> getShowtimesByCinema(Integer id);

	/**
	 * Find all entity Employee by user's email entered. Use this function for 
	 * get employeeId that add Showtimes
	 * 
	 * @return entity Employee
	 */
	Employee getEmployeeIdByEmail(String email);

}
