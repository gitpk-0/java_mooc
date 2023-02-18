package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SavingsCalculatorApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        SavingsCalculatorUI ui = new SavingsCalculatorUI();

        BorderPane layout = new BorderPane();
        layout.setCenter(ui.getView());
        layout.setPadding(new Insets(20));

        Scene scene = new Scene(layout, 700, 700);

        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(SavingsCalculatorApplication.class);
    }



}
