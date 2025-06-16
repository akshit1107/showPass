package com.project.showPass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.showPass.models.Theater;

public interface TheaterRepository extends JpaRepository<Theater, Integer> {
    
    // Additional query methods can be defined here if needed
    
}
