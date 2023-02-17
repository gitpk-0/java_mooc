package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class NotifierApplication extends Application {

    @Override
    public void start(Stage window) {
        VBox layout = new VBox();

        TextField input = new TextField();
        Button update = new Button("Update");
        Label text = new Label("");

        layout.getChildren().addAll(input, update, text);

        update.setOnAction((event) -> {
            text.setText(input.getText());
        });

        Scene scene = new Scene(layout, 250, 100);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(NotifierApplication.class);
    }
}
