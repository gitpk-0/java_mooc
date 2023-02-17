package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class TextListenExample extends Application {

    @Override
    public void start(Stage window) {
        TextField left = new TextField();
        TextField right = new TextField();
        Button btn = new Button("Copy");

        // left.textProperty().addListener(new ChangeListener<String>() {
        //     @Override
        //     public void changed(ObservableValue<? extends String> change, String oldValue, String newValue) {
        //         System.out.println(oldValue + " -> " + newValue);
        //         right.setText(newValue);
        //     }
        // });

        // lambda
        left.textProperty().addListener((change, oldValue, newValue) -> {
            System.out.println(oldValue + " -> " + newValue);
            right.setText(newValue);
        });

        HBox components = new HBox();
        components.setSpacing(30);
        components.getChildren().addAll(left, right);

        Scene scene = new Scene(components, 400, 200);
        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(TextListenExample.class);
    }
}
