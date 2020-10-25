package com.DTO;

import com.Entity.GenreMovie;
import com.Entity.Movie;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MovieGenreDetail {

	private Integer movieGenreDetailId;
	private GenreMovie genreMovie;
	private Movie movie;

	public boolean isNull(boolean includeId) {
		boolean res = isNull(genreMovie.getGenreId()) || isNull(movie.getMovieId());
		return includeId ? res || isNull(movieGenreDetailId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	public MovieGenreDetail convertToGenreEntity() {
		ObjectMapper mapper = new ObjectMapper();
		MovieGenreDetail movieGenreDetail = mapper.convertValue(this, MovieGenreDetail.class);
		return movieGenreDetail;

	}

	public MovieGenreDetail() {
		super();
	}

	public MovieGenreDetail(Integer movieGenreDetailId, GenreMovie genreMovie, Movie movie) {
		super();
		this.movieGenreDetailId = movieGenreDetailId;
		this.genreMovie = genreMovie;
		this.movie = movie;
	}

	public Integer getMovieGenreDetailId() {
		return movieGenreDetailId;
	}

	public void setMovieGenreDetailId(Integer movieGenreDetailId) {
		this.movieGenreDetailId = movieGenreDetailId;
	}

	public GenreMovie getGenreMovie() {
		return genreMovie;
	}

	public void setGenreMovie(GenreMovie genreMovie) {
		this.genreMovie = genreMovie;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "MovieGenreDetail [movieGenreDetailId=" + movieGenreDetailId + ", genreMovie=" + genreMovie + ", movie="
				+ movie + "]";
	}

}
