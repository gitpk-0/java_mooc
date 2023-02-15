package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GridPaneApp extends Application {

    @Override
    public void start(Stage window) {
        GridPane layout = new GridPane();

        for (int x = 1; x <= 20; x++) {
            for (int y = 1; y <= 20; y++) {
                layout.add(new Button("" + x + ", " + y), x, y);
            }
        }

        Scene view = new Scene(layout);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(GridPaneApp.class);
    }




}
