package com.example.asteroids.app;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

import java.security.Key;
import java.util.HashMap;
import java.util.Map;

public class AsteroidsApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Pane pane = new Pane();
        pane.setPrefSize(600, 400);

        // Ship
        Polygon ship = new Polygon(-5, -5, 10, 0, -5, 5);
        // center of screen
        ship.setTranslateX(300);
        ship.setTranslateY(200);
        ship.setRotate(30); // 30 degrees

        pane.getChildren().add(ship);

        Scene scene = new Scene(pane);

        // Events

        Map<KeyCode, Boolean> pressedKeys = new HashMap<>();

        scene.setOnKeyPressed(event -> {
            pressedKeys.put(event.getCode(), Boolean.TRUE);
        });

        scene.setOnKeyReleased(event -> {
            pressedKeys.put(event.getCode(), Boolean.FALSE);
        });

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (pressedKeys.getOrDefault(KeyCode.LEFT, false)) {
                    ship.setRotate(ship.getRotate() - 5);
                }

                if (pressedKeys.getOrDefault(KeyCode.RIGHT, false)) {
                    ship.setRotate(ship.getRotate() + 5);
                }
            }
        }.start();



        stage.setTitle("Asteroids!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
