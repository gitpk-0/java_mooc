package com.example.part13_javafx_projects.part_13;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class VPPracticeView {

    private VPDictionary dictionary;
    private String word;

    public VPPracticeView(VPDictionary dictionary) {
        this.dictionary = dictionary;
        this.word = this.dictionary.getRandomWord();
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label prompt = new Label("Translate the word '" + this.word + "'");
        TextField inputField = new TextField();
        Button check = new Button("Check");
        Label feedback = new Label("");
        Button switchDirection = new Button("Switch Direction");

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10));
        layout.setPadding(new Insets(10, 10, 10, 10));

        layout.add(prompt,0,0);
        layout.add(inputField,0,1);
        layout.add(check,0,2);
        layout.add(feedback,0,3);
        layout.add(switchDirection,0,4);


        check.setOnMouseClicked((click) -> {
            String attempt = inputField.getText();
            String answer = dictionary.get(this.word);

            // check if attempt is correct
            if (attempt.equals(answer)) {
                feedback.setText("Correct!");

                this.word = this.dictionary.getRandomWord();
                prompt.setText("Translate the word '" + this.word + "'");
                inputField.clear();
            } else {
                feedback.setText("Incorrect! The translation of the word  '" + this.word + "' is '" + answer + "'");
            }
        });

        switchDirection.setOnAction((click) -> {
            inputField.clear();
            this.dictionary.swapDict();
            this.word = this.dictionary.getRandomWord();
            prompt.setText("Translate the word '" + this.word + "'");
        });

        return layout;
    }

}
