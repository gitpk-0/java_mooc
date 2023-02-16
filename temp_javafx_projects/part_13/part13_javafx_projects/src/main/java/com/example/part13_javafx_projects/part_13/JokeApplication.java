package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JokeApplication extends Application {

    @Override
    public void start(Stage window) {

        BorderPane layout = new BorderPane();

        VBox menu = new VBox();
        menu.setPadding(new Insets(20));
        menu.setSpacing(10);

        Button jokeBtn = new Button("Joke");
        Button answerBtn = new Button("Answer");
        Button explBtn = new Button("Explanation");

        menu.getChildren().addAll(jokeBtn, answerBtn, explBtn);

        Label jokeLbl = new Label("What do you call a bear with no teeth?");
        Label answerLbl = new Label("A gummy bear.");
        Label explLbl = new Label("You can come up with a suitable explanation by yourself.");

        VBox joke = new VBox();
        joke.setPadding(new Insets(20));
        joke.setSpacing(10);
        joke.setAlignment(Pos.CENTER);
        joke.getChildren().add(jokeLbl);

        VBox answer = new VBox();
        answer.setPadding(new Insets(20));
        answer.setSpacing(10);
        answer.setAlignment(Pos.CENTER);
        answer.getChildren().add(answerLbl);

        VBox expl = new VBox();
        expl.setPadding(new Insets(20));
        expl.setSpacing(10);
        expl.setAlignment(Pos.CENTER);
        expl.getChildren().add(explLbl);

        layout.setLeft(menu);
        layout.setRight(joke);


        // Events
        jokeBtn.setOnAction((click) -> layout.setRight(joke));
        answerBtn.setOnAction((click) -> layout.setRight(answer));
        explBtn.setOnAction((click) -> layout.setRight(expl));


        Scene scene = new Scene(layout, 550, 130);

        window.setScene(scene);
        window.show();
    }

    public static void main(String[] args) {
        launch(JokeApplication.class);
    }
}
