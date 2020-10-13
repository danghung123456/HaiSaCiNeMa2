package com.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.Constant.Constant;
import com.DTO.EmployeeDTO;
import com.DTO.GenreDTO;
import com.DTO.Base.ResponseEntiy;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Employee;
import com.Entity.GenreMovie;
import com.Services.GenreMovieService;

@RestController
@RequestMapping(value = "genre")
public class GenreController {

	@Autowired
	private GenreMovieService genreService;

//	@GetMapping("/index")
//	public ResponseEntiy<List<GenreMovie>> index(Integer page) {
//		List<GenreMovie> list;
//		int pageSize = 5;
//		if (page == null) {
//			list = genreService.getAll(Pageable.unpaged()).getContent();
//		} else {
//			list = genreService.getAll(PageRequest.of(page, pageSize)).getContent();
//
//		}
////		response en ti y :v 
//		return ResponseEntiy.body(list);
//	}
	@GetMapping("/index")
	public List<GenreMovie> index() {
		return genreService.findAll();
	}

	@PostMapping("/add")
	public ResponseEntiy<Object> addGenreMovie(@RequestBody GenreDTO genreDTO) {
		if (genreDTO.isNull(false)) {
			return ResponseEntiy.body(Constant.BAD_REQUEST);
		} else {
			genreDTO.setGenreId(null);
			GenreMovie genre = genreDTO.convertToGenreEntity();
			return ResponseEntiy.body(genreService.save(genre));
		}
//		

	}

	@PutMapping("/update")
	public ResponseEntiy<Object> updateGenreMovie(@RequestBody GenreDTO genreDTO) {
		if (genreDTO.isNull(true)) {
			return ResponseEntiy.body(Constant.BAD_REQUEST);
		} else {

			Optional<GenreMovie> checkGenre = genreService.findById(genreDTO.getGenreId());
			if (checkGenre.isPresent()) {
				GenreMovie genre = genreDTO.convertToGenreEntity();
				return ResponseEntiy.body(genre);
			} else {
				return ResponseEntiy.body(Constant.NOT_FOUND);
			}

		}
	}

	@DeleteMapping(value = "/delete")
	public ResponseEntiy<Object> deleteEmployee(@RequestBody GenreDTO genreDTO) {
		if (genreDTO.getGenreId() == null) {
			return ResponseEntiy.body(Constant.BAD_REQUEST);
		} else {
			Optional<GenreMovie> checkGenre = genreService.findById(genreDTO.getGenreId());
			if (checkGenre.isPresent()) {
				GenreMovie genre = genreDTO.convertToGenreEntity();
				return ResponseEntiy.body(genreService.save(genre));
			} else {
				return ResponseEntiy.body(Constant.NOT_FOUND);
			}
		}
	}

	@GetMapping("/findbyid")
	public ResponseEntiy<Object> findById(Integer id) {
		System.out.println(genreService.findById(id));
		return ResponseEntiy.body(genreService.findById(id));
	}

	@GetMapping("/findbyname")
	public ResponseEntiy<Object> findByName(String name) {
		System.out.println(genreService.findByName(name));
		return ResponseEntiy.body(genreService.findByName(name));
	}
}
