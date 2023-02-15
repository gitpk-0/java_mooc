package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class PasswordProtectedApplication extends Application {

    public void start(Stage window) {
        // loginPage scene
        BorderPane pane = new BorderPane();
        VBox layout = new VBox();
        layout.setSpacing(10);

        Label passwordPrompt = new Label("Please enter your password");
        PasswordField password = new PasswordField();
        Button loginBtn = new Button("Login");
        Label incorrectPwd = new Label("");

        layout.getChildren().addAll(passwordPrompt, password, loginBtn, incorrectPwd);
        layout.setAlignment(Pos.CENTER);
        layout.setPadding(new Insets(20, 20, 20, 20));
        pane.setCenter(layout);

        // home page (successful login)
        BorderPane home = new BorderPane();
        Label success = new Label("You've successfully logged in!");
        home.setCenter(success);
        home.setPadding(new Insets(20, 20, 20, 20));

        // Scenes
        Scene loginPage = new Scene(pane, 300, 300);
        Scene homePage = new Scene(home, 300, 300);

        // Events
        loginBtn.setOnAction((event) -> {
            String test = password.textProperty().getValue();
            String validate = "password"; // Correct Password
            if (test.equals(validate)) {
                window.setScene(homePage);
            } else {
                incorrectPwd.setText("Incorrect Password!");
                return;
            }
        });



        window.setScene(loginPage);
        window.show();
    }

    public static void main(String[] args) {
        launch(PasswordProtectedApplication.class);
    }
}
