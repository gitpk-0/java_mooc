import java.util.Scanner;

public class UserInterface {

    private TodoList list;
    private Scanner scanner;

    public UserInterface(TodoList list, Scanner scanner) {
        this.list = list;
        this.scanner = scanner;
    }

    public void start() {

        while (true) {
            System.out.println("Command: ");
            String input = scanner.nextLine();

            if (input.equals("stop")) {
                break;
            }

            if (input.equals("add")) {
                System.out.println("To add: ");
                String task = scanner.nextLine();
                list.add(task);
            }

            if (input.equals("list")) {
                list.print();
            }

            if (input.equals("remove")) {
                System.out.println("Which one is removed? ");
                int taskToRemove = Integer.valueOf(scanner.nextLine());
                list.remove(taskToRemove);
            }
        }
    }
}
