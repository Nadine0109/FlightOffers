package ru.netology.repository;

import ru.netology.domain.FlightOffer;

public class OffersRepository {
    private FlightOffer[] tickets = new FlightOffer[0];

    public void save(FlightOffer ticket) {
        int length = tickets.length + 1;
        FlightOffer [] tmp = new FlightOffer[length];
        System.arraycopy(tickets, 0, tmp, 0, tickets.length);
        int lastIndex = tmp.length - 1;
        tmp[lastIndex] = ticket;
        tickets = tmp;
    }

    public FlightOffer[] findAll() {
        return tickets;
    }


    public FlightOffer findById(int id) {
        for (FlightOffer ticket : tickets) {
            if (ticket.getId() == id) {
                return ticket;
            }
        }
        return null;
    }

    public FlightOffer[] removeById(int id) {
        int length = tickets.length - 1;
        FlightOffer[] tmp = new FlightOffer[length];
        int index = 0;
        for (FlightOffer ticket : tickets) {
            if (ticket.getId() != id) {
                tmp[index] = ticket;
                index++;
            }
        }
        tickets = tmp;
        return tickets;
    }
}
