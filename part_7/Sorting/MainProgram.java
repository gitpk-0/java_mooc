// SELECTION SORT
import java.util.Arrays;

public class MainProgram {

    public static void main(String[] args) {
        // write your test code here

//        int[] numbers = {-1, 3, 1, 7, 4, 5, 2, 4, 3};
//        System.out.println(MainProgram.indexOfSmallestFrom(numbers, 7)); // 8

//        int[] numbers = {8, 3, 7, 9, 1, 2, 4};
//        System.out.println(MainProgram.indexOfSmallestFrom(numbers, 0)); // 4
//        System.out.println(MainProgram.indexOfSmallestFrom(numbers, 1)); // 4
//        System.out.println(MainProgram.indexOfSmallestFrom(numbers, 2)); // 4
//
//        int[] numeros = {1, 2, 7, 9, 8, 3, 4};
//        System.out.println(MainProgram.indexOfSmallestFrom(numeros, 0)); // 0
//        System.out.println(MainProgram.indexOfSmallestFrom(numeros, 1)); // 1
//        System.out.println(MainProgram.indexOfSmallestFrom(numeros, 2)); // 5
//
//        int[] numeros1 = {4, 2, 3, 9, 8, 5, 1};
//        System.out.println(MainProgram.indexOfSmallestFrom(numeros1, 0)); // 6
//        System.out.println(MainProgram.indexOfSmallestFrom(numeros1, 1)); // 6
//        System.out.println(MainProgram.indexOfSmallestFrom(numeros1, 2)); // 6

//        int[] numbers1 = {3, 2, 5, 4, 8};
//
//        System.out.println(Arrays.toString(numbers1)); // [3, 2, 5, 4, 8]
//
//        MainProgram.swap(numbers1, 1, 0);
//        System.out.println(Arrays.toString(numbers1)); // [2, 3, 5, 4, 8]
//
//        MainProgram.swap(numbers1, 0, 3);
//        System.out.println(Arrays.toString(numbers1)); // [4, 3, 5, 2, 8]

        int[] numbers = {8, 3, 7, 9, 1, 2, 4};
        MainProgram.sort(numbers);
    }

    // find the smallest value
    public static int smallest(int[] array) {
        int small = array[0];
        for (int num : array) {
            if (num < small) {
                small = num;
            }
        }
        return small;
    }

    // find index of the smallest value
    public static int indexOfSmallest(int[] array) {
        int index = 0;
        for (int num : array) {
            if (num == smallest(array)) {
                return index;
            }
            index++;
        }
        return 0;
    }

    // find the index of the smallest value after a specified value
    public static int indexOfSmallestFrom(int[] array, int startIndex) {
        int index = Integer.MAX_VALUE;
        int smallest = Integer.MAX_VALUE;
        for (int i = startIndex; i < array.length; i++) {
            if (array[i] < smallest) {
                smallest = array[i];
                index = i;
            }
        }
        return index;
    }

    // swap
    public static void swap(int[] array, int index1, int index2) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(Arrays.toString(array));
            swap(array, indexOfSmallestFrom(array, i), i);
        }
    }
}
