package is.hi.tripplanner.vinnsla;

import java.util.Random;

public class Hotel {
    private long hotelID;

    public Hotel() {
        hotelID = new Random().nextLong();
    }

    public long getHotelID() {
        return hotelID;
    }
}
