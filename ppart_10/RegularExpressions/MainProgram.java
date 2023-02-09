import java.util.Scanner;

public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise
        Scanner scanner = new Scanner(System.in);
        Checker checker = new Checker();

        while (true) {
            System.out.println("Enter a string: ");
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }

            // checker.isDayOfWeek(input);
            // checker.allVowels(input);
            checker.timeOfDay(input);
            System.out.println();
        }
    }
}
