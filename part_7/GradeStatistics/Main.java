
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        // Write your program here -- consider breaking the program into 
        // multiple classes.
//        String input = "-42\n" + "24\n"  +
//                "42\n" + "72\n" +
//                "80\n" + "52\n"  +
//                "-1\n";

//        String input = "102\n" + "-4\n"  +
//                "33\n" + "77\n" +
//                "99\n" + "1\n"  +
//                "-1\n";

        Scanner scanner = new Scanner(System.in);

        Grade grades = new Grade();

        TextUI textUI = new TextUI(scanner, grades);
        textUI.start();
    }
}
