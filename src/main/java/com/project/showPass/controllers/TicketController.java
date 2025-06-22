package com.project.showPass.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.showPass.dtos.request.BookTicketRequest;
import com.project.showPass.models.Ticket;
import com.project.showPass.services.TicketService;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;
    
    @PostMapping("/bookTicket")
    public ResponseEntity<Object> bookTicket(@RequestBody BookTicketRequest bookTicketRequest) {
        try {
            Ticket ticket = ticketService.bookTicket(bookTicketRequest);
            return new ResponseEntity<>(ticket, HttpStatus.OK);
         } catch (Exception e) {
            String errMessage =  "Error while booking your ticket(s): " + e.getMessage();
            return new ResponseEntity<>(errMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
