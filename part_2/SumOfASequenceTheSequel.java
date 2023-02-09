
import java.util.Scanner;

public class SumOfASequenceTheSequel {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("First number?");
        int one = Integer.valueOf(scanner.nextLine());
        System.out.println("Second number?");
        int two = Integer.valueOf(scanner.nextLine());

        int total = 0;


        for (int i = one; i <= two; i++) {
            total += i;
        }

        System.out.println("The sum is " + total);
    }
}
