import java.util.ArrayList;

public class Herd implements Movable {

    private ArrayList<Movable> organisms;

    public Herd() {
        this.organisms = new ArrayList<>();
    }

    public void addToHerd(Movable movable) {
        organisms.add(movable);
    }

    @Override
    public void move(int dx, int dy) {
        for (Movable organism : this.organisms) {
            organism.move(dx, dy);
        }
    }

    @Override
    public String toString() {
        String output = "";

        for (Movable organism : this.organisms) {
            output = output + organism + "\n";
        }

        return output;
    }
}
