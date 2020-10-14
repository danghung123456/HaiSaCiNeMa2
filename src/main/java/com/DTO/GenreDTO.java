package com.DTO;

import com.Entity.GenreMovie;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GenreDTO  {


	private Integer genreId;
	private String name;


	public void setGenreId(Integer genreId) {
		this.genreId = genreId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getGenreId() {
		return genreId;
	}

	public boolean isNull(boolean includeId) {
        boolean res = isNull(name);
        return includeId ? res || isNull(genreId) : res;
    }

    private boolean isNull(String input) {
        return input == null || input.trim().length() == 0;
    }

    private boolean isNull(Integer input) {
        return input == null;
    }

	public GenreMovie convertToGenreEntity() {
		ObjectMapper mapper = new ObjectMapper();
		GenreMovie genre = mapper.convertValue(this, GenreMovie.class);
		return genre;

	}

}
