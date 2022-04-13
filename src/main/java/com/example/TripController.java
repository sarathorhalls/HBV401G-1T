package com.example;

import java.util.Date;

public class TripController {

    private TourController tourController;
    private FlightController flightController;
    private HotelController hotelController;
    private Date currentDate;


    public TripController() {
        this.tourController = new MockTourController();
        this.flightController = new MockFlightController();
        this.hotelController = new MockHotelController();
        currentDate = new Date();
    }

    private Trip suggestedTrip;
    private Trip selectedTrip;

    public Trip search(Date arrivalDate, Date departureDate, int noOfTravelers, String flightDeparture, int tourBudget, int flightBudget, int hotelBudget) {
        try {
            testInputs(arrivalDate, departureDate, noOfTravelers, flightDeparture, tourBudget, flightBudget, hotelBudget);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Flight[] flights = flightController.search(arrivalDate, departureDate, noOfTravelers, flightDeparture, flightBudget);
        Tour[] tours = tourController.search(arrivalDate, departureDate, noOfTravelers, tourBudget);
        Hotel[] hotels = hotelController.search(arrivalDate, departureDate, noOfTravelers, flightBudget);
        suggestedTrip = new Trip(tours, flights, hotels);
        return suggestedTrip;
    }

    public Trip search(Date arrivalDate, Date departureDate, int noOfTravelers, String flightDeparture, int totalBudget) {
        return search(arrivalDate, departureDate, noOfTravelers, flightDeparture, totalBudget, totalBudget, totalBudget);
    }

    public void createBooking(Trip bookedTrip) {
        this.selectedTrip = bookedTrip;
        for (Tour tour : selectedTrip.getTours()) {
            tourController.Book(tour);
        }
        for (Flight flight : selectedTrip.getFlights()) {
            flightController.Book(flight);
        }
        for (Hotel hotel : selectedTrip.getHotels()) {
            hotelController.Book(hotel);
        }
    }

    public void testInputs(Date arrivalDate, Date departureDate, int noOfTravelers, String flightDeparture, int tourBudget, int flightBudget, int hotelBudget) throws Exception{
        if (arrivalDate.before(currentDate)) {
            throw new Exception("Arrival date cannot be earlier than today.");
        }
        if (departureDate.before(arrivalDate)) {
            throw new Exception("Departure date cannot be earlier than arrival date.");
        }
        if (noOfTravelers < 1) {
            throw new Exception("There must be atleast one traveler.");
        }
        if (flightDeparture.equals(null) || flightDeparture.isEmpty()) {
            throw new Exception("No departure selected.");
        }
        if (tourBudget <= 0) {
            throw new Exception("Tour budget cannot be less than 1.");
        }
        if (flightBudget <= 0) {
            throw new Exception("Flight budget cannot be less than 1.");
        }
        if (hotelBudget <= 0) {
            throw new Exception("Hotel budget cannot be less than 1.");
        }
    }

    public static void main( String[] args ) {
        System.out.println("Hello World!");
    }

    public Trip getSelectedTrip() {
        return selectedTrip;
    }

    public Trip getSuggesetdTrip() {
        return suggestedTrip;
    }

    public TourController getTourController() {
        return tourController;
    }

    public FlightController getFlightController() {
        return flightController;
    }

    public HotelController getHotelController() {
        return hotelController;
    }
}
