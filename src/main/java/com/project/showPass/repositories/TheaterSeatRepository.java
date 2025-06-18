package com.project.showPass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.showPass.models.TheaterSeat;

public interface TheaterSeatRepository extends JpaRepository<TheaterSeat, Integer> {
    
}
