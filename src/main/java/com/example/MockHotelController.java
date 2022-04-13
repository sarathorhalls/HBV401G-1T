package com.example;

import java.util.ArrayList;
import java.util.Date;

public class MockHotelController implements HotelController {

    private ArrayList<Hotel> bookedHotels;

    public MockHotelController() {
        bookedHotels = new ArrayList<Hotel>();
    }

    @Override
    public Hotel[] search(Date arrivalDate, Date departureDate, int noOfTravelers, int flightBudget) {
        Hotel[] testHotel = new Hotel[5];
        for (int i = 0; i < testHotel.length; i++) {
            testHotel[i] = new Hotel();
        }
        return testHotel;
    }

    @Override
    public void Book(Hotel hotel) {
        bookedHotels.add(hotel);
        
    }

    @Override
    public boolean booked(long hotelID) {
        for (Hotel hotel : bookedHotels) {
            if (hotel.getHotelID() == hotelID) {
                return true;
            }
        }
        return false;
    }
    
}
