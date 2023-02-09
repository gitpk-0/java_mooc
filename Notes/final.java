//
// final variables
//

/* If a class has variables that contain the final keyword, these varaibles
cannot be changed after objects of this class have been constructed

If you want to change these variables, you must create a new object */

// Java Program to illustrate Use of Final Keyword
// With Primitive Datatypes
 
// Main class
class GFG {
 
    // Main driver method
    public static void main(String args[])
    {
 
        // Final primitive variable
        final int i = 10;
        i = 30;
 
        // Error will be generated above
    }
}

public class Money {

    private final int euros;
    private final int cents;

    public Money(int euros, int cents) {
        this.euros = euros;
        this.cents = cents;
    }

    public int euros() {
        return euros;
    }

    public int cents() {
        return cents;
    }

    public String toString() {
        String zero = "";
        if (cents <= 10) {
            zero = "0";
        }

        return euros + "." + zero + cents + "e";
    }
}
/* The word final used in the definition of object variables catches attention.

The result of this word is that the values of these object variables cannot be 
modified after they have been set in the constructor. 

The objects of Money class are unchangeable so immutable — if we want to 
e.g. increase the amount of money, we must create a new object to represent 
that new amount of money. */

/* Note: Non-primitive variables are always references to objects in Java, the 
members of the referred object can be changed. final for non-primitive variables
just means that they cannot be changed to refer to any other object. */

// Java Program to illustrate Use of Final Keyword
// With Non-primitive Datatypes

// Class 1
class Helper {
    int i = 10;
}

// Class 2
// main class
class GFG {

    // Main driver method
    public static void main(String args[])
    {

        final Helper t1 = new Helper();
        t1.i = 30; // Works

        // Print statement for successful execution of
        // Program
        System.out.print("Successfully executed");
    }
}
// output:
// Successfully executed