package com.project.showPass.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.showPass.dtos.request.AddTheaterRequest;
import com.project.showPass.dtos.request.AddTheaterSeatsRequest;
import com.project.showPass.enums.SeatType;
import com.project.showPass.models.Theater;
import com.project.showPass.models.TheaterSeat;
import com.project.showPass.repositories.TheaterRepository;
import com.project.showPass.repositories.TheaterSeatRepository;

@Service
public class TheaterService {

    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private TheaterSeatRepository theaterSeatRepository;

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

    public String addTheaterSeats(AddTheaterSeatsRequest addTheaterSeatsRequest) {
        Optional<Theater> theater = theaterRepository.findById(addTheaterSeatsRequest.getTheaterId());
        if (!theater.isPresent()) {
            throw new RuntimeException("Theater with ID " + addTheaterSeatsRequest.getTheaterId() + " not found.");
        }

        int numClassSeats = addTheaterSeatsRequest.getNoOfClassicSeats();
        int numPremiumSeats = addTheaterSeatsRequest.getNoOfPremiumSeats();
        int numLuxurySeats = addTheaterSeatsRequest.getNoOfLuxurySeats();

        int classicCounter = 1;
        int premiumCounter = 1;
        int luxuryCounter = 1;

        char rowClassic = 'A'; // Current row character
        char rowPremium = 'A';
        char rowLuxury = 'A';

        List<TheaterSeat> allSeats = new ArrayList<>();

        while(classicCounter <= numClassSeats || 
              premiumCounter <= numPremiumSeats || 
              luxuryCounter <= numLuxurySeats) {
            if (classicCounter <= numClassSeats) {
                String classicSeat =  String.valueOf(rowClassic) + classicCounter;
                TheaterSeat classicSeatObj = TheaterSeat.builder()
                        .seatNumber(classicSeat)
                        .seatType(SeatType.CLASSIC)
                        .theater(theater.get())
                        .build();
                allSeats.add(classicSeatObj);
                classicCounter++;
                if(classicCounter % 5 == 0) {
                    rowClassic++;
                }
            }
            if (premiumCounter <= numPremiumSeats) {
                String premiumSeat = String.valueOf(rowPremium) + premiumCounter;
                TheaterSeat premiumSeatObj = TheaterSeat.builder()
                        .seatNumber(premiumSeat)
                        .seatType(SeatType.PREMIUM)
                        .theater(theater.get())
                        .build();
                allSeats.add(premiumSeatObj);
                premiumCounter++;
                if(premiumCounter % 5 == 0) {
                    rowPremium++;
                }
            }
            if (luxuryCounter <= numLuxurySeats) {
                String luxurySeat = String.valueOf(rowLuxury) + luxuryCounter;
                TheaterSeat luxurySeatObj = TheaterSeat.builder()
                        .seatNumber(luxurySeat)
                        .seatType(SeatType.LUXURY)
                        .theater(theater.get())
                        .build();
                allSeats.add(luxurySeatObj);
                luxuryCounter++;
                if(luxuryCounter % 5 == 0) {
                    rowLuxury++;
                }
            }
        }
        theaterSeatRepository.saveAll(allSeats);

        return "Seats added successfully for Theater ID: " + addTheaterSeatsRequest.getTheaterId();
    }
    
}
