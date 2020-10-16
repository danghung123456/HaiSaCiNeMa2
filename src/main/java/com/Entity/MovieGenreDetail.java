package com.Entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * MovieGenreDetail generated by hbm2java
 */
@Entity
@Table(name = "moviegenredetail")
public class MovieGenreDetail{

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "moviegenredetailid", unique = true, nullable = false)
	private Integer movieGenreDetailId;
	
	@ManyToOne
	@JoinColumn(name = "genreid")
	private GenreMovie genreMovie;
	
	@ManyToOne
	@JoinColumn(name = "movieid")
	private Movie movie;

	public MovieGenreDetail() {
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

}
