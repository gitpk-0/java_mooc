package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MultipleViews extends Application {

    public void start(Stage window) {

        // first scene
        BorderPane layout1 = new BorderPane();
        TextField text1 = new TextField("First view!");
        Button btn1 = new Button("To the second view!");
        layout1.setTop(text1);
        layout1.setCenter(btn1);

        // second scene
        VBox layout2 = new VBox();
        Button btn2 = new Button("To the third view!");
        TextField text2 = new TextField("Second view!");
        layout2.getChildren().addAll(btn2, text2);

        // third scene
        GridPane layout3 = new GridPane();
        TextField text3 = new TextField("Third view!");
        Button btn3 = new Button("To the first view!");
        layout3.add(text3,0,0);
        layout3.add(btn3,1,1);

        // Scenes
        Scene first = new Scene(layout1);
        Scene second = new Scene(layout2);
        Scene third = new Scene(layout3);

        // Events
        btn1.setOnAction((event) -> {
            window.setScene(second);
        });

        btn2.setOnAction((event) -> {
            window.setScene(third);
        });

        btn3.setOnAction((event) -> {
            window.setScene(first);
        });

        window.setScene(first);
        window.show();
    }

    public static void main(String[] args) {
        launch(MultipleViews.class);
    }
}
