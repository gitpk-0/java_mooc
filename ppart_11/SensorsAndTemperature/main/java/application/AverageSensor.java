package application;

import java.util.ArrayList;
import java.util.List;

public class AverageSensor implements Sensor {

    private List<Sensor> sensors;
    private List<Integer> readings;

    public AverageSensor() {
        this.sensors = new ArrayList<>();
        this.readings = new ArrayList<>();
    }

    public void addSensor(Sensor toAdd) {
        sensors.add(toAdd);
    }


    @Override
    public boolean isOn() {
        for (Sensor sensor : sensors) {
            if (!sensor.isOn()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void setOn() {
        sensors.stream().forEach(sensor -> sensor.setOn());
    }

    @Override
    public void setOff() {
        sensors.stream().forEach(sensor -> sensor.setOff());
    }

    @Override
    public int read() {
        if (this.isOn()) {
            int reading = sensors.stream().mapToInt(sensor -> sensor.read()).sum() / sensors.size();
            readings.add(reading);
            return reading;
        } else {
            throw new IllegalStateException("The AverageSensor is off, or no sensors have been added.");
        }
    }

    public List<Integer> readings() {
        return readings;
    }
}
