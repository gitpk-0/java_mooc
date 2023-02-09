
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MainProgram {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Book> books = new ArrayList<>();

        while (true) {
            System.out.println("Input the name of the book, empty stops: ");
            String title = scanner.nextLine();
            if (title.equals("")) {
                break;
            }

            System.out.println("Input the age recommendation: ");
            int ageReco = Integer.valueOf(scanner.nextLine());

            Book book = new Book(title, ageReco);
            books.add(book);
            System.out.println();
        }
        System.out.println();

        System.out.println(books.size() + " books in total.");
        System.out.println();
        System.out.println("Books: ");

        Comparator<Book> comparator = Comparator
                .comparing(Book::getAgeRecommendation)
                .thenComparing(Book::getTitle);

        Collections.sort(books, comparator);
        // Collections.reverse(books);

        books.stream().forEach(book -> System.out.println(book));

    }

}
