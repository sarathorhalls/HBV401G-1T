package is.hi.tripplanner.vinnsla;

import java.util.ArrayList;
import java.util.Date;

public class MockTourController implements TourController {

    private ArrayList<Tour> bookedTours;

    public MockTourController() {
        bookedTours = new ArrayList<Tour>();
    }

    @Override
    public Tour[] search(Date arrivalDate, Date departureDate, int noOfTravelers, int tourBudget) {
        Tour[] testTour = new Tour[5];
        for (int i = 0; i < testTour.length; i++) {
            testTour[i] = new Tour();
        }
        return testTour;
    }

    @Override
    public void Book(Tour tour) {
        bookedTours.add(tour);

    }

    @Override
    public boolean booked(long tourID) {
        for (Tour tour : bookedTours) {
            if (tour.getTourID() == tourID) {
                return true;
            }
        }
        return false;
    }

}
