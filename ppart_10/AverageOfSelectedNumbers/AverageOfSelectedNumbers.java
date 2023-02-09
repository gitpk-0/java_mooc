
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

public class AverageOfSelectedNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // toteuta ohjelmasi tänne

        System.out.println("Input numbers, type \"end\" to stop");
        ArrayList<String> inputs = new ArrayList<>();

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("end")) {
                break;
            }

            inputs.add(input);
        }

        System.out.println("Print the average of the negative numbers or the positive numbers? (n/p)");
        String selection = scanner.nextLine();

        System.out.print("Average of the negative numbers: ");
        if (selection.equals("n")) {
            double negativeAverage = inputs.stream()
                    .mapToInt(i -> Integer.valueOf(i))
                    .filter(i -> i < 0)
                    .average()
                    .getAsDouble();
            System.out.print(negativeAverage);
        } else if (selection.equals("p")) {
            double positiveAverage = inputs.stream()
                    .mapToInt(i -> Integer.valueOf(i))
                    .filter(i -> i > 0)
                    .average()
                    .getAsDouble();
            System.out.print(positiveAverage);
        }



    }


}
