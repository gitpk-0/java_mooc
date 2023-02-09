
import java.util.ArrayList;
import java.util.Scanner;

public class mainProgram {

    public static void main(String[] args) {
        // NB! Do not create other scanner objects than the one below
        // if and when you create other classes, pass the scanner to them
        // as a parameter

        Scanner scan = new Scanner(System.in);
        ArrayList<Bird> birdList = new ArrayList<>();

        while (true) {
            System.out.println("?");
            String command = scan.nextLine();

            // quit
            if (command.equals("Quit")) {
                break;
            }

            // add a new bird and add it to birdList
            if (command.equals("Add")) {
                System.out.println("Name: ");
                String name = scan.nextLine();
                System.out.println("Name in Latin: ");
                String latin = scan.nextLine();

                Bird newBird = new Bird(name, latin);
                birdList.add(newBird);
            }

            // if bird in birdList add a single observation
            if (command.equals("Observation")) {
                System.out.println("Bird? ");
                String name = scan.nextLine();
                int count = 0;

                for (Bird bird : birdList) {
                    if (bird.getBirdName().equals(name)) {
                        bird.addObservation();
                        count++;
                    }
                }

                if (count == 0) { // bird not in birdList
                    System.out.println("Not a bird!");
                }
            }

            // print all birds in birdList
            if (command.equals("All")) {
                for (Bird bird : birdList) {
                    System.out.println(bird);
                }
            }

            // print specified bird in birdList
            if (command.equals("One")) {
                System.out.println("Bird? ");
                String name = scan.nextLine();
                for (Bird bird : birdList) {
                    if (bird.getBirdName().equals(name)) {
                        System.out.println(bird);
                    }
                }
            }
        }
    }
}
