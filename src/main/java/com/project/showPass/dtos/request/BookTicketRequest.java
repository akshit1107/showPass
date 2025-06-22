package com.project.showPass.dtos.request;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import lombok.Data;

@Data
public class BookTicketRequest {
    
    private String movieName;
    private LocalDate showDate;
    private LocalTime showTime;
    private List<String> seatNumbers;
    private Integer theaterId;
    private String mobileNumber;

}
