package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.FlightOffer;
import ru.netology.repository.NotFoundException;
import ru.netology.repository.OffersRepository;

import static org.junit.jupiter.api.Assertions.*;


class FlightOffersManagerTest {
    private OffersRepository repository = new OffersRepository();
    private FlightOffersManager manager = new FlightOffersManager(repository);
    private FlightOffer first = new FlightOffer(7, 8000, 240, "DME", "BTK");
    private FlightOffer second = new FlightOffer(3, 15000, 530, "GDX", "HTA");
    private FlightOffer third = new FlightOffer(8, 3500, 120, "KGP", "LDG");
    private FlightOffer forth = new FlightOffer(16, 39000, 470, "OGZ", "PEX");
    private FlightOffer fifth = new FlightOffer(52, 6415, 311, "OVB", "VUS");
    private FlightOffer sixth = new FlightOffer(94, 8103, 203, "UFA", "EIE");
    private FlightOffer seventh = new FlightOffer(6, 23000, 244, "GRV", "VKO");
    private FlightOffer eighth = new FlightOffer(64, 5670, 110, "AMV", "NER");
    private FlightOffer ninth = new FlightOffer(73, 24740, 369, "GRV", "VKO");
    private FlightOffer tenth = new FlightOffer(45, 4070, 370, "GRV", "VKO");
    private FlightOffer eleventh = new FlightOffer(37, 19560, 340, "GRV", "VKO");


    @Test
    void shouldThrowExceptionWhenNothingIsFound() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        String from = "VUS";
        String to = "OGZ";

        assertThrows(NotFoundException.class, () -> {
                    manager.getAllValid(from, to);
                }
        );
    }

    @Test
    void shouldGetOneValidOffer() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        String from = "DME";
        String to = "BTK";

        FlightOffer[] actual = manager.getAllValid(from, to);
        FlightOffer[] expected = new FlightOffer[]{first};

        assertArrayEquals(actual, expected);
    }


    @Test
    void shouldGetSeveralValidOffers() {
        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.add(forth);
        manager.add(fifth);
        manager.add(sixth);
        manager.add(seventh);
        manager.add(eighth);
        manager.add(ninth);
        manager.add(tenth);
        manager.add(eleventh);

        String from = "GRV";
        String to = "VKO";

        FlightOffer[] actual = manager.getAllValid(from, to);
        FlightOffer[] expected = new FlightOffer[]{tenth, eleventh, seventh, ninth};

        assertArrayEquals(actual, expected);
    }

}