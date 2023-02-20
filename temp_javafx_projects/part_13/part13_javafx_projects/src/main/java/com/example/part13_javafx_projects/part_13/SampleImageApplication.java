package com.example.part13_javafx_projects.part_13;


import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.image.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class SampleImageApplication extends Application {

    @Override
    public void start(Stage stage) {

        Image imageFile = new Image("file:monalisa.png");
        // ImageView image = new ImageView(imageFile);

        // // flipping the image
        // image.setRotate(180);
        // image.setScaleX(0.5);
        // image.setScaleY(0.5);
        // image.setTranslateX(50);


        PixelReader pixels = imageFile.getPixelReader();

        int width = (int) imageFile.getWidth();
        int height = (int) imageFile.getHeight();

        WritableImage targetImage = new WritableImage(width, height);
        PixelWriter writer = targetImage.getPixelWriter();

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {

                Color pixelColor = pixels.getColor(x, y);
                double red = 1.0 - pixelColor.getRed();
                double green = 1.0 - pixelColor.getGreen();
                double blue = 1.0 - pixelColor.getBlue();
                double opacity = pixelColor.getOpacity();

                Color newColor = new Color(red, green, blue, opacity);

                writer.setColor(x, y, newColor);
            }
        }

        ImageView image = new ImageView(targetImage);

        Pane frame = new Pane();
        frame.getChildren().add(image);

        stage.setScene(new Scene(frame));
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
