// Reading Input

// Input refers to text written by the user read by the program. 

// Input is always read as a string. 

// For reading input, we use the Scanner tool that comes with Java.

// The tool can be imported for use in a program by adding the command 
// import java.util.Scanner; before the beginning of the 
// main program's frame (public class ...). 

// The tool itself is created with Scanner scanner = new Scanner(System.in);.


import java.util.Scanner;

public class Program {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // We can now use the scanner tool.
        // This tool is used to read input.
    }
}


// More precisely, input is read with the scanner tool's nextLine() method. 

// The call scanner.nextLine() is left waiting for the user to write something. 

// When user writes something and presses enter, the provided string is 
// assigned to a string variable (in this instance message). 

// The program is then able to reference the variable message later on