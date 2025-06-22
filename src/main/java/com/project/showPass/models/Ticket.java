package com.project.showPass.models;

import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.AllArgsConstructor;

@Entity
@Table
@Getter
@Setter
@NoArgsConstructor  
@Builder
@AllArgsConstructor
public class Ticket {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ticket_id")
    private String ticketId;

    @Column(name = "movie_name", nullable = false)
    private String movieName;

    @Column(name = "show_date", nullable = false)
    private LocalDate showDate;
    
    @Column(name = "show_time", nullable = false)
    private LocalTime showTime;

    @Column(name = "theater_name_and_address", nullable = false)
    private String theaterNameAndAddress;

    @Column(name = "total_amout", nullable = false)
    private Integer totalAmount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
