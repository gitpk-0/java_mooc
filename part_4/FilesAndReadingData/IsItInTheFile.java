import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class IsItInTheFile {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Name of the file:");
        String file = scanner.nextLine();

        // reading the file here.
        ArrayList<String> list = new ArrayList<>();
        try (Scanner reader = new Scanner(Paths.get(file))) {
            while (reader.hasNextLine()) {
                String row = reader.nextLine();
                list.add(row);
            }
        } catch (Exception e) {
            String error = "error";
            String errorMessage = e.getMessage();
//            System.out.println("Error: " + e.getMessage());
        }


        System.out.println("Search for:");
        String searchedFor = scanner.nextLine();

        if (error.equals("error")) {
            System.out.println("Reading the file " + file + " failed.");
        }else if (list.contains(searchedFor)) {
            System.out.println("Found!");
        } else {
            System.out.println("Not found.");
        }
    }
}
