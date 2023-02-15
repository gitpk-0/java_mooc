package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GreeterApplication extends Application {

    @Override
    public void start(Stage window) {
        // components
        Label prompt = new Label("Enter your name and start.");
        TextField name = new TextField("");
        Button start = new Button("Start");

        // grid + components
        GridPane grid = new GridPane();
        grid.add(prompt,0,0);
        grid.add(name,0,1);
        grid.add(start,0,2);

        // styling
        grid.setPrefSize(300,180);
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(30);
        grid.setHgap(10);
        grid.setPadding(new Insets(20));


        // Greeting
        Label greet = new Label();

        // StackPane
        StackPane welcomeLayout = new StackPane();
        welcomeLayout.setPrefSize(300, 180);
        welcomeLayout.getChildren().add(greet);

        // Scenes
        Scene first = new Scene(grid);
        Scene greeting = new Scene(welcomeLayout);

        // Events
        start.setOnAction((event) -> {
            greet.setText("Welcome " + name.getText() + "!");
            window.setScene(greeting);
        });

        window.setScene(first);
        window.show();
    }

    public static void main(String[] args) {
        launch(GreeterApplication.class);
    }
}
