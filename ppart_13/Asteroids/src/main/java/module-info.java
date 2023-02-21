module com.example.asteroids {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.asteroids to javafx.fxml;
    exports com.example.asteroids;
    exports com.example.asteroids.app;
    opens com.example.asteroids.app to javafx.fxml;
}