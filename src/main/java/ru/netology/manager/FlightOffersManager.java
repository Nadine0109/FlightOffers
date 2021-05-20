package ru.netology.manager;

import ru.netology.domain.FlightOffer;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.OffersRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class FlightOffersManager {
    private OffersRepository repository;


    public FlightOffersManager(OffersRepository repository) {
        this.repository = repository;
    }

    public void add(FlightOffer ticket) {
        repository.save(ticket);
    }

    public FlightOffer[] getAllValid(String from, String to) {

        FlightOffer[] allTickets = repository.findAll();
        List<FlightOffer> validTickets = new ArrayList<>();
        for (FlightOffer ticket : allTickets) {
            if (from.equals(ticket.getDepartureAirport()) && to.equals(ticket.getArrivalAirport())) {
                validTickets.add(ticket);
            }
        }
        FlightOffer[] result = validTickets.toArray(new FlightOffer[0]);
        if (result.length == 0) {
            throw new NotFoundException ("No tickets from " + from +" to " + to + " were found");
        }

        Arrays.sort(result);

        return result;
    }
}