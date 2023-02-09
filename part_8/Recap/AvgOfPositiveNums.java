
import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int total = 0;
        double count = 0;

        while (true) {
            int number = Integer.valueOf(scanner.nextLine());

            if (number == 0) {
                break;
            }

            if (number > 0) {
                total += number;
                count++;
            }
        }

        if (total == 0) {
            System.out.println("Cannot calculate the average");
        }
        System.out.println(total / count);
    }
}
