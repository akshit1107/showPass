package com.project.showPass.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.showPass.dtos.request.AddTheaterRequest;
import com.project.showPass.dtos.request.AddTheaterSeatsRequest;
import com.project.showPass.services.TheaterService;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    private TheaterService theaterService;

    @PostMapping("/addTheater")
    public String addTheater(@RequestBody AddTheaterRequest addTheaterRequest) {
        return theaterService.addTheater(addTheaterRequest);
    }

    @PostMapping("/addTheaterSeats")
    public String addTheaterSeats(@RequestBody AddTheaterSeatsRequest addTheaterSeatsRequest) {
        return theaterService.addTheaterSeats(addTheaterSeatsRequest);
    }

}
