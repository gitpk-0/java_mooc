
public class Program {

    public static void main(String[] args) {
        // Test your method here

        // int[][] matrix = {
        //         {3, 2, 7, 6},
        //         {2, 4, 1, 0},
        //         {3, 2, 1, 0}
        // };
        //
        // System.out.println(arrayAsString(matrix));
        // System.out.println("------");
        //
        // int[][] matrix2 = {
        //         {2, 4, 1, 0, 1},
        //         {3, 2, 7, 6, 1},
        //         {3, 2, 7, 6, 1},
        //         {3, 2, 1, 0, 1}
        // };
        //
        // System.out.println(arrayAsString(matrix2));
        // System.out.println("------");

        int[][] matrix3 = {
                {1},
                {2, 2},
                {3, 3, 3},
                {4, 4, 4, 4}
        };
        System.out.println(arrayAsString(matrix3));
    }

    public static String arrayAsString(int[][] array) {
        StringBuilder sb = new StringBuilder();

        int rows = array.length;
        int columns = array[rows - 1].length;

        for (int row = 0; row < array.length; row++) {
            for (int column = 0; column < array[row].length; column++) {
                sb.append(array[row][column]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

}
