import java.util.ArrayList;
import java.util.Scanner;

public class TextUI {
    private Scanner scanner;
    private SimpleDictionary dictionary;


    public TextUI(Scanner scanner, SimpleDictionary dictionary) {
        this.scanner = scanner;
        this.dictionary = dictionary;
    }

    public void start() {
        final ArrayList<String> validCommands = new ArrayList<>();
        validCommands.add("end");
        validCommands.add("add");
        validCommands.add("search");

        while (true) {
            System.out.println("Command: ");
            String command = scanner.nextLine();

            if (command.equals("end")) {
                System.out.println("Bye bye!");
                break;
            }

            if (command.equals("add")) {
                System.out.println("Word: ");
                String word = scanner.nextLine();

                System.out.println("Translation: ");
                String translation = scanner.nextLine();

                // add word and translation to dictionary
                dictionary.add(word, translation);
            }

            if (command.equals("search")) {
                System.out.println("To be translated: ");
                String word = scanner.nextLine();

                if (dictionary.wordInDict(word)) {
                    System.out.println("Translation: " + dictionary.translate(word));
                } else {
                    System.out.println("Word " + word + " was not found");
                }
            }

            if (!(validCommands.contains(command))) {
                System.out.println("Unknown command");
            }
        }
    }
}
