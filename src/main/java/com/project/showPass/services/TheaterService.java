package com.project.showPass.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.showPass.dtos.request.AddTheaterRequest;
import com.project.showPass.models.Theater;
import com.project.showPass.repositories.TheaterRepository;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    public String addTheater(AddTheaterRequest addTheaterRequest) {
        // Theater theater = new Theater();
        // theater.setTheaterName(addTheaterRequest.getName());
        // theater.setAddress(addTheaterRequest.getAddress());
        // theater.setNoOfScreens(addTheaterRequest.getNoOfScreens());

        //@Builder can be used to simplify the creation of the Theater object (modern way / advanced way)
        Theater theater = Theater.builder()
                .theaterName(addTheaterRequest.getName())
                .address(addTheaterRequest.getAddress())
                .noOfScreens(addTheaterRequest.getNoOfScreens())
                .build();
        //save the theater to the database
        theaterRepository.save(theater);
        return "Theater added successfully with ID: " + theater.getTheaterId();
    }
    
}
