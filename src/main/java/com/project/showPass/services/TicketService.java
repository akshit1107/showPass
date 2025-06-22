package com.project.showPass.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.showPass.repositories.MovieRepository;
import com.project.showPass.repositories.ShowRepository;
import com.project.showPass.repositories.ShowSeatRepository;
import com.project.showPass.repositories.TheaterRepository;
import com.project.showPass.repositories.TicketRepository;
import com.project.showPass.repositories.UserRepository;
import com.project.showPass.dtos.request.BookTicketRequest;
import com.project.showPass.exceptions.SeatUnavailableException;
import com.project.showPass.models.Movie;
import com.project.showPass.models.Show;
import com.project.showPass.models.ShowSeat;
import com.project.showPass.models.Theater;
import com.project.showPass.models.Ticket;
import com.project.showPass.models.User;

@Service
public class TicketService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private ShowRepository showRepository;

    @Autowired
    private ShowSeatRepository showSeatRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TicketRepository ticketRepository;
    
    public Ticket bookTicket(BookTicketRequest bookTicketRequest) throws Exception {
        // find the show entity with showDate, showTime, Movie, and theaterId
        Movie movie = movieRepository.findMovie(bookTicketRequest.getMovieName());
        Theater theater = theaterRepository.findById(bookTicketRequest.getTheaterId()).get();

        
        Show show = showRepository.findShowByShowDateAndShowTimeAndMovieAndTheater( bookTicketRequest.getShowDate(),
                                                                                    bookTicketRequest.getShowTime(),
                                                                                    movie,
                                                                                    theater
                                                                                );

        Integer showId = show.getShowId();
        List<ShowSeat> showSeatList = showSeatRepository.findShowSeats(showId);

        // Calculate the total price based on seat numbers and other details
        int totalAmount = 0;
        boolean areAllSeatsAvailable = true;
        for (String seatNumber : bookTicketRequest.getSeatNumbers()) {
            for (ShowSeat showSeat : showSeatList) {
                if (showSeat.getSeatNumber().equals(seatNumber)) {
                    if (showSeat.isAvailable() == false) {
                        areAllSeatsAvailable = false;
                        break;
                    }
                    totalAmount += showSeat.getSeatPrice();
                }
            }
        }    
        if(areAllSeatsAvailable == false) {
            throw new SeatUnavailableException("The requested seats are not available.");
        }
        // Mark the seats as booked
        for (String seatNumber : bookTicketRequest.getSeatNumbers()) {
            for (ShowSeat showSeat : showSeatList) {
                if (showSeat.getSeatNumber().equals(seatNumber)) {
                    showSeat.setAvailable(false);
                }
            }
        }    

        // save the ticket details in the database

        User user = userRepository.findUserByMobileNumber(bookTicketRequest.getMobileNumber());

        Ticket ticket = Ticket.builder()
                .movieName(bookTicketRequest.getMovieName())
                .showDate(bookTicketRequest.getShowDate())
                .showTime(bookTicketRequest.getShowTime())
                .theaterNameAndAddress(theater.getTheaterName() + ", " + theater.getAddress())
                .totalAmount(totalAmount)
                .user(user) // Assuming user is set in the request
                .build();

        ticket = ticketRepository.save(ticket);
        // generate and return actual ticket response 
        return ticket;
    }

}
