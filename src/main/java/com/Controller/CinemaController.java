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
import org.springframework.web.bind.annotation.RestController;

import com.Constant.Constant;
import com.DTO.CinemaDTO;
import com.DTO.Base.ResponseEntiy;
import com.Entity.Cinema;
import com.Services.CinemaService;


@RestController
@RequestMapping(value = "cinema")

public class CinemaController {

	@Autowired
	private CinemaService cinemaService;

	@GetMapping
	public  List<Cinema> index() {
		return cinemaService.getAll();
	}

	@PostMapping(value = "/add")
	public ResponseEntiy<Object> addCinema(@RequestBody CinemaDTO cinemaDTO) {
		 if (cinemaDTO.isNull(false)) {
	            return ResponseEntiy.body(Constant.BAD_REQUEST);
	        } else {
	            //Make sure id is NULL to insert Entity
	            cinemaDTO.setCinemaId(null);
	            Cinema cinema = cinemaDTO.convertToCinema();
	            return ResponseEntiy.body(cinemaService.add(cinema));
	        }
	} 
	
	@PutMapping(value = "/update")
	public ResponseEntiy<Object> updateCinema(@RequestBody CinemaDTO cinemaDTO) {
		if (cinemaDTO.isNull(true)) {
            return ResponseEntiy.body(Constant.BAD_REQUEST);
        } else {
            Optional<Cinema> checkCinema = cinemaService.findById(cinemaDTO.getCinemaId());
            if (checkCinema.isPresent()) {
                Cinema cinema = cinemaDTO.convertToCinema();
                return ResponseEntiy.body(cinemaService.save(cinema));
            } else {
                return ResponseEntiy.body(Constant.NOT_FOUND);
            }
        }
	}
	
	@GetMapping("/findbyid")
	public ResponseEntiy<Object> findById(Integer id) {
		return  ResponseEntiy.body(cinemaService.findById(id));
	}
	
	@GetMapping("/findbyname")
	public ResponseEntiy<Object> findByName(String name) {
		return ResponseEntiy.body(cinemaService.findByName(name));
	}
	
}
