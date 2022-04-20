package is.hi.tripplanner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertThrows;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Before;
import org.junit.Test;

import is.hi.tripplanner.vinnsla.Flight;
import is.hi.tripplanner.vinnsla.Hotel;
import is.hi.tripplanner.vinnsla.Tour;
import is.hi.tripplanner.vinnsla.Trip;
import is.hi.tripplanner.vinnsla.TripController;

public class TestTripController {
    /*
    TripController tripController;
    private Date JAN_01_2023;
    private Date JAN_18_2023;
    private Date JAN_01_2021;

    @Before
    public void setUp() throws ParseException {
        this.tripController = new TripController();

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-ddX");
        this.JAN_01_2023 = df.parse("2023-01-01Z");
        this.JAN_18_2023 = df.parse("2023-01-18Z");
        this.JAN_01_2021 = df.parse("2021-01-01Z");
    }

    @Test
    public void testExpectedSearchInput() {
        tripController.search(JAN_01_2023, JAN_18_2023, 5, "Miami", 450000);

        assertFalse(tripController.getSuggesetdTrip().equals(null));
    }

    @Test
    public void testIncorrectArrivalDate() {
        Throwable exception = assertThrows(Exception.class,
                () -> tripController.testInputs(JAN_01_2021, JAN_18_2023, 5, "Miami", 450000, 450000, 450000));
        assertEquals("Arrival date cannot be earlier than today.", exception.getMessage());
    }

    @Test
    public void testIncorrectDepartureDate() {
        Throwable exception = assertThrows(Exception.class,
                () -> tripController.testInputs(JAN_18_2023, JAN_01_2023, 5, "Miami", 450000, 450000, 450000));
        assertEquals("Departure date cannot be earlier than arrival date.", exception.getMessage());
    }

    @Test
    public void testIncorrectNoOfTravelers() {
        Throwable exception = assertThrows(Exception.class,
                () -> tripController.testInputs(JAN_01_2023, JAN_18_2023, 0, "Miami", 450000, 450000, 450000));
        assertEquals("There must be atleast one traveler.", exception.getMessage());
    }

    @Test
    public void testLessThanZeroNoOfTravelers() {
        Throwable exception = assertThrows(Exception.class,
                () -> tripController.testInputs(JAN_01_2023, JAN_18_2023, -5, "Miami", 450000, 450000, 450000));
        assertEquals("There must be atleast one traveler.", exception.getMessage());
    }

    @Test
    public void testIncorrectDeparted() {
        Throwable exception = assertThrows(Exception.class,
                () -> tripController.testInputs(JAN_01_2023, JAN_18_2023, 5, "", 450000, 450000, 450000));
        assertEquals("No departure selected.", exception.getMessage());
    }

    @Test
    public void testNullDeparted() {
        Throwable exception = assertThrows(Exception.class,
                () -> tripController.testInputs(JAN_01_2023, JAN_18_2023, 5, null, 450000, 450000, 450000));
        assertEquals("No departure selected.", exception.getMessage());
    }

    @Test
    public void testIncorrectTourBudget() {
        Throwable exception = assertThrows(Exception.class,
                () -> tripController.testInputs(JAN_01_2023, JAN_18_2023, 5, "Miami", 0, 450000, 450000));
        assertEquals("Tour budget cannot be less than 1.", exception.getMessage());
    }

    @Test
    public void testIncorrectFlightBudget() {
        Throwable exception = assertThrows(Exception.class,
                () -> tripController.testInputs(JAN_01_2023, JAN_18_2023, 5, "Miami", 450000, 0, 450000));
        assertEquals("Flight budget cannot be less than 1.", exception.getMessage());
    }

    @Test
    public void testIncorrectHotelBudget() {
        Throwable exception = assertThrows(Exception.class,
                () -> tripController.testInputs(JAN_01_2023, JAN_18_2023, 5, "Miami", 450000, 450000, 0));
        assertEquals("Hotel budget cannot be less than 1.", exception.getMessage());
    }

    @Test
    public void testLessThanZeroTourBudget() {
        Throwable exception = assertThrows(Exception.class,
                () -> tripController.testInputs(JAN_01_2023, JAN_18_2023, 5, "Miami", -5, 450000, 450000));
        assertEquals("Tour budget cannot be less than 1.", exception.getMessage());
    }

    @Test
    public void testLessThanZeroFlightBudget() {
        Throwable exception = assertThrows(Exception.class,
                () -> tripController.testInputs(JAN_01_2023, JAN_18_2023, 5, "Miami", 450000, -5, 450000));
        assertEquals("Flight budget cannot be less than 1.", exception.getMessage());
    }

    @Test
    public void testLessThanZeroHotelBudget() {
        Throwable exception = assertThrows(Exception.class,
                () -> tripController.testInputs(JAN_01_2023, JAN_18_2023, 5, "Miami", 450000, 450000, -5));
        assertEquals("Hotel budget cannot be less than 1.", exception.getMessage());
    }

    @Test
    public void testExpectedTripBooking() {
        Trip testTrip1 = tripController.search(JAN_01_2023, JAN_18_2023, 5, "Miami", 450000);
        tripController.createBooking(testTrip1);
        boolean matching = true;
        for (Tour tour : testTrip1.getTours()) {
            if (!tripController.getTourController().booked(tour.getTourId())) {
                matching = false;
            }
        }
        for (Flight flight : testTrip1.getFlights()) {
            if (!tripController.getFlightController().booked(flight.getFlightID())) {
                matching = false;
            }
        }
        for (Hotel hotel : testTrip1.getHotels()) {
            if (!tripController.getHotelController().booked(hotel.getHotelID())) {
                matching = false;
            }
        }
        assertTrue(matching);
    }

    @Test
    public void testIncorrectTourBooking() {
        Trip testTrip1 = tripController.search(JAN_01_2023, JAN_18_2023, 5, "Miami", 450000);
        tripController.createBooking(testTrip1);
        Trip testTrip2 = new Trip(new Tour[] { new Tour() },
                tripController.getSelectedTrip().getFlights(),
                tripController.getSelectedTrip().getHotels());
        boolean matching = true;
        for (Tour tour : testTrip2.getTours()) {
            if (!tripController.getTourController().booked(tour.getTourID())) {
                matching = false;
            }
        }
        for (Flight flight : testTrip2.getFlights()) {
            if (!tripController.getFlightController().booked(flight.getFlightID())) {
                matching = false;
            }
        }
        for (Hotel hotel : testTrip2.getHotels()) {
            if (!tripController.getHotelController().booked(hotel.getHotelID())) {
                matching = false;
            }
        }
        assertFalse(matching);
    }

    @Test
    public void testIncorrectFlightBooking() {
        Trip testTrip1 = tripController.search(JAN_01_2023, JAN_18_2023, 5, "Miami", 450000);
        tripController.createBooking(testTrip1);
        Trip testTrip3 = new Trip(tripController.getSelectedTrip().getTours(),
                new Flight[] { new Flight() },
                tripController.getSelectedTrip().getHotels());
        boolean matching = true;
        for (Tour tour : testTrip3.getTours()) {
            if (!tripController.getTourController().booked(tour.getTourID())) {
                matching = false;
            }
        }
        for (Flight flight : testTrip3.getFlights()) {
            if (!tripController.getFlightController().booked(flight.getFlightID())) {
                matching = false;
            }
        }
        for (Hotel hotel : testTrip3.getHotels()) {
            if (!tripController.getHotelController().booked(hotel.getHotelID())) {
                matching = false;
            }
        }
        assertFalse(matching);
    }

    @Test
    public void testIncorrectHotelBooking() {
        Trip testTrip1 = tripController.search(JAN_01_2023, JAN_18_2023, 5, "Miami", 450000);
        tripController.createBooking(testTrip1);
        Trip testTrip4 = new Trip(tripController.getSelectedTrip().getTours(),
                tripController.getSelectedTrip().getFlights(),
                new Hotel[] { new Hotel() });
        boolean matching = true;
        for (Tour tour : testTrip4.getTours()) {
            if (!tripController.getTourController().booked(tour.getTourID())) {
                matching = false;
            }
        }
        for (Flight flight : testTrip4.getFlights()) {
            if (!tripController.getFlightController().booked(flight.getFlightID())) {
                matching = false;
            }
        }
        for (Hotel hotel : testTrip4.getHotels()) {
            if (!tripController.getHotelController().booked(hotel.getHotelID())) {
                matching = false;
            }
        }
        assertFalse(matching);
    }
    */
}
