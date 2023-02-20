package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SmileyApplication extends Application {

    @Override
    public void start(Stage stage) {
        Canvas paintingCanvas = new Canvas(800, 800);
        GraphicsContext painter = paintingCanvas.getGraphicsContext2D();

        BorderPane paintingLayout = new BorderPane();
        paintingLayout.setCenter(paintingCanvas);

        painter.fillRect(200, 200, 100, 100);
        painter.fillRect(500, 200, 100, 100);
        painter.fillRect(100, 500, 100, 100);
        painter.fillRect(200, 600, 400, 100);
        painter.fillRect(600, 500, 100, 100);

        Scene view = new Scene(paintingLayout);

        stage.setScene(view);
        stage.show();

    }


    public static void main(String[] args) {
        launch(SmileyApplication.class);
    }

}