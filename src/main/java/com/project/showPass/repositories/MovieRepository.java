package com.project.showPass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.showPass.models.Movie;

public interface MovieRepository extends JpaRepository <Movie, Long> {
    // Additional query methods can be defined here if needed
    
}
