import java.util.ArrayList;

public class TodoList {

    private ArrayList<String> todoList;

    public TodoList() {
        this.todoList = new ArrayList<>();
    }

    public void add(String task) {
        this.todoList.add(task);
    }

    public void print() {
        int count = 1;
        for (String item: todoList) {
            System.out.println(count + ": " + item);
            count++;
        }
    }

    public void remove(int number) {
        int index = number - 1;
        this.todoList.remove(index);
    }
}
