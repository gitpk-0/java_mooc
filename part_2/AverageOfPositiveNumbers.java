import java.util.Scanner;

public class AverageOfPositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int total = 0;
        int count = 0;

        while (true) {
            System.out.println("Give a number:");
            int number = Integer.valueOf(scanner.nextLine());


            if (number > 0) {
                total = total + number;
                count = count + 1;
            } else if (number == 0) {
                double average = (double) total / count;
                if (count == 0) {
                    System.out.println("Cannot calculate the average");
                    break;
                } else {
                    System.out.println(average);
                    break;
                }
            }
        }

    }
}
