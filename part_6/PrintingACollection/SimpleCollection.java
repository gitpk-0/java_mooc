
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

    public String toString() {
        String printOutput = "The collection " + this.name;

        if (elements.isEmpty()) {
            return printOutput + " is empty.";
        }

        String elems = "";
        for (String element: elements) {
            if (elements.size() == 1) {
                elems = elems + element;
            } else if (elements.size() > 1) {
                elems = elems + element + "\n";
            }
        }

        if (elements.size() == 1) {
            printOutput = printOutput + " has 1 element:" + "\n" + elems;
        } else if (elements.size() > 1) {
            printOutput = printOutput + " has " + elements.size() + " elements:" + "\n" + elems;
        }

        return printOutput;
    }
    
}