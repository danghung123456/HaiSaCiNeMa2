package com.Controller;

import com.Entity.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Constant.Constant;
import com.DTO.PeriodDTO;
import com.DTO.Base.ResponseEntiy;
import com.Services.PeriodService;

@RestController
@RequestMapping(value = "period")
public class PeriodController {

	@Autowired
	PeriodService periodService;
	
	@GetMapping("/index")
	public List<Period> index() {
		return periodService.findAll();

	}

	@PostMapping(value = "/add")
	public ResponseEntiy<Object> addPeriod(@RequestBody PeriodDTO periodDTO) {
		 if (periodDTO.isNull(false)) {
	            return ResponseEntiy.body(Constant.BAD_REQUEST);
	        } else {
	            //Make sure id is NULL to insert Entity
	            periodDTO.setPeriodId(null);;
	            Period period = periodDTO.convertToPeriod();
	            return ResponseEntiy.body(periodService.add(period));
	        }
	} 
	
	@PutMapping(value = "/update")
	public ResponseEntiy<Object> updatePeriod(@RequestBody PeriodDTO periodDTO) {
		if (periodDTO.isNull(true)) {
            return ResponseEntiy.body(Constant.BAD_REQUEST);
        } else {
            Optional<Period> checkPeriod = periodService.findById(periodDTO.getPeriodId());
            if (checkPeriod.isPresent()) {
                Period period = periodDTO.convertToPeriod();
                return ResponseEntiy.body(periodService.save(period));
            } else {
                return ResponseEntiy.body(Constant.NOT_FOUND);
            }
        }
	}
	
//	@PutMapping(value = "/delete")
//	public ResponseEntiy<Object> delete(@RequestBody MovieDTO movieDTO) {
//		if (movieDTO.getMovieId() == null) {
//            return ResponseEntiy.body(Constant.BAD_REQUEST);
//        } else {
//            Optional<Movie> checkMovie = movieService.findById(movieDTO.getMovieId());
//            if (checkMovie.isPresent()) {
//            	Movie movie = movieDTO.convertToMovie();
//            	movie.setStatus(0);
//                return ResponseEntiy.body(movieService.save(movie));
//            } else {
//                return ResponseEntiy.body(Constant.NOT_FOUND);
//            }
//        }
//	}
	@GetMapping("/findbystatus")
	public ResponseEntiy<Object> findPeriodByStatus(Integer status) {
		return ResponseEntiy.body(periodService.findPeriodByStatus(status));
	}
}
