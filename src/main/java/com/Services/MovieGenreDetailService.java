package com.Services;

import org.springframework.stereotype.Service;
import com.Entity.MovieGenreDetail;

@Service
public interface MovieGenreDetailService {

	public MovieGenreDetail add(MovieGenreDetail movieGenreDetail);

	public MovieGenreDetail save(MovieGenreDetail movieGenreDetail);
}
