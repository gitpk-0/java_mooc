
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Item> items = new ArrayList<>();

        while (true) {
            System.out.println("Identifier? (empty will stop)");
            String identifier = scanner.nextLine();
            if (identifier.equals("")) {break;}

            System.out.println("Name? (empty will stop)");
            String name = scanner.nextLine();
            if (name.equals("")) {break;}

            // convert to an Item object
            Item newItem = new Item(identifier, name);

            // add to items list if non-existant
            if (!(items.contains(newItem))) {
                items.add(newItem);
            }
        }

        System.out.println("==Items==");
        for (Item item: items) {
            System.out.println(item.toString());
        }

    }
}
