package com.project.showPass.models;

import java.time.LocalDate;

import com.project.showPass.enums.Genre;
import com.project.showPass.enums.Language;

import jakarta.persistence.Column;
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
    @Column(name = "movie_id")
    private Integer movieId;

    @Column(name = "movie_name", nullable = false, unique = true)
    private String movieName;

    @Column(name = "duration", nullable = false)
    private double duration; // in minutes

    @Enumerated(EnumType.STRING) //EnumType.ORDINAL stores the enum as an integer
    private Genre genre;

    @Enumerated(EnumType.STRING)
    private Language language;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    private double rating;
}
