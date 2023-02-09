import java.util.ArrayList;

public class BoxWithMaxWeight extends Box {

    private int capacity;
    private ArrayList<Item> contents;


    public BoxWithMaxWeight(int capacity) {
        this.capacity = capacity;
        this.contents = new ArrayList<>();
    }


    @Override
    public void add(Item item) {
        if (item.getWeight() + this.weightOfBox() <= this.capacity) {
            contents.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return contents.contains(item);
    }

    @Override
    public String toString() {
        for (Item item : this.contents) {
            System.out.println(item);
        }
        return "";
    }

    private int weightOfBox() {
        int currentWeight = 0;
        for (Item content : this.contents) {
            currentWeight +=content.getWeight();
        }
        return currentWeight;
    }
}
