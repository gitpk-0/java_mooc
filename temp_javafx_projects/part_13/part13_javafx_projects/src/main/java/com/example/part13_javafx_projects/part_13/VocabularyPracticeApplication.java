package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class VocabularyPracticeApplication extends Application {

    private VPDictionary dictionary;

    @Override
    public void init() throws Exception {
        this.dictionary = new VPDictionary();
    }

    @Override
    public void start(Stage window) throws Exception {
        VPPracticeView practiceView = new VPPracticeView(dictionary);
        VPInputView inputView = new VPInputView(dictionary);

        BorderPane layout = new BorderPane();

        HBox menu = new HBox();
        menu.setPadding(new Insets(20));
        menu.setSpacing(10);

        Button enterBtn = new Button("Enter new words");
        Button practiceButton = new Button("Practice");

        menu.getChildren().addAll(enterBtn, practiceButton);
        layout.setTop(menu);

        enterBtn.setOnAction((click) -> layout.setCenter(inputView.getView()));
        practiceButton.setOnAction((click) -> layout.setCenter(practiceView.getView()));

        // default view
        layout.setCenter(inputView.getView());

        Scene view = new Scene(layout, 400, 400);

        window.setScene(view);
        window.show();
    }

    public static void main(String[] args) {
        launch(VocabularyPracticeApplication.class);
    }
}
