
import java.util.ArrayList;

public class SimpleCollection {

    private String name;
    private ArrayList<String> elements;

    public SimpleCollection(String name) {
        this.name = name;
        this.elements = new ArrayList<>();
    }

    public void add(String element) {
        this.elements.add(element);
    }

    public ArrayList<String> getElements() {
        return this.elements;
    }

    public String longest() {
        // return null reference if list is empty
        if (this.elements.isEmpty()) {
            return null;
        }

        String longest = this.elements.get(0);

        for (String elem: this.elements) {
            if (longest.length() < elem.length()) {
                longest = elem;
            }
        }

        return longest;
    }

}
