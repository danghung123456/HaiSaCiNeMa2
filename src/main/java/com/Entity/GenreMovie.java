package com.Entity;
<<<<<<< HEAD

import java.io.Serializable;
import java.util.List;
=======
// default package

import java.util.HashSet;
import java.util.Set;

>>>>>>> 6d6c8bc42570335d28a4f29b6d1dbf5bb431bb14
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * GenreMovie generated by hbm2java
 */
@Entity
<<<<<<< HEAD
@Table(name = "genremovie")
public class GenreMovie{
=======
@Table(name = "GenreMovie")
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "genreId")
public class GenreMovie {
>>>>>>> 6d6c8bc42570335d28a4f29b6d1dbf5bb431bb14

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "genreid", unique = true, nullable = false)
	private Integer genreId;

	@Column(name = "name")
	private String name;
<<<<<<< HEAD
=======
//	@JsonIgnore
	private Set<MovieGenreDetail> movieGenreDetails = new HashSet<MovieGenreDetail>(0);
>>>>>>> 6d6c8bc42570335d28a4f29b6d1dbf5bb431bb14

	@OneToMany(mappedBy = "movie")
	private List<MovieGenreDetail> movieGenreDetail;

<<<<<<< HEAD
	public GenreMovie() {
	}

=======
	public GenreMovie(String name, Set<MovieGenreDetail> movieGenreDetails) {
		this.name = name;
//		this.movieGenreDetails = movieGenreDetails;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "genreId", unique = true, nullable = false)
>>>>>>> 6d6c8bc42570335d28a4f29b6d1dbf5bb431bb14
	public Integer getGenreId() {
		return genreId;
	}

	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

<<<<<<< HEAD
	public String getName() {
		return name;
=======
	@Column(name = "name")
	public String getName() {
		return this.name;
>>>>>>> 6d6c8bc42570335d28a4f29b6d1dbf5bb431bb14
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MovieGenreDetail> getMovieGenreDetail() {
		return movieGenreDetail;
	}

	public void setMovieGenreDetail(List<MovieGenreDetail> movieGenreDetail) {
		this.movieGenreDetail = movieGenreDetail;
	}

}
