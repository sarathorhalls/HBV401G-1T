package is.hi.tripplanner.vinnsla;

import java.sql.*;
import java.util.*;

public class TourController {

    private int maxPrice;
    private int noOfTravelers;
    private int departure;
    private int arrival;

    private ArrayList<Tour> tours;

    public TourController(int maxPrice, int noOfTravelers, int departure, int arrival) {

        this.maxPrice = maxPrice;
        this.noOfTravelers = noOfTravelers;
        this.departure = departure;
        this.arrival = arrival;

        tours = new ArrayList<Tour>();

    }


    public ArrayList<Tour> getTours() {

        maxPrice += 1;
        noOfTravelers -= 1;

        try {

            Connection conn = this.connect();
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM tours WHERE cost < ? " +
                    "AND " +
                    "currCapacity > ?" +
                    "AND " +
                    "date BETWEEN ? and ?;" ;

            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setInt(1, maxPrice);
            prep.setInt(2, noOfTravelers);
            prep.setInt(3, arrival);
            prep.setInt(4, departure);


            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                int tourId = rs.getInt("tourId");
                int tourDuration = rs.getInt("tourDuration");
                int maxCapacity = rs.getInt("maxCapacity");
                int currCapacity = rs.getInt("currCapacity");
                int date = rs.getInt("date");
                String language = rs.getString("language");
                String category = rs.getString("category");
                int cost = rs.getInt("cost");
                int priority = rs.getInt("priority");
                Tour t = new Tour(tourId, tourDuration, maxCapacity, currCapacity, date, language, category, cost, priority);
                tours.add(t);
                System.out.println(tourId + ", " + tourDuration + ", " + maxCapacity + ", " + currCapacity + ", " + date + ", " + language + ", " + category + ", " + cost + ", " + priority);
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }

        System.out.println("Search successful");

        return tours;

    }

    private Connection connect() {
        // SQLite connection string
        String url = "jdbc:sqlite:Tours.db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public void createDB() {
        try {

            Connection conn = this.connect();
            Statement stmt = conn.createStatement();

            String sql = "CREATE TABLE IF NOT EXISTS tours " +
                    "(tourId INTEGER PRIMARY KEY," +
                    " tourDuration INTEGER NOT NULL," +
                    " maxCapacity INTEGER NOT NULL," +
                    " currCapacity INTEGER NOT NULL," +
                    " date INTEGER NOT NULL," +
                    " language TEXT," +
                    " category TEXT," +
                    " cost INTEGER NOT NULL," +
                    " priority INTEGER ) " ;
            stmt.executeUpdate(sql);
            stmt.close();
            conn.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Table Product Created Successfully!!!");
    }

    public void select() {

        int selectedPrice = 10000;
        int daCap = 25;

        try {

            Connection conn = this.connect();
            Statement stmt = conn.createStatement();

            String sql = "SELECT * FROM tours WHERE cost < ? " +
                    "AND " +
                    "maxCapacity < ?;" ;

            PreparedStatement prep = conn.prepareStatement(sql);
            prep.setInt(1, selectedPrice);
            prep.setInt(2, daCap);


            ResultSet rs = prep.executeQuery();
            while (rs.next()) {
                int tourId = rs.getInt("tourId");
                int tourDuration = rs.getInt("tourDuration");
                int maxCapacity = rs.getInt("maxCapacity");
                int currCapacity = rs.getInt("currCapacity");
                int date = rs.getInt("date");
                String language = rs.getString("language");
                String category = rs.getString("category");
                int cost = rs.getInt("cost");
                int priority = rs.getInt("priority");
                System.out.println(tourId + ", " + tourDuration + ", " + maxCapacity + ", " + currCapacity + ", " + date + ", " + language + ", " + category + ", " + cost + ", " + priority);
            }
            rs.close();
            stmt.close();
            conn.close();
        }
        catch ( Exception e ) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        System.out.println("Selection successful");

    }


    public void insert(int tourId, int tourDuration, int maxCapacity, int currCapacity, int date, String language, String category, int cost, int priority) {
        String sql = "INSERT INTO tours VALUES(?,?,?,?,?,?,?,?,?)";

        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, tourId);
            pstmt.setInt(2, tourDuration);
            pstmt.setInt(3, maxCapacity);
            pstmt.setInt(4, currCapacity);
            pstmt.setInt(5, date);
            pstmt.setString(6, language);
            pstmt.setString(7, category);
            pstmt.setInt(8, cost);
            pstmt.setInt(9, priority);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Insertion successful");
    }

    public static void main(String[] args) {

        TourController tours = new TourController(10000, 2, 230922, 190922);

        /*
        tours.CreateDB();
        // insert three new rows
        tours.insert(1, 0600, 40, 16, 150822, "English", "Biking", 15000, 4);
        tours.insert(2, 0200, 16, 3, 200922, "Icelandic", "Biking", 4000, 2);
        tours.insert(3, 0500, 30, 10, 220922, "English", "Swimming", 9000, 3);
        */

        ArrayList<Tour> bla = new ArrayList<Tour>();

        bla = tours.getTours();

        System.out.println(bla.size());

    }

}
