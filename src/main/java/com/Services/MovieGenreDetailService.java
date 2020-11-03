package com.Services;

import java.util.Optional;

import org.springframework.stereotype.Service;
import com.Entity.MovieGenreDetail;

@Service
public interface MovieGenreDetailService {

	MovieGenreDetail add(MovieGenreDetail movieGenreDetail);

	MovieGenreDetail save(MovieGenreDetail movieGenreDetail);

	Optional<MovieGenreDetail> findById(Integer id);
}
