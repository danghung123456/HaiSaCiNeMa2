package com.Controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.Constant.Constant;
import com.DTO.ShowtimesDTO;
import com.DTO.Base.ResponseEntity;
import com.Entity.Showtimes;
import com.Services.SeatStatusService;
import com.Services.ShowtimesService;

@RestController
@RequestMapping(value = "showtimes")

public class ShowtimesController {
	private static final Logger logger = LoggerFactory.getLogger(ShowtimesController.class);

	@Autowired
	private ShowtimesService showtimesService;
	@Autowired
	private SeatStatusService seatStatusService;

	@GetMapping
	public ResponseEntity<List<Showtimes>> getAllShowtimes(){
		return ResponseEntity.body(showtimesService.getAllShowtimes());
	}
	@GetMapping("/{status}")
	public ResponseEntity<List<Showtimes>> getShowtimesByStatus(@PathVariable("status") Integer status) {
		int st;
		if (status == null) {
			st = 1;
		} else {
			st = status;
		}
		return ResponseEntity.body(showtimesService.findShowtimesByStatus(st));
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Object> addShowtimes(@RequestBody ShowtimesDTO showtimesDTO) {
		if (showtimesDTO.isNull(false)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			// Make sure id is NULL to insert Entity
			showtimesDTO.setShowtimeId(null);
			Showtimes showtimes = showtimesService.convert(showtimesDTO);
			showtimesService.add(showtimes);
			seatStatusService.add(showtimes);
			return ResponseEntity.body(showtimes);
		}
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Object> updateShowtimes(@RequestBody ShowtimesDTO showtimesDTO) {
		if (showtimesDTO.isNull(true)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			Optional<Showtimes> checkShowtimes = showtimesService.findById(showtimesDTO.getShowtimeId());
			if (checkShowtimes.isPresent()) {
				Showtimes showtimes = showtimesService.convert(showtimesDTO);
				return ResponseEntity.body(showtimesService.save(showtimes));
			} else {
				return ResponseEntity.body(Constant.NOT_FOUND);
			}
		}
	}

	@PutMapping(value = "/delete")
	public ResponseEntity<Object> deleteShowtimes(Integer id) {
		if (id == null) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			Optional<Showtimes> checkShowtimes = showtimesService.findById(id);
			if (checkShowtimes.isPresent()) {
				Showtimes showtimes = checkShowtimes.orElse(null);
				//status =1 : đang hoạt động status =2 : ngừng hoạt động
				showtimes.setStatus(2);
				return ResponseEntity.body(showtimesService.save(showtimes));
			} else {
				return ResponseEntity.body(Constant.NOT_FOUND);
			}
		}
	}

	@GetMapping("/findbyid")
	public ResponseEntity<Object> findById(Integer id) {
		return ResponseEntity.body(showtimesService.findById(id));
	}

	@GetMapping("/findbyMovieName")
	public ResponseEntity<Object> findById(String movieName) {
		return ResponseEntity.body(showtimesService.findByMovieName(movieName));
	}
	
	@GetMapping("/getshowtimes")
	public ResponseEntity<Object> getShowtimes(Integer id) {
		return ResponseEntity.body(showtimesService.listShowtime(id));
	}

}
