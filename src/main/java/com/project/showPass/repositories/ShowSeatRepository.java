package com.project.showPass.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.showPass.models.ShowSeat;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    // Additional query methods can be defined here if needed
}