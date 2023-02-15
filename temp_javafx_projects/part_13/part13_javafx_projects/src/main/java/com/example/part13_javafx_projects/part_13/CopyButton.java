package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class CopyButton extends Application {

    @Override
    public void start(Stage window) {
        TextField left = new TextField();
        TextField right = new TextField();
        Button btn = new Button("Copy");

        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                right.setText(left.getText());
                System.out.println("[" + left.getText() + "]" + " copied!");
            }
        });

        // lambda version
        // btn.setOnAction((event) -> {
        //     right.setText(left.getText());
        // });

        HBox components = new HBox();
        components.setSpacing(20);
        components.getChildren().addAll(left, btn, right);

        Scene scene = new Scene(components);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(CopyButton.class);
    }
}
