package com.example;

import java.util.Date;

public interface FlightController {
    public Flight[] search(Date arrivalDate, Date departurDate, int noOfTravelers, String flightDeparture, int flightBudget);
    public void Book(Flight flight);
    public boolean booked(long flightID);
}
