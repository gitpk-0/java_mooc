
import java.util.ArrayList;

public class GradeRegister {

    private ArrayList<Integer> grades;
    private ArrayList<Integer> examPoints;

    public GradeRegister() {
        this.grades = new ArrayList<>();
        this.examPoints = new ArrayList<>();
    }

    public void addGradeBasedOnPoints(int points) {
        this.grades.add(pointsToGrade(points));
        this.examPoints.add(points);
    }

    public int numberOfGrades(int grade) {
        int count = 0;
        for (int received : this.grades) {
            if (received == grade) {
                count++;
            }
        }

        return count;
    }

    public static int pointsToGrade(int points) {

        int grade = 0;
        if (points < 50) {
            grade = 0;
        } else if (points < 60) {
            grade = 1;
        } else if (points < 70) {
            grade = 2;
        } else if (points < 80) {
            grade = 3;
        } else if (points < 90) {
            grade = 4;
        } else {
            grade = 5;
        }

        return grade;
    }

    public double averageOfGrades() {
        int totalGradePoints = 0;
        int count = 0;
        for (Integer item: this.grades) {
            totalGradePoints += item;
            count++;
        }

        if (count > 0) {
            return (double) totalGradePoints / count;
        } else {
            return -1;
        }
    }

    public double averageOfPoints() {
        int totalExamPoints = 0;
        int count = 0;

        for (int points: this.examPoints) {
            totalExamPoints += points;
            count++;
        }

        if (count > 0) {
            return (double) totalExamPoints / count;
        } else {
            return -1;
        }
    }


}
