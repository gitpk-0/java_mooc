import java.util.ArrayList;

public class TodoList {

    private ArrayList<String> tasks;


    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public void add(String task) {
        this.tasks.add(task);
    }


    public void remove(int number) {
        this.tasks.remove(tasks.get(number - 1));
    }

    public void print() {
        int count = 1;
        for (String task : this.tasks) {
            System.out.println(count + ": " + task);
            count++;
        }
    }
}
