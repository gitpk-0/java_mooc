
import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // test your class here

        // add test
        // List<String> myList = new List<>();
        // myList.add("hello");
        // myList.add("world");

        // contains test
        // List<String> myList = new List<>();
        // System.out.println(myList.contains("hello"));
        // myList.add("hello");
        // System.out.println(myList.contains("hello"));

        // remove test
        // List<String> myList = new List<>();
        // System.out.println(myList.contains("hello"));
        // myList.add("hello");
        // System.out.println(myList.contains("hello"));
        // myList.remove("hello");
        // System.out.println(myList.contains("hello"));

        // search test
        List<String> myList = new List<>();
        System.out.println(myList.contains("hello"));
        myList.add("hello");
        System.out.println(myList.contains("hello"));
        int index = myList.indexOfValue("hello");
        System.out.println(index);
        System.out.println(myList.value(index));
        myList.remove("hello");
        System.out.println(myList.contains("hello"));

        // size test
        System.out.println(myList.size());
        System.out.println(myList);

    }

}
