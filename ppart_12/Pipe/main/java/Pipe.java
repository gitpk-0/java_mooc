import java.util.ArrayList;

public class Pipe<T> {

    private ArrayList<T> pipeItems;

    public Pipe() {
        this.pipeItems = new ArrayList<>();
    }

    public void putIntoPipe(T value) {
        this.pipeItems.add(0, value);

        // or
        // this.pipeItems.add(value);
    }

    public T takeFromPipe() {
        if (this.pipeItems.isEmpty()) {
            return null;
        }

        int lastIndex = this.pipeItems.size() - 1;
        T temp = this.pipeItems.get(lastIndex);
        this.pipeItems.remove(lastIndex);
        return temp;

        // or
        // T previouslyInPipe = this.pipeItems.get(0);
        // this.pipeItems.remove(0);
        //
        // return previouslyInPipe;
    }

    public boolean isInPipe() {
        return this.pipeItems.size() > 0;
        // or
        // return !this.pipeItems.isEmpty();
    }
}
