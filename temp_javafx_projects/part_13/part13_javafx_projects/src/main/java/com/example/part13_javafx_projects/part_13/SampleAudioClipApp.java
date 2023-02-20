package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

public class SampleAudioClipApp extends Application {

    @Override
    public void start(Stage stage) {

        AudioClip sound = new AudioClip("file:bell.wav");
        sound.play();

        stage.show();
    }

    public static void main(String[] args) {
        launch(SampleAudioClipApp.class);
    }
}
