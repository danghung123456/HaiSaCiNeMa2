package com.Services;

import com.Entity.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public interface MovieService {

    public Page<Movie> getAll(Pageable pageable);

    public void deleteAll();

    public Movie add(Movie movie);

    public List<Movie> addAll(List<Movie> list);
    
    public Optional<Movie> findById(Integer id);
    
    public List<Movie> findByName(String name);

    public Movie save(Movie movie);
}
