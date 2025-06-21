package com.project.showPass.services;

import com.project.showPass.dtos.request.AddShowRequest;
import com.project.showPass.models.Movie;
import com.project.showPass.models.Show;
import com.project.showPass.models.Theater;
import com.project.showPass.repositories.MovieRepository;
import com.project.showPass.repositories.ShowRepository;
import com.project.showPass.repositories.TheaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@Service

public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    public String addShow(AddShowRequest addShowRequest) {
        //Build object of show entity and save it

        //Need to get movie and theater entity
        Movie movie = movieRepository.findMovie(addShowRequest.getMovieName());

        Optional<Theater> theater = theaterRepository.findById(addShowRequest.getTheaterId());
        if (theater.isEmpty()) {
            return "There is no theater with theater id: " + addShowRequest.getTheaterId();
        }
        Theater t = theater.get();

        Show show = Show.builder()
                .showDate(addShowRequest.getShowDate())
                .showTime(addShowRequest.getShowTime())
                .movie(movie)
                .theater(t)
                .build();
        showRepository.save(show);
        return "Show Added successfully.";
    }
}
