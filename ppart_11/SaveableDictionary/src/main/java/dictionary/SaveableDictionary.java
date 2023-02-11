package dictionary;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SaveableDictionary {

    private HashMap<String, String> dictOne;
    private String file;

    // Constructors
    public SaveableDictionary() {
        this.dictOne = new HashMap<>();
    }

    public SaveableDictionary(String file) {
        this();
        this.file = file;
    }

    // Methods
    public void add(String words, String translation) {
        if (!dictOne.containsKey(words)) {
            dictOne.putIfAbsent(words, translation);
            dictOne.putIfAbsent(translation, words);
        }
    }

    public String translate(String word) {
        return dictOne.get(word);
    }

    public void delete(String word) {
        String translation = this.translate(word);

        dictOne.remove(translation);
        dictOne.remove(word);
    }

    public boolean load() {
        try (Scanner fileReader = new Scanner(Paths.get(this.file))) {
            while (fileReader.hasNextLine()) {
                String line = fileReader.nextLine();
                String[] parts = line.split(":");

                this.add(parts[0], parts[1]); // adds word/translation both ways
            }
            return true;
        } catch (IOException e) {
            System.out.println("Problem with loading file: " + e.getMessage());
            return false;
        }

    }

    public boolean save() {
        try {
            PrintWriter writer = new PrintWriter(this.file);

            ArrayList<String> alreadyInFile = new ArrayList<>();

            for (String word : this.dictOne.keySet()) {
                String translation = this.translate(word);

                if (!alreadyInFile.contains(word)) {
                    alreadyInFile.add(word);
                    alreadyInFile.add(translation);
                    writer.println(word + ":" + translation);
                }
            }
            writer.close();
        } catch (IOException e) {
            System.out.println("Problem with saving file: " + e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        System.out.println("--------------------");
        System.out.println("IN THIS DICTIONARY: ");
        this.dictOne.keySet()
                .stream()
                .forEach(key -> System.out.println(key + " : " + dictOne.get(key)));
        return "";
    }
}