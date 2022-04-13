package com.example;

import java.util.Date;
import java.util.Random;

public class Tour {
    private long tourID;
    private int tourDuration;
    private int maximumCapacity;
    private int currentCapacity;
    private Date[] tourDates;
    private String language;
    private int price;
    private int priority;

    public Tour() {
        this.tourID = new Random().nextLong();
    }

    public long getTourID() {
        return this.tourID;
    }
}
