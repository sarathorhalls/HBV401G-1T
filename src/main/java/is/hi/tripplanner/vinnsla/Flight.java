package is.hi.tripplanner.vinnsla;

import java.util.Random;

public class Flight {
    private long flightID;
    private String Departure;
    private String destination;
    private int arrivalDate;
    private int departureDate;
    private int price;
    private int availableSeats;

    public Flight() {
        this.flightID = new Random().nextLong();
    }

    public long getFlightID() {
        return this.flightID;
    }
}
