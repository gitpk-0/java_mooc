package com.example.part13_javafx_projects.part_13;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class VPInputView {

    public VPDictionary dictionary;

    public VPInputView(VPDictionary dictionary) {
        this.dictionary = dictionary;
    }

    public Parent getView() {
        GridPane layout = new GridPane();

        Label wordInstruction = new Label("Word");
        TextField wordField = new TextField();
        Label translationInstruction = new Label("Translation");
        TextField translationField = new TextField();

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10));
        // layout.setPadding(new Insets(10, 10, 10, 10));

        Button addButton = new Button("Add the word pair");

        layout.add(wordInstruction,0,0);
        layout.add(wordField,0,1);
        layout.add(translationInstruction,0,2);
        layout.add(translationField,0,3);
        layout.add(addButton,0,4);

        // events
        addButton.setOnMouseClicked((click) -> {
            String word = wordField.getText();
            String translation = translationField.getText();

            dictionary.add(word, translation);

            wordField.clear();
            translationField.clear();
        });

        return layout;
    }

}
