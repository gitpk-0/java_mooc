package com.example.part13_javafx_projects.part_13;
// package.buttonandtexfield;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.FlowPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ButtonAndTextFieldApplication extends Application {

    @Override
    public void start(Stage window) {
        Button button = new Button("Submit");
        TextField name = new TextField();
        name.setPromptText("Enter your first name.");

        FlowPane compGrp = new FlowPane();
        compGrp.getChildren().add(name);
        compGrp.getChildren().add(button);

        Scene view = new Scene(compGrp);

        window.setScene(view);
        window.show();
    }


    public static void main(String[] args) {
        launch(ButtonAndTextFieldApplication.class);
    }
}
