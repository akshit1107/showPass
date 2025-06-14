package com.project.showPass.models;

import java.time.LocalDate;

import com.project.showPass.enums.Genre;
import com.project.showPass.enums.Language;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "movies")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Movie {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer movie_id;

    private String movie_name;

    private double duration; // in minutes

    @Enumerated(EnumType.STRING) //EnumType.ORDINAL stores the enum as an integer
    private Genre genre;

    @Enumerated(EnumType.STRING)
    private Language language;

    private LocalDate release_date;

    private double rating;
}
