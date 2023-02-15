package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Arrays;

public class TextStatisticsApplication_2 extends Application {


    @Override
    public void start(Stage window) {
        BorderPane layout = new BorderPane();

        TextArea textArea = new TextArea();
        HBox text = new HBox();
        text.setSpacing(10);
        Label letters = new Label("Letters: ");
        Label words = new Label("Words: ");
        Label longestWord = new Label("The longest word is: ");

        text.getChildren().addAll(letters, words, longestWord);


        textArea.textProperty().addListener((change, oldVal, newVal) -> {
            letters.setText("Letters: " + newVal.length());
            String[] parts = newVal.split(" ");
            words.setText("Words: " + parts.length);

            String longest = Arrays.stream(parts)
                    .sorted((s1, s2) -> s2.length() - s1.length())
                    .findFirst()
                    .get();
            longestWord.setText("The longest word is: " + longest);
        });


        layout.setBottom(text);
        layout.setCenter(textArea);

        Scene view = new Scene(layout, 500, 500);

        window.setScene(view);
        window.show();

    }

    public static void main(String[] args) {
        launch(TextStatisticsApplication_2.class);
    }
}
