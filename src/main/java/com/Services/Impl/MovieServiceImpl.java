package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.DTO.MovieDTO;
import com.DTO.MovieGenreDetail;
import com.Entity.GenreMovie;
import com.Entity.Movie;
import com.Repository.GenreMovieRepository;
import com.Repository.MovieRepository;
import com.Services.MovieGenreDetailService;
import com.Services.MovieService;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
    MovieRepository repository;
	@Autowired
    GenreMovieRepository genreRepository;

    public void deleteAll() {
        repository.deleteAll();
    }

    public Movie add(Movie movie) {
        return repository.save(movie);
    }

    public List<Movie> addAll(List<Movie> list) {
        List<Movie> res = new ArrayList<>();
        for (Movie movie : list){
            res.add(add(movie));
        }
        return res;
    }

    public Optional<Movie> findById(Integer id){
        return  repository.findById(id);
    }

    public List<Movie> findByName(String name){
        return repository.findByMovieName(name);
    }

    public Movie save(Movie movie){
        return repository.saveAndFlush(movie);
    }
    public List<Movie> findMovieByStatus(Integer status) {
		return repository.findMovieByStatus(status);
	}

	@Override
	public List<Movie> getAll() {
		return repository.findAll();
	}

	@Override
	public Movie convertToMovie(MovieDTO dto) {
		Movie movie = new Movie();
		movie.setMovieName(dto.getMovieName());
		movie.setDuration(dto.getDuration());
		movie.setDescription(dto.getDescription());
		movie.setActors(dto.getActors());
		movie.setDirector(dto.getDirector());
		movie.setThumbnail(dto.getThumbnail());
		movie.setTrailer(dto.getTrailer());
		movie.setAgeLimit(dto.getAgeLimit());
		movie.setStatus(2);
		return movie;
	}



}
