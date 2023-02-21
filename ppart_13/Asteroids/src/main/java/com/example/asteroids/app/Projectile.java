package com.example.asteroids.app;

import javafx.scene.shape.Polygon;

public class Projectile extends Character {

    public Projectile(int x, int y) {
        super(new Polygon(2, -2, 2, 2, -2, 2, -2, -2), x, y);
    }

    @Override
    public void move() {
        this.getCharacter().setTranslateX(this.getCharacter().getTranslateX() + this.getMovement().getX());
        this.getCharacter().setTranslateY(this.getCharacter().getTranslateY() + this.getMovement().getY());

        double x = this.getCharacter().getTranslateX();
        double y = this.getCharacter().getTranslateY();

        if (this.getCharacter().getTranslateX() < 0) {
            this.setAlive(false);
        }

        if (x < 0 || x > AsteroidsApplication.WIDTH || y < 0 || y > AsteroidsApplication.HEIGHT) {
            this.setAlive(false);
        }
    }
}
