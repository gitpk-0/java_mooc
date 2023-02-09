import java.util.Scanner;

public class TextUI {

    private Scanner scanner;
    private Grade grades;

    public TextUI(Scanner scanner, Grade grades) {
        this.scanner = scanner;
        this.grades = grades;
    }

    public void start() {
        System.out.println("Enter points totals, -1 stops: ");
        while (true) {
            String input = scanner.nextLine();

            int number = Integer.valueOf(input);

            if (number == -1) {
                break;
            }

            grades.add(number);

        }


        System.out.println("Point average (all): " + grades.getAverageAll());
        System.out.println("Point average (passing): " + grades.getAveragePassing());
        System.out.println("Pass percentage: " + grades.passPercentage());
        System.out.println("Grade distribution: ");
        printPointDistribution();

    }

    public void printPointDistribution() {
        int point = 5;
        while (point >= 0) {
            int stars = 0;
            for (int points: this.grades.getPoints()) {
                if (points == point) {
                    stars++;
                }
            }
            System.out.print(point + ": ");
            printStars(stars);
            System.out.println("");

            point--;
        }
    }

    public static void printStars(int stars) {
        while (stars > 0) {
            System.out.print("*");
            stars--;
        }
    }

}
