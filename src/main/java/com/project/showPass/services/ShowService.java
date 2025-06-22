package com.project.showPass.services;

import com.project.showPass.dtos.request.AddShowRequest;
import com.project.showPass.dtos.request.AddShowSeatsRequest;
import com.project.showPass.enums.SeatType;
import com.project.showPass.models.Movie;
import com.project.showPass.models.Show;
import com.project.showPass.models.ShowSeat;
import com.project.showPass.models.Theater;
import com.project.showPass.models.TheaterSeat;
import com.project.showPass.repositories.MovieRepository;
import com.project.showPass.repositories.ShowRepository;
import com.project.showPass.repositories.ShowSeatRepository;
import com.project.showPass.repositories.TheaterRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ShowService {

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

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

    public String addShowSeats(AddShowSeatsRequest addShowSeatsRequest) {
        Integer showId = addShowSeatsRequest.getShowId();
        Optional<Show> show = showRepository.findById(showId);
        if (show.isEmpty()) {
            return "There is no show with show id: " + showId;
        }
        Show showEntity = show.get();

        Theater theater = showEntity.getTheater();
        List<TheaterSeat> theaterSeats = theater.getTheaterSeatList();

        //Goal is to add seats to the show

        List<ShowSeat> showSeats = new ArrayList<>();

        for(TheaterSeat theaterSeat : theaterSeats) {
            ShowSeat showSeat = ShowSeat.builder()
                    .seatNumber(theaterSeat.getSeatNumber())
                    .seatType(theaterSeat.getSeatType())
                    .isAvailable(true) // Initially all seats are available
                    .show(showEntity)
                    .build();
            if(theaterSeat.getSeatType().equals(SeatType.CLASSIC)) {
                showSeat.setSeatPrice(addShowSeatsRequest.getPriceClassic()); // Set price for classic seats
            }else if(theaterSeat.getSeatType().equals(SeatType.PREMIUM)) {
                showSeat.setSeatPrice(addShowSeatsRequest.getPricePremium()); // Set price for premium seats
            } else if(theaterSeat.getSeatType().equals(SeatType.LUXURY)) {
                showSeat.setSeatPrice(addShowSeatsRequest.getPriceLuxury()); // Set price for luxury seats
            }
            showSeats.add(showSeat);
        }
        showSeatRepository.saveAll(showSeats);
        return "Show seats added successfully for given show id: " + showId;
    }


}
