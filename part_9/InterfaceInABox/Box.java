import java.util.ArrayList;

public class Box implements Packable {

    private double maxCapacity;
    private ArrayList<Packable> boxContents;

    public Box(double maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.boxContents = new ArrayList<>();
    }

    public void add(Packable packable) {
        if (this.weight() + packable.weight() <= this.maxCapacity) {
            boxContents.add(packable);
        }
    }

    @Override
    public double weight() {
        double currentWeight = 0;
        for (Packable item : this.boxContents) {
            currentWeight += item.weight();
        }

        return currentWeight;
    }

    @Override
    public String toString() {
        return "Box: " + this.boxContents.size() + " items, total weight " + this.weight() + " kg";
    }
}
