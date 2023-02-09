
import java.util.ArrayList;
import java.util.Scanner;

public class PersonalDetails {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String longestName = "";
        int longestNameLength = 0;
        int sumBirthYear = 0;
        int currentAge = 0;
        double avgBirthYear = 0;
        int count = 0;

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }

            String[] person = input.split(",");

            int currentNameLength = person[0].length();

            if (currentNameLength > longestNameLength) {
                longestName = person[0];
                longestNameLength = currentNameLength;
            }

            currentAge = Integer.valueOf(person[1]);
            sumBirthYear = sumBirthYear + currentAge;
            count = count + 1;

        }

        avgBirthYear = (double) sumBirthYear / count;

        System.out.println("Longest name: " + longestName);
        System.out.println("Average of the birth years: " + avgBirthYear);


    }
}
