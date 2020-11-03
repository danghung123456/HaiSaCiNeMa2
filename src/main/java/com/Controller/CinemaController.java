package com.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Constant.Constant;
import com.DTO.CinemaDTO;
import com.DTO.Base.ResponseEntity;
import com.DTO.view.TotalByCinemaView;
import com.Entity.Cinema;
import com.Services.CinemaService;


@RestController
@RequestMapping(value = "cinema")

public class CinemaController {

	@Autowired
	private CinemaService cinemaService;

	@GetMapping
	public  ResponseEntity<List<Cinema>> index() {
		return ResponseEntity.body(cinemaService.getAll());
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Object> addCinema(@RequestBody CinemaDTO cinemaDTO) {
		 if (cinemaDTO.isNull(false)) {
	            return ResponseEntity.body(Constant.BAD_REQUEST);
	        } else {
	            //Make sure id is NULL to insert Entity
	            cinemaDTO.setCinemaId(null);
	            Cinema cinema = cinemaDTO.convertToCinema();
	            return ResponseEntity.body(cinemaService.add(cinema));
	        }
	} 
	
	@PutMapping(value = "/update")
	public ResponseEntity<Object> updateCinema(@RequestBody CinemaDTO cinemaDTO) {
		if (cinemaDTO.isNull(true)) {
            return ResponseEntity.body(Constant.BAD_REQUEST);
        } else {
            Optional<Cinema> checkCinema = cinemaService.findById(cinemaDTO.getCinemaId());
            if (checkCinema.isPresent()) {
                Cinema cinema = cinemaDTO.convertToCinema();
                return ResponseEntity.body(cinemaService.save(cinema));
            } else {
                return ResponseEntity.body(Constant.NOT_FOUND);
            }
        }
	}
	
	@GetMapping("/findbyid")
	public ResponseEntity<Object> findById(Integer id) {
		return  ResponseEntity.body(cinemaService.findById(id));
	}
	
	@GetMapping("/findbyname")
	public ResponseEntity<Object> findByName(String name) {
		return ResponseEntity.body(cinemaService.findByName(name));
	}
}
