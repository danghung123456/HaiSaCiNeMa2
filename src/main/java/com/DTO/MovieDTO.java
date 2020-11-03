package com.DTO;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.DTO.MovieDTO;
import com.Entity.Movie;

public class MovieDTO {

	private Integer movieId;
	private String movieName;
	private String duration;
	private String description;
	private String thumbnail;
	private String trailer;
	private String actors;
	private String director;
	private Integer ageLimit;
	private Integer status;

	public MovieDTO() {
		super();
	}

	public MovieDTO(Integer movieId, String movieName, String duration, String description, String thumbnail,
			String trailer, String actors, String director, Integer ageLimit) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
		this.duration = duration;
		this.description = description;
		this.thumbnail = thumbnail;
		this.trailer = trailer;
		this.actors = actors;
		this.director = director;
		this.ageLimit = ageLimit;
	}

	public boolean isNull(boolean includeId) {
		boolean res = isNull(movieName) || isNull(duration) || isNull(description) || isNull(thumbnail)
				|| isNull(actors) || isNull(director) || isNull(ageLimit);
		return includeId ? res || isNull(movieId) : res;
	}

	private boolean isNull(String input) {
		return input == null || input.trim().length() == 0;
	}

	private boolean isNull(Integer input) {
		return input == null;
	}

	public Movie convertToMovie() {
		ObjectMapper mapper = new ObjectMapper();
		Movie movie = new Movie(this.getMovieId());
		movie = mapper.convertValue(this, Movie.class);
		return movie;
	}

	public Integer getMovieId() {
		return movieId;
	}

	public void setMovieId(Integer movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getActors() {
		return actors;
	}

	public void setActors(String actors) {
		this.actors = actors;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public Integer getAgeLimit() {
		return ageLimit;
	}

	public void setAgeLimit(Integer ageLimit) {
		this.ageLimit = ageLimit;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	@Override
	public String toString() {
		return "MovieDTO [movieId=" + movieId + ", movieName=" + movieName + ", duration=" + duration + ", description="
				+ description + ", thumbnail=" + thumbnail + ", actors=" + actors + ", director=" + director
				+ ", ageLimit=" + ageLimit + ", status=" + status + "]";
	}
}
