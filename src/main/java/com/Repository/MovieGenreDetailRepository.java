package com.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Entity.MovieGenreDetail;

@Repository
public interface MovieGenreDetailRepository extends JpaRepository<MovieGenreDetail, Integer> {

}
