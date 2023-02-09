public class Item {

    private String identifier;
    private String name;

    public Item(String identifier, String name) {
        this.identifier = identifier;
        this.name = name;
    }

    public boolean equals(Object compared) {
        // same memory address?
        if (this == compared) { return true; }

        // different object type?
        if (!(compared instanceof Item)) { return false; }

        // convert object
        Item comparedItem = (Item) compared;

        // same attributes?
        return this.identifier.equals(comparedItem.identifier);
    }

    public String toString() {
        return this.identifier + ": " + this.name;
    }
}
