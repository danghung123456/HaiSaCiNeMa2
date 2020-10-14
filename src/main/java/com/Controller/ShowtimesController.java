package com.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Constant.Constant;
import com.DTO.ShowtimesDTO;
import com.DTO.Base.ResponseEntiy;
import com.Entity.Showtimes;
import com.Services.ShowtimesService;


@RestController
@RequestMapping(value = "showtimes")
public class ShowtimesController {

	@Autowired
	private ShowtimesService showtimesService;

	@GetMapping("/index")
	public  ResponseEntiy<Page<Showtimes>> index(Integer status, Integer page) {
		Page<Showtimes> list;
		int pageSize = 5;
		int st;
		if (status == null) {
			st = 1;
		} else {
			st = status;
		}
		if (page == null) {
			list = showtimesService.findShowtimesByStatus(st, Pageable.unpaged());
		} else {
			list = showtimesService.findShowtimesByStatus(st, PageRequest.of(page, pageSize));
		}
		return  ResponseEntiy.body(list);
	}

	@PostMapping(value = "/add")
	public ResponseEntiy<Object> addShowtimes(@RequestBody ShowtimesDTO showtimesDTO) {
		 if (showtimesDTO.isNull(false)) {
	            return ResponseEntiy.body(Constant.BAD_REQUEST);
	        } else {
	            //Make sure id is NULL to insert Entity
	            showtimesDTO.setShowtimeId(null);
	            Showtimes showtimes = showtimesDTO.convertToShowtimes();
	            return ResponseEntiy.body(showtimesService.add(showtimes));
	        }
	} 
	
	@PutMapping(value = "/update")
	public ResponseEntiy<Object> updateShowtimes(@RequestBody ShowtimesDTO showtimesDTO) {
		if (showtimesDTO.isNull(true)) {
            return ResponseEntiy.body(Constant.BAD_REQUEST);
        } else {
            Optional<Showtimes> checkShowtimes = showtimesService.findById(showtimesDTO.getShowtimeId());
            if (checkShowtimes.isPresent()) {
                Showtimes showtimes = showtimesDTO.convertToShowtimes();
                return ResponseEntiy.body(showtimesService.save(showtimes));
            } else {
                return ResponseEntiy.body(Constant.NOT_FOUND);
            }
        }
	}
	
	@PutMapping(value = "/delete")
	public ResponseEntiy<Object> deleteShowtimes(@RequestBody ShowtimesDTO showtimesDTO) {
		if (showtimesDTO.getShowtimeId() == null) {
            return ResponseEntiy.body(Constant.BAD_REQUEST);
        } else {
            Optional<Showtimes> checkShowtimes = showtimesService.findById(showtimesDTO.getShowtimeId());
            if (checkShowtimes.isPresent()) {
            	Showtimes showtimes = showtimesDTO.convertToShowtimes();
            	showtimes.setStatus(0);
                return ResponseEntiy.body(showtimesService.save(showtimes));
            } else {
                return ResponseEntiy.body(Constant.NOT_FOUND);
            }
        }
	}
	
	@GetMapping("/findbyid")
	public ResponseEntiy<Object> findById(Integer id) {
		return  ResponseEntiy.body(showtimesService.findById(id));
	}
	
//	@GetMapping("/findbyname")
//	public ResponseEntiy<Object> findByName(String name) {
//		return ResponseEntiy.body(cinemaService.findByName(name));
//	}
}
