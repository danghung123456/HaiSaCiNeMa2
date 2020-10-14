package com.Services.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Entity.Movie;
import com.Repository.MovieRepository;
import com.Services.MovieService;

@Service
public class MovieServiceImpl implements MovieService {
	@Autowired
    MovieRepository repository;

    public Page<Movie> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

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
}
