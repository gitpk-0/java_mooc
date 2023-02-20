module com.example.part13_javafx_projects {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;


    opens com.example.part13_javafx_projects to javafx.fxml;
    exports com.example.part13_javafx_projects;
    exports com.example.part13_javafx_projects.part_13;
    opens com.example.part13_javafx_projects.part_13 to javafx.fxml;
}