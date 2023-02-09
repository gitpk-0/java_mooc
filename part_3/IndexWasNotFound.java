

import java.util.Scanner;

public class IndexWasNotFound {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array = new int[10];
        array[0] = 6;
        array[1] = 2;
        array[2] = 8;
        array[3] = 1;
        array[4] = 3;
        array[5] = 0;
        array[6] = 9;
        array[7] = 7;

        System.out.print("Search for? ");
        int searching = Integer.valueOf(scanner.nextLine());

        // Implement the search functionality here
        int i = 0;
        int found = 0;
        while (i < array.length) {
            if (array[i] == searching) {
                found = 1;
                break;
            } else {
                i++;
            }
        }

        if (found == 1) {
            System.out.println(searching + " is at index " + i + ".");    
        } else {
            System.out.println(searching + " was not found.");
        }
    }
}

// type of the elements
