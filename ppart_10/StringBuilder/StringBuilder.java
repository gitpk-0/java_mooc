

public class MainProgram {

    public static void main(String[] args) {
        // you can create test code here. Call the methods that you'll implement
        // during the course of this exercise


        // takes more memory -- less performant
        ArrayList<String> words = new ArrayList<>();
        words.add("first");
        words.add("second");
        words.add("third");

        String connectedString = "";
        for (int i = 0; i < words.size(); i++) {
            connectedString = connectedString + words.get(i);
        }
        System.out.println(connectedString);




        // takes less memory -- more performant
        ArrayList<String> words = new ArrayList<>();
        words.add("first");
        words.add("second");
        words.add("third");

        StringBuilder connectedString = new StringBuilder();
        for (int i = 0; i < words.size(); i++) {
            connectedString.append(words.get(i));
        }
        System.out.println(connectedString.toString());
    }
}
