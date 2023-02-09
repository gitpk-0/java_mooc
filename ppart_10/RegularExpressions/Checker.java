

public class Checker {


    public boolean isDayOfWeek(String string) {
        if (string.matches("mon|tue|wed|thu|fri|sat|sun")) {
            System.out.println("The form is correct.");
            return true;
        } else {
            System.out.println("The form is incorrect.");
            return false;
        }
    }

    public boolean allVowels(String string) {
        if (string.matches("[a|e|i|o|u]*")) {
            System.out.println("The form is correct.");
            return true;
        } else {
            System.out.println("The form is incorrect.");
            return false;
        }

        // or
        // return string.matches("[aeiou]*");
    }

    public boolean timeOfDay(String string) {
        if (string.matches("(0[0-9]|1[0-9]|2[0-3]):[0-5][0-9]:[0-5][0-9]")) {
            System.out.println("The form is correct.");
            return true;
        } else {
            System.out.println("The form is incorrect.");
            return false;
        }

        // or
        // return string.matches("([01][0123456789]|2[0123]):[012345][0123456789]:[012345][0123456789]");
    }

}
