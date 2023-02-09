
import java.util.Scanner;

public class NameOfTheOldest {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        String oldestName = "";
        int oldestAge = 0;
        int currentAge = 0;
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("")) {
                break;
            }

            String[] person = input.split(",");

            String name = person[0];
            currentAge = Integer.valueOf(person[1]);
            if (currentAge > oldestAge) {
                oldestName = name;
                oldestAge = currentAge;
            }
        }
        System.out.println("Name of the oldest: " + oldestName);
    }
}
