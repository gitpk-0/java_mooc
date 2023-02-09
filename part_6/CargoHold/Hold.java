import java.util.ArrayList;

public class Hold {

    private int maxWeight;
    private ArrayList<Suitcase> luggage;

    public Hold(int maxWeight) {
        this.maxWeight = maxWeight;
        this.luggage = new ArrayList<>();
    }

    public int luggageTotalWeight() {
        int luggageTotalWeight = 0;
        for (Suitcase suitcase: this.luggage) {
            luggageTotalWeight += suitcase.totalWeight();
        }
        return luggageTotalWeight;
    }

    public void addSuitcase(Suitcase suitcase) {
        if (this.luggageTotalWeight() + suitcase.totalWeight() <= this.maxWeight) {
            this.luggage.add(suitcase);
        }
    }

    public void printItems() {
        for (Suitcase suitcase: this.luggage) {
            suitcase.printItems();
        }
    }

    public String toString() {
        int size = this.luggage.size();
        int luggageTotalWeight = this.luggageTotalWeight();

        if (size == 0) {
            return "no suitcases " + "(" + luggageTotalWeight + " kg)";
        } else if (size == 1) {
            return size + " suitcase (" + luggageTotalWeight + " kg)";
        }
        return size + " suitcases (" + luggageTotalWeight + " kg)";
    }
}
