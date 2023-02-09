
import java.util.ArrayList;
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstContainer = 0;
        int secondContainer = 0;
        int maxFill = 100;

        System.out.println("First: " + firstContainer + "/" + maxFill);
        System.out.println("Second: " + secondContainer + "/" + maxFill);


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
                if (amount > 0) {
                    if (firstContainer + amount <= maxFill) {
                        firstContainer += amount;
                    } else {
                        firstContainer = 100;
                    }
                }
            }

            // move amount
            if (command.equals("move")) {
                if (amount > 0 && firstContainer > 0) {
                    if (firstContainer - amount >= 0 && secondContainer + amount <= maxFill) {
                        firstContainer -= amount;
                        secondContainer += amount;
                    } else {
                        amount = amount + (firstContainer - amount);
                        if (secondContainer + amount >= maxFill) {
                            secondContainer = 100;
                            firstContainer = 0;
                        } else {
                            secondContainer += amount;
                            firstContainer = 0;
                        }
                    }
                }
            }

            // remove amount
            if (command.equals("remove")) {
                if (amount > 0 && secondContainer > 0) {
                    if (secondContainer - amount > 0) {
                        secondContainer -= amount;
                    } else {
                        secondContainer = 0;
                    }
                }
            }

            System.out.println("First: " + firstContainer + "/" + maxFill);
            System.out.println("Second: " + secondContainer + "/" + maxFill);

        }
    }

}
