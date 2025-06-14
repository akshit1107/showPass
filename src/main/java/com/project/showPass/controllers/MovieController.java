package com.project.showPass.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.showPass.dtos.request.MovieRequest;
import com.project.showPass.services.MovieService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/movie")
public class MovieController {
    
    @Autowired
    private MovieService movieService;

    @PostMapping("/add")
    public String postMethodName(@RequestBody MovieRequest movie) {
        return movieService.addMovie(movie);
    }
    

}
