package dictionary;

import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.*;

public class SaveableDictionary {

    private HashMap<String, String> finToEngDict;
    private HashMap<String, String> EngToFinDict;


    private Scanner scanner;
    private String file;


    // Constructors
    public SaveableDictionary() {
        this.finToEngDict = new HashMap<>();
        this.EngToFinDict = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this();
        this.file = file;
    }

    // Methods
    public void add(String words, String translation) {
        finToEngDict.putIfAbsent(words, translation);
        EngToFinDict.putIfAbsent(translation, words);
    }

    public String translate(String word) {
        if (finToEngDict.containsKey(word)) {
            return finToEngDict.get(word);
        } else if (EngToFinDict.containsKey(word)) {
            return EngToFinDict.get(word);
        } else {
            return null;
        }
    }

    public void delete(String word) {
        if (this.finToEngDict.containsKey(word)) {
            this.finToEngDict.remove(word);
        } else if (this.EngToFinDict.containsKey(word)) {
            this.EngToFinDict.remove(word);
        }
    }

    public boolean load() {
        try (Scanner scanner = new Scanner(Paths.get(this.file))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(":");

                this.add(parts[0], parts[1]);
            }
        } catch (Exception e) {
            System.out.println("Error in load() method: " + e.getMessage());
            return false;
        }
        return true;
    }

    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(this.file);
            ArrayList<String> alreadyIn = new ArrayList<>();
            for (String word : finToEngDict.keySet()) {
                writer.println(word + ":" + finToEngDict.get(word));
                alreadyIn.add(word);
                alreadyIn.add(finToEngDict.get(word));
            }

            for (String word : EngToFinDict.keySet()) {
                if (!alreadyIn.contains(word)) {
                    writer.println(word + ":" + EngToFinDict.get(word));
                    alreadyIn.add(word);
                    alreadyIn.add(EngToFinDict.get(word));
                }
            }
            writer.close(); // closes the file and ensures that the written text is saved to the file
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void write() throws Exception {

    }
}