package dictionary;

public class Main {
    public static void main(String[] args) {
        // You can test your dictionary here

        // SaveableDictionary dictionary = new SaveableDictionary();
        // dictionary.add("apina", "monkey");
        // dictionary.add("banaani", "banana");
        // dictionary.add("apina", "apfe");
        //
        // System.out.println(dictionary.translate("apina"));
        // System.out.println(dictionary.translate("monkey"));
        // System.out.println(dictionary.translate("ohjelmointi"));
        // System.out.println(dictionary.translate("banana"));

        // SaveableDictionary dictionary = new SaveableDictionary();
        // dictionary.add("apina", "monkey");
        // dictionary.add("banaani", "banana");
        // dictionary.add("ohjelmointi", "programming");
        // dictionary.delete("apina");
        // dictionary.delete("banana");
        //
        // System.out.println(dictionary.translate("apina"));
        // System.out.println(dictionary.translate("monkey"));
        // System.out.println(dictionary.translate("banana"));
        // System.out.println(dictionary.translate("banaani"));
        // System.out.println(dictionary.translate("ohjelmointi"));

        // SaveableDictionary dictionary = new SaveableDictionary("words.txt");
        // boolean wasSuccessful = dictionary.load();
        //
        // if (wasSuccessful) {
        //     System.out.println("Successfully loaded the dictionary from file");
        // }
        //
        // System.out.println(dictionary.translate("apina"));
        // System.out.println(dictionary.translate("ohjelmointi"));
        // System.out.println(dictionary.translate("alla oleva"));

        // apina:monkey
        // alla oleva:below
        // olut:beer

        // Saved with the code
        SaveableDictionary s = new SaveableDictionary("words.txt");
        s.load();
        // System.out.println(s);
        // System.out.println("---");
        s.delete("below");
        // System.out.println("---");
        // s.add("tieokone", "computer");

        // System.out.println(s.size());
        // System.out.println(s);
        // s.save();
    }
}
