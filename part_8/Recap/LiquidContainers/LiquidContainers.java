
import java.util.Scanner;

public class LiquidContainers {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int firstContainer = 0;
        int secondContainer = 0;
        int maxFill = 100;


        while (true) {
            System.out.println("First: " + firstContainer + "/" + maxFill);
            System.out.println("Second: " + secondContainer + "/" + maxFill);

            String input = scan.nextLine();
            if (input.equals("quit")) {
                break;
            }

            String[] parts = input.split(" ");

            String command = parts[0];
            int amount = Integer.valueOf(parts[1]);



            if (command.equals("add")) {
                if (amount > 0) {
                    if (firstContainer + amount <= maxFill) {
                        firstContainer += amount;
                    } else {
                        firstContainer = maxFill;
                    }
                }
            }

            if (command.equals("move")) {
                // check if move amount is greater than what is in firstContainer
                if (amount > firstContainer) {
                    amount = amount - (amount - firstContainer);
                }

                if (secondContainer + amount <= maxFill) {
                    secondContainer += amount;
                    firstContainer -= amount;
                } else {
                    secondContainer = maxFill;
                    firstContainer = 0;
                }
            }

            if (command.equals("remove")) {
                if (amount > secondContainer) {
                    secondContainer = 0;
                } else {
                    secondContainer -= amount;
                }
            }
            System.out.println("");
        }
    }
}
