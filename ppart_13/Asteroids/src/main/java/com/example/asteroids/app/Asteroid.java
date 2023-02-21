package com.example.asteroids.app;

import javafx.scene.shape.Polygon;

public class Asteroid extends Character {

    public Asteroid(int x, int y) {
        super(new PolygonFactory().createPolygon(), x, y);
    }

    @Override
    public void accelerate() {
        double changeX = Math.cos(Math.toRadians(super.getCharacter().getRotate()));
        double changeY = Math.sin(Math.toRadians(super.getCharacter().getRotate()));

        changeX *= 0.05;
        changeY *= 0.05;

        super.movement = super.movement.add(changeX, changeY);
    }
}
