
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class PositiveNumbers {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // test your method here

        List<Integer> numbers = new ArrayList<Integer>();
        numbers.add(-3);
        numbers.add(-7);
        numbers.add(0);
        numbers.add(7);
        numbers.add(3);

        System.out.println(positive(numbers));

    }

    public static List<Integer> positive(List<Integer> numbers) {
        List<Integer> values = numbers.stream()
                .filter(value -> value > 0)
                .collect(Collectors.toList());
                // .collect(Collectors.toCollection(ArrayList::new))
        return values;
    }

}
