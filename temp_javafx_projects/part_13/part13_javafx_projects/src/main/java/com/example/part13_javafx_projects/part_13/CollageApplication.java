package com.example.part13_javafx_projects.part_13;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class CollageApplication extends Application {


    @Override
    public void start(Stage stage) throws Exception {

        Image imageFile = new Image("file:monalisa.png");

        PixelReader pixels = imageFile.getPixelReader();

        int width = (int) imageFile.getWidth();
        int height = (int) imageFile.getHeight();

        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter writer = targetImage.getPixelWriter();

        for (int y = 0; y < height / 2; y++) {
            for (int x = 0; x < width / 2; x++) {

                // skip to every other pixel to downsize image
                Color pixelColor = pixels.getColor(x * 2, y * 2);

                // Negative (1.0 - color)
                double red = 1.0 - pixelColor.getRed();
                double green = 1.0 - pixelColor.getGreen();
                double blue = 1.0 - pixelColor.getBlue();

                double opacity = pixelColor.getOpacity();

                Color newColor = new Color(red, green, blue, opacity);

                writer.setColor(x, y, newColor); // top left
                writer.setColor(x + (width / 2), y, newColor); // top right
                writer.setColor(x, y + (height / 2), newColor); // bottom left
                writer.setColor(x + (width / 2), y + (height / 2), newColor); // bottom right
            }
        }

        ImageView main = new ImageView(imageFile);
        ImageView one = new ImageView(targetImage);

        Pane pane = new Pane();
        pane.getChildren().add(main);
        pane.getChildren().add(one);

        stage.setScene(new Scene(pane));
        stage.show();
    }

    public static void main(String[] args) {
        launch(CollageApplication.class);
        // launch(args);
    }
}
