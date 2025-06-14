package com.project.showPass.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.showPass.dtos.request.MovieRequest;
import com.project.showPass.models.Movie;
import com.project.showPass.repositories.MovieRepository;

@Service
public class MovieService {
    
    @Autowired
    private MovieRepository movie_repo;

    public String addMovie(MovieRequest movie) {
        // Validate the movie object (e.g., check for null values, valid genres, etc.)
        if (movie == null || movie.getMovie_name() == null || movie.getGenre() == null) {
            return "Invalid movie data!";
        }
        // Convert MovieRequest to Movie entity
        Movie movieEntity = new Movie();
        movieEntity.setMovie_name(movie.getMovie_name());
        movieEntity.setRelease_date(movie.getRelease_date());
        movieEntity.setDuration(movie.getDuration());
        movieEntity.setLanguage(movie.getLanguage());
        movieEntity.setGenre(movie.getGenre());
        movieEntity.setRating(movie.getRating());
        // Save the movie entity to the repository
        movie_repo.save(movieEntity);
        return "Movie added successfully!";
    }



}
