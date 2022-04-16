package is.hi.tripplanner.vinnsla;

import java.util.Date;

public interface HotelController {
    public Hotel[] search(Date arrivalDate, Date departurDate, int noOfTravelers, int flightBudget);

    public void Book(Hotel hotel);

    public boolean booked(long flightID);
}
