module is.hi.tripplanner {
    requires javafx.controls;
    requires javafx.fxml;

    opens is.hi.tripplanner.vidmot to javafx.fxml;

    exports is.hi.tripplanner.vidmot;
}
