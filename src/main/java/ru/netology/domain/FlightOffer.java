package ru.netology.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class FlightOffer implements Comparable<FlightOffer> {
    private int id;
    private int price;
    private int flightTimeInMinutes;
    private String departureAirport;
    private String arrivalAirport;


    @Override
    public int compareTo(FlightOffer o) {
        return price - o.price;
    }
}

