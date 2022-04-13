package com.example;

import java.util.Date;

public interface TourController {
    public Tour[] search(Date arrivalDate, Date departurDate, int noOfTravelers, int tourBudget);
    public void Book(Tour tour);
    public boolean booked(long tourID);
}
