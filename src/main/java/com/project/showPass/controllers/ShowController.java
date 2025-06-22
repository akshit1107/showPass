package com.project.showPass.controllers;

import com.project.showPass.dtos.request.AddShowRequest;
import com.project.showPass.dtos.request.AddShowSeatsRequest;
import com.project.showPass.services.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("shows")
public class ShowController {

    @Autowired
    private ShowService showService;

    @PostMapping("addShow")
    public String addShow(@RequestBody AddShowRequest addShowRequest) {
        return showService.addShow(addShowRequest);
    }

    @PostMapping("addShowSeats")
    public String addShowSeats(@RequestBody AddShowSeatsRequest addShowSeatsRequest) {
        return showService.addShowSeats(addShowSeatsRequest);
    }

}
