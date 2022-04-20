package is.hi.tripplanner.vinnsla;

public class Tour {
    private int tourId;
    private int tourDuration;
    private int maxCapacity;
    private int currCapacity;
    private int date;
    private String language;
    private String category;
    private int cost;
    private int priority;

    public Tour(int tourId, int tourDuration, int maxCapacity, int currCapacity, int date, String language, String category, int cost, int priority) {
        this.tourId = tourId;
        this.tourDuration = tourDuration;
        this.maxCapacity = maxCapacity;
        this.currCapacity = currCapacity;
        this.date = date;
        this.language = language;
        this.category = category;
        this.cost = cost;
        this.priority = priority;
    }

    public int getTourId() {
        return tourId;
    }

    public int getTourDuration() {
        return tourDuration;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public int getCurrCapacity() {
        return currCapacity;
    }

    public int getDate() {
        return date;
    }

    public String getLanguage() {
        return language;
    }

    public String getCategory() {
        return category;
    }

    public int getCost() {
        return cost;
    }

    public int getPriority() {
        return priority;
    }
}
