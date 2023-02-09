import java.util.ArrayList;

public class Grade {

    private ArrayList<Integer> grades;
    private ArrayList<Integer> points;


    public Grade() {
        this.grades = new ArrayList<>();
        this.points = new ArrayList<>();
    }

    public void add(int number) {
        if (number >= 0 && number <= 100) {
            this.grades.add(number);
            this.points.add(gradesToPoints(number));
        }
    }

    public double getAverageAll() {
        int sum = 0;
        int count = this.grades.size();
        for (int grade : this.grades) {
            sum += grade;
        }
        return (double) sum / count;
    }

    public double getAveragePassing() {
        int sum = 0;
        int count = 0;
        for (int grade : this.grades) {
            if (grade >= 50) {
                sum += grade;
                count++;
            }
        }
        return (double) sum / count;
    }

    public double passPercentage() {
        int count = this.grades.size();
        int passCount = 0;
        for (int grade : this.grades) {
            if (grade >= 50) {
                passCount++;
            }
        }
        return ((double) passCount / count) * 100;
    }

    public static int gradesToPoints(int grade) {
        int points = 0;
        if (grade < 50) {
            points = 0;
        } else if (grade < 60) {
            points = 1;
        } else if (grade < 70) {
            points = 2;
        } else if (grade < 80) {
            points = 3;
        } else if (grade < 90) {
            points = 4;
        } else {
            points = 5;
        }
        return points;
    }

    public ArrayList<Integer> getPoints() {
        return this.points;
    }
}
