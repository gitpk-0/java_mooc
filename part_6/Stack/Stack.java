import java.util.ArrayList;

public class Stack {

    private ArrayList<String> list;

    public Stack() {
        this.list = new ArrayList<>();
    }

    public boolean isEmpty() {
        if (list.size() > 0) {
            return  false;
        }
        return true;
    }

    public void add(String value) {
        this.list.add(value);
    }

    public ArrayList<String> values() {
        return list;
    }

    public String take() {
        return list.remove(list.size()-1);
    }
}
