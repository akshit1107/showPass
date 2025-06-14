package com.project.showPass.dtos.request;

import java.time.LocalDate;

import com.project.showPass.enums.Genre;
import com.project.showPass.enums.Language;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class MovieRequest {

    private String movie_name;
    private LocalDate release_date;
    private Double duration; // Duration in minutes
    private Language language; // Use enum Language
    private Genre genre; // Use enum Genre
    private Double rating; // Rating out of 10

}
