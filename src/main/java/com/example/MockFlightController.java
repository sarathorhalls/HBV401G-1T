package com.example;

import java.util.ArrayList;
import java.util.Date;

public class MockFlightController implements FlightController {

    public ArrayList<Flight> bookedFlights;

    public MockFlightController() {
        bookedFlights = new ArrayList<Flight>();
    }

    @Override
    public Flight[] search(Date arrivalDate, Date departureDate, int noOfTravelers, String flightDeparture, int flightBudget) {
        Flight[] testFlight = new Flight[5];
        for (int i = 0; i < testFlight.length; i++) {
            testFlight[i] = new Flight();
        }
        return testFlight;
    }

    @Override
    public void Book(Flight flight) {
        bookedFlights.add(flight);
        
    }

    @Override
    public boolean booked(long flightID) {
        for (Flight flight : bookedFlights) {
            if (flight.getFlightID() == flightID) {
                return true;
            }            
        }
        return false;
    }
    
}
