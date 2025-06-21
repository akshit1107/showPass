package com.project.showPass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.showPass.models.Movie;
import org.springframework.data.jpa.repository.Query;

public interface MovieRepository extends JpaRepository <Movie, Long> {
    // Additional query methods can be defined here if needed

    Movie findMovieByMovieName(String movieName);

    @Query(nativeQuery = true, value = "select * from movies where movie_name =:movieName")
    Movie findMovie(String movieName);
    
}
