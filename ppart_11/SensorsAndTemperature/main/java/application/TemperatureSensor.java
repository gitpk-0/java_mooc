package application;

import java.util.Random;

public class TemperatureSensor implements Sensor {

    private boolean isOn;

    public TemperatureSensor() {
        this.isOn = false;
    }

    @Override
    public boolean isOn() {
        return isOn;
    }

    @Override
    public void setOn() {
        this.isOn = true;
    }

    @Override
    public void setOff() {
        this.isOn = false;
    }

    @Override
    public int read() {
        Random random = new Random();
        if (this.isOn()) {
            return random.nextInt(61) - 30;
        } else {
            throw new IllegalStateException("The sensor is off. Turn sensor on to read temperature.");
        }
    }
}
