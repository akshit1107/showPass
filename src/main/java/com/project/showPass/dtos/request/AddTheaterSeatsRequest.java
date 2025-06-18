package com.project.showPass.dtos.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddTheaterSeatsRequest {
    private int noOfClassicSeats;
    private int noOfPremiumSeats;
    private int noOfLuxurySeats;
    private int theaterId;
}
