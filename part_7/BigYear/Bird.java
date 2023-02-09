import java.util.ArrayList;

public class Bird {

    final private String name;
    final private String latinName;
    private int observations;

    public Bird(String name, String latinName) {
        this.name = name;
        this.latinName = latinName;
        this.observations = 0;
    }

    public void addObservation() {
        this.observations++;
    }

    public String getBirdName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.latinName + "): " + this.observations + " observations";
    }
}
