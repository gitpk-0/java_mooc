
// import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.HashMap;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // You can test the class here

        /* Implement the class HashMap in the exercise base, following along the lines of the previous example.

        Unlike the example, implement the class so that it uses the ready-made Java class ArrayList in its internal
        implementation. */

        // Pair<String, Integer> pair = new Pair<>("one", 1);
        // System.out.println(pair.getKey() + " -> " + pair.getValue());

        List<String> myList = new List<>();
        HashMap<String, String> hashMap = new HashMap<>();

        for (int i = 0; i < 1000000; i++) {
            myList.add("" + i);
            hashMap.put("" + i, "" + i);
        }

        List<String> elements = new List<>();
        Random randomizer = new Random();
        for (int i = 0; i < 1000; i++) {
            elements.add("" + randomizer.nextInt(2000000));
        }

        long listSearchStartTime = System.nanoTime();
        for (int i = 0; i < elements.size(); i++) {
            myList.contains(elements.value(i));
        }
        long listSearchEndTime = System.nanoTime();

        long hashMapSearchStartTime = System.nanoTime();
        for (int i = 0; i < elements.size() -2; i++) {
            hashMap.get(elements.value(i));
        }
        long hashMapSearchEndTime = System.nanoTime();


        long listSearch = listSearchEndTime - listSearchStartTime;
        System.out.println("List: the search took about " + listSearch / 1000000 + " milliseconds (" +
                listSearch + " nanoseconds.)");

        long hashMapSearch = hashMapSearchEndTime - hashMapSearchStartTime;
        System.out.println("Hash map: the search took about " + hashMapSearch / 1000000 +
                " milliseconds (" + hashMapSearch + " nanoseconds.)");

    }

}
