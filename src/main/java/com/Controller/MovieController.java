package com.Controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.DTO.MovieDTO;
import com.Entity.Movie;
import com.Services.MovieService;
import com.Constant.*;
import com.DTO.Base.ResponseEntiy;

@RestController
@RequestMapping(value = "movie")

public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@GetMapping
	public  ResponseEntiy<List<Movie>> index() {
		return  ResponseEntiy.body(movieService.getAll());
	}

	@GetMapping(value = "/{status}")
	public  ResponseEntiy<List<Movie>> findByStatus(@PathVariable("status") Integer status) {
		//Tìm danh sách phim theo status(status: 0: ngừng chiếu, 1: đang chiếu, 2: sắp chiếu)
		int st;
		if (status == null) {
			st = 1;
		} else {
			st = status;
		}
		return  ResponseEntiy.body(movieService.findMovieByStatus(st));
	}

	@PostMapping(value = "/add")
	public ResponseEntiy<Object> addMovie(@RequestBody MovieDTO movieDTO) {
		 if (movieDTO.isNull(false)) {
	            return ResponseEntiy.body(Constant.BAD_REQUEST);
	        } else {
	            //Make sure id is NULL to insert Entity
	            movieDTO.setMovieId(null);
	            Movie movie = movieDTO.convertToMovie();
	            return ResponseEntiy.body(movieService.add(movie));
	        }
	} 
	
	@PutMapping(value = "/update")
	public ResponseEntiy<Object> updateMovie(@RequestBody MovieDTO movieDTO) {
		if (movieDTO.isNull(true)) {
            return ResponseEntiy.body(Constant.BAD_REQUEST);
        } else {
            Optional<Movie> checkMovie = movieService.findById(movieDTO.getMovieId());
            if (checkMovie.isPresent()) {
                Movie movie = movieDTO.convertToMovie();
                return ResponseEntiy.body(movieService.save(movie));
            } else {
                return ResponseEntiy.body(Constant.NOT_FOUND);
            }
        }
	}
	
	@PutMapping(value = "/delete")
	public ResponseEntiy<Object> deleteMovie(@RequestBody MovieDTO movieDTO) {
		if (movieDTO.getMovieId() == null) {
            return ResponseEntiy.body(Constant.BAD_REQUEST);
        } else {
            Optional<Movie> checkMovie = movieService.findById(movieDTO.getMovieId());
            if (checkMovie.isPresent()) {
            	Movie movie = movieDTO.convertToMovie();
            	movie.setStatus(0);
                return ResponseEntiy.body(movieService.save(movie));
            } else {
                return ResponseEntiy.body(Constant.NOT_FOUND);
            }
        }
	}
	
	@GetMapping("/findbyid")
	public ResponseEntiy<Object> findById(Integer id) {
		return  ResponseEntiy.body(movieService.findById(id));
	}
	
	@GetMapping("/findbyname")
	public ResponseEntiy<Object> findByName(String name) {
		return ResponseEntiy.body(movieService.findByName(name));
	}



}
