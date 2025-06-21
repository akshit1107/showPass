package com.project.showPass.models;

import com.project.showPass.enums.SeatType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "theater_seats")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TheaterSeat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "theater_seat_id")
    private Integer theaterSeatId;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Enumerated(value = EnumType.STRING)
    @Column(name = "seat_type", nullable = false)
    private SeatType seatType;

    @JoinColumn(name = "theater_id") //Foreign key column
    @ManyToOne// Many seat to One theater
    private Theater theater;

}
