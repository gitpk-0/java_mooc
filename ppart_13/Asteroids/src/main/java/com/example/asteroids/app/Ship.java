package com.example.asteroids.app;

import javafx.geometry.Point2D;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Shape;

public class Ship extends Character {

    public Ship(int x, int y) {
        super(new Polygon(-5, -5, 10, 0, -5, 5), x, y);
    }

    @Override
    public void accelerate() {
        double changeX = Math.cos(Math.toRadians(super.getCharacter().getRotate()));
        double changeY = Math.sin(Math.toRadians(super.getCharacter().getRotate()));

        changeX *= 0.005;
        changeY *= 0.005;

        super.setMovement(changeX, changeY);
    }

}
