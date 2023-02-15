package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.stage.Stage;

public class GetParameters extends Application {

    @Override
    public void start(Stage window) {
        Parameters params = getParameters();
        String organization = params.getNamed().get("organization");
        String course = params.getNamed().get("course");

        window.setTitle(organization + ": " + course);
        window.show();
    }

    // public static void main(String[] args) {
    //     Application.launch(GetParameters.class,
    //             "--organization=Once upon a time",
    //             "--course=Title");
    // }
}
