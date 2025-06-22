package com.project.showPass.models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.AllArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import com.project.showPass.enums.SeatType;

@Entity
@Table(name = "show_seats")
@Getter
@Setter
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class ShowSeat {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "seat_id")
    private Integer seatId;

    @Column(name = "seat_number", nullable = false)
    private String seatNumber;

    @Column(name = "seat_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private SeatType seatType;

    @Column(name = "seat_price", nullable = false)
    private Integer seatPrice;

    @Column(name = "is_available", nullable = false)
    private boolean isAvailable;

    @ManyToOne
    @JoinColumn(name = "show_id", nullable = false)
    private Show show;

}
