import java.util.ArrayList;

public class Suitcase {

    private int maxWeight;
    private ArrayList<Item> items;

    public Suitcase(int maxWeight) {
        this.maxWeight = maxWeight;
        this.items = new ArrayList<>();
    }

    public int totalWeight() {
        int totalWeight = 0;

        for (Item item: this.items) {
            totalWeight += item.getWeight();
        }
        return totalWeight;
    }

    public Item heaviestItem() {
        if (this.items.isEmpty()) {
            return null;
        }

        Item heaviestItem = this.items.get(0);
        for (Item item: this.items) {
            if (item.getWeight() > heaviestItem.getWeight()) {
                heaviestItem = item;
            }
        }
        return heaviestItem;
    }

    public void addItem(Item item) {
        if (this.totalWeight() + item.getWeight() <= this.maxWeight) {
            this.items.add(item);
        }
    }

    public void printItems() {
        for (Item item: this.items) {
            System.out.println(item);
        }
    }

    public String toString() {
        int size = this.items.size();
        int totalWeight = this.totalWeight();

        if (size == 0) {
            return "no items (" + totalWeight + " kg)";
        } else if (size == 1) {
            return size + " item (" + totalWeight + " kg)";
        }
        return size + " items (" + totalWeight + " kg)";
    }
}
