
import java.util.Arrays;
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // test your method here

        int[] numbers = {3, -1, 8, 4};

        System.out.println(sum(numbers, 0, 0, 0, 0)); // 0
        System.out.println(sum(numbers, 0, 0, 0, 10)); // 0
        System.out.println(sum(numbers, 0, 1, 0, 10)); // 3
        System.out.println(sum(numbers, 0, 1, -10, 10)); // 3
        System.out.println(sum(numbers, -1, 999, -10, 10)); // 14

    }

    public static int sum(int[] array, int fromWhere, int toWhere, int smallest, int largest) {

        int arrayIndexMin;
        int arrayIndexMax;

        arrayIndexMin = fromWhere < 0 ? 0 : fromWhere;
        arrayIndexMax = toWhere > array.length ? array.length : toWhere;

        int i = 0;
        int sum = 0;
        while (i < array.length) {
            boolean valueConditions = array[i] <= largest && array[i] >= smallest;
            boolean indexConditions = i >= arrayIndexMin && i < arrayIndexMax;

            if (valueConditions && indexConditions) {
                sum += array[i];
            }

            i++;
        }

        return sum;
    }

}
// int sum = Arrays.stream(array)
//         .filter(number -> number <= largest && number >= smallest)
//         .filter(number -> Arrays.asList(array).indexOf(number) > arrayIndexMin && Arrays.asList(array).indexOf(number) < arrayIndexMax)
//         .sum();
