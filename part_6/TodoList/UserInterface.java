import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private TodoList todoList;

    public UserInterface(TodoList todoList, Scanner scanner) {
        this.scanner = scanner;
        this.todoList = todoList;
    }

    public void start() {
        final ArrayList<String> validCommands = new ArrayList<>();
        validCommands.add("stop");
        validCommands.add("add");
        validCommands.add("list");
        validCommands.add("remove");

        while (true) {
            System.out.println("Command: ");
            String command = scanner.nextLine();

            if (command.equals("stop")) {
                break;
            }

            if (command.equals("add")) {
                System.out.println("To add: ");
                String todo = scanner.nextLine();

                this.todoList.add(todo);
            }

            if (command.equals("list")) {
                this.todoList.print();
            }

            if (command.equals("remove")) {
                System.out.println("Which one is removed? ");
                int index = Integer.valueOf(scanner.nextLine());

                this.todoList.remove(index);
            }

            if (!(validCommands.contains(command))) {
                System.out.println("Unknown command");
            }
        }
    }
}