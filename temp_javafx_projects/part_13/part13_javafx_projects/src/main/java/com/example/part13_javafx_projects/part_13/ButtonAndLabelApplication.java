package com.example.part13_javafx_projects.part_13;
// package buttonandlabel;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import javafx.application.Application;

public class ButtonAndLabelApplication extends Application {

    @Override
    public void start(Stage window) {
        Button buttonComponent = new Button();
        buttonComponent.setText("This is a button");

        Label labelComponent = new Label();
        labelComponent.setText("This is a label");

        FlowPane componentGroup = new FlowPane();
        componentGroup.getChildren().add(labelComponent);
        componentGroup.getChildren().add(buttonComponent);

        Scene view = new Scene(componentGroup);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(ButtonAndLabelApplication.class);
    }
}
