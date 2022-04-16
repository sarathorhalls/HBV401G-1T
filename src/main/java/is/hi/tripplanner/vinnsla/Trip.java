package is.hi.tripplanner.vinnsla;

public class Trip {

    private Tour[] tours;
    private Flight[] flights;
    private Hotel[] hotels;

    public Trip(Tour[] tours, Flight[] flights, Hotel[] hotels) {
        this.tours = tours;
        this.flights = flights;
        this.hotels = hotels;
    }

    public Tour[] getTours() {
        return tours;
    }

    public Flight[] getFlights() {
        return flights;
    }

    public Hotel[] getHotels() {
        return hotels;
    }
}
