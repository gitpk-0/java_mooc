import java.util.Scanner;

public class NumberAndSumOfNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfNumbers = 0;
        int total = 0;

        while (true) {
            System.out.println("Give a number: ");
            int number = Integer.valueOf(scanner.nextLine());
            numberOfNumbers = numberOfNumbers + 1;
            total = total + number;


            if (number == 0) {
                System.out.println("Number of Numbers: " + numberOfNumbers);
                System.out.println("Sum of the numbers: " + total);
                break;
            }
        }
    }
}
