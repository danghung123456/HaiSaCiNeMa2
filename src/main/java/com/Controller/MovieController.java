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
import com.Entity.GenreMovie;
import com.Entity.Movie;
import com.Entity.MovieGenreDetail;
import com.Services.GenreMovieService;
import com.Services.MovieGenreDetailService;
import com.Services.MovieService;
import com.Constant.*;
import com.DTO.GenreMovieDTO;
import com.DTO.MovieDTO;
import com.DTO.Base.ResponseEntity;

@RestController
@RequestMapping(value = "movie")

public class MovieController {
	private static final Logger logger = LoggerFactory.getLogger(MovieController.class);
	@Autowired
	private MovieService movieService;
	@Autowired
	private GenreMovieService genreService;
	@Autowired
	private MovieGenreDetailService genreDetailService;

	@GetMapping
	public ResponseEntity<List<Movie>> index() {
		return ResponseEntity.body(movieService.getAll());
	}

	@GetMapping(value = "/{status}")
	public ResponseEntity<List<Movie>> findByStatus(@PathVariable("status") Integer status) {
		// Tìm danh sách phim theo status(status: 0: ngừng chiếu, 1: đang chiếu, 2: sắp
		// chiếu)
		int st;
		if (status == null) {
			st = 1;
		} else {
			st = status;
		}
		return ResponseEntity.body(movieService.findMovieByStatus(st));
	}

	@PostMapping(value = "/add")
	public ResponseEntity<Object> addMovie(@RequestBody MovieDTO movieDTO) {
		if (movieDTO.isNull(false)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			// Make sure id is NULL to insert Entity
			movieDTO.setMovieId(null);
			Movie movie = movieDTO.convertToMovie(movieDTO);
			movie.setStatus(2);
			movie = movieService.save(movie);
			List<GenreMovieDTO> listGenre = movieDTO.getListGenre();
			for (GenreMovieDTO genreDTO : listGenre) {
				GenreMovie genreMovie = genreService.findById(genreDTO.getGenreId()).orElse(null);
				MovieGenreDetail genreDetail = new MovieGenreDetail();
				genreDetail.setMovie(movie);
				genreDetail.setGenreMovie(genreMovie);
				genreDetailService.save(genreDetail);
			}
			return ResponseEntity.body(movie);
		}
	}

	@PutMapping(value = "/update")
	public ResponseEntity<Object> updateMovie(@RequestBody MovieDTO movieDTO) {
		logger.info("Call /add API, payload=[{}]", movieDTO);
		if (movieDTO.isNull(true)) {
			return ResponseEntity.body(Constant.BAD_REQUEST);
		} else {
			Optional<Movie> checkMovie = movieService.findById(movieDTO.getMovieId());
			if (checkMovie.isPresent()) {
				Movie movie = movieDTO.convertToMovie(movieDTO);
				return ResponseEntity.body(movieService.save(movie));
			} else {
				return ResponseEntity.body(Constant.NOT_FOUND);
			}
		}
	}

	@PutMapping(value = "/delete/{id}")
	public ResponseEntity<Object> deleteMovie(@PathVariable("id") Integer id) {
		Optional<Movie> checkMovie = movieService.findById(id);
		if (checkMovie.isPresent()) {
			Movie movie = checkMovie.orElse(null);
			movie.setStatus(0);
			return ResponseEntity.body(movieService.save(movie));
		} else {
			return ResponseEntity.body(Constant.NOT_FOUND);
		}
	}

	@GetMapping("/findbyid")
	public ResponseEntity<Object> findById(Integer id) {
		return ResponseEntity.body(movieService.findById(id));
	}

	@GetMapping("/findbyname")
	public ResponseEntity<Object> findByName(String name) {
		return ResponseEntity.body(movieService.findByName(name));
	}

}
