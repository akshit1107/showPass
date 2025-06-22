package com.project.showPass.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.showPass.models.Show;
import com.project.showPass.models.ShowSeat;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    
    public List<ShowSeat> findAllByShow(Show show);

    //custom query to find all show seats by show id
    @Query(nativeQuery = true, value = "SELECT * FROM show_seats WHERE show_id =:showId")
    public List<ShowSeat> findShowSeats(Integer showId);
    
}