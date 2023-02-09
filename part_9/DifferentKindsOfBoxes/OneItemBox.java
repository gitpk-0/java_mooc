import java.util.ArrayList;

public class OneItemBox extends Box {

    private ArrayList<Item> contents;

    public OneItemBox() {
        this.contents = new ArrayList<>();
    }

    @Override
    public void add(Item item) {
        if (this.contents.size() < 1) {
            contents.add(item);
        }
    }

    @Override
    public boolean isInBox(Item item) {
        return contents.contains(item);
    }
}
