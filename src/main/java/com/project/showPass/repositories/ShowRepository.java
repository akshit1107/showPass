package com.project.showPass.repositories;

import com.project.showPass.models.Movie;
import com.project.showPass.models.Show;
import com.project.showPass.models.Theater;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowRepository extends JpaRepository<Show, Integer> {

    public Show findShowByShowDateAndShowTimeAndMovieAndTheater(LocalDate showDate,
                                                                LocalTime showTime,
                                                                Movie movie,
                                                                Theater theater
                                                                );

}
