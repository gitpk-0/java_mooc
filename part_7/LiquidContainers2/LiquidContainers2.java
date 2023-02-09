
import java.util.Scanner;

public class LiquidContainers2 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Container first = new Container();
        Container second = new Container();

        System.out.println("First: " + first);
        System.out.println("Second: " + second);


        while (true) {
            System.out.print("> ");

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");
            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);

            // add amount
            if (command.equals("add")) {
                first.add(amount);
            }

            // remove amount
            if (command.equals("remove")) {
                second.remove(amount);
            }

            // move amount
            if (command.equals("move")) {
                if (amount > 0 && first.contains() > 0) {
                    if (first.contains() - amount >= 0 && second.contains() + amount <= 100) {
                        first.remove(amount);
                        second.add(amount);
                    } else {
                        amount = amount + (first.contains() - amount);
                        if (second.contains() + amount >= 100) {
                            second.add(100);
                            first.remove(first.contains());
                        } else {
                            second.add(amount);
                            first.remove(first.contains());
                        }
                    }
                }
            }


            System.out.println("First: " + first);
            System.out.println("Second: " + second);


//        Container container = new Container();
//        System.out.println(container);
//
//        container.add(50);
//        System.out.println(container);
//        System.out.println(container.contains());
//
//        container.remove(60);
//        System.out.println(container);
//
//        container.add(200);
//        System.out.println(container);
        }
    }

}
