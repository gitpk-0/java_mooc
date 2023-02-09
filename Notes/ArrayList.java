
// USING AND CREATING LISTS

/** 
 * For an ArrayList to be used, it first needs be imported into the program. 
 * This is achieved by including the command import java.util.ArrayList; at 
 * the top of the program. Below is an example program where an ArrayList is 
 * imported into the program.
 * **/


 // import the list to make it available to the program
import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        // no implementation yet
    }
}

/** The type of the ArrayList variable is ArrayList. When a list variable is 
 * initialized, the type of the values to be stored is also defined in addition 
 * to the variable type — all the variables stored in a given list are of the 
 * same type. As such, the type of an ArrayList that stores strings is 
 * ArrayList<String>. A new list is created with the command new ArrayList<>(); 
 * **/


// DEFINING THE TYPE OF VALUES THAT A LIST CAN CONTAIN
/** 
  * When defining the type of values that a list can include, the first letter 
  * of the element type has to be capitalized. A list that includes int-type
  *  variables has to be defined in the form ArrayList<Integer>; and a list
  *  that includes double-type variables is defined in the
  *  form ArrayList<Double>.

The reason for this has to do with how the ArrayList is implemented. Variables 
in Java can be divided into two categories: value type (primitive) and reference
 type (reference type) variables. Value-type variables such as int or double 
 hold their actual values. Reference-type variables such as ArrayList, in 
 contrast, contain a reference to the location that contains the value(s) 
 relating to that variable.

Value-type variables can hold a very limited amount of information, whereas 
references can store a near limitless amount of it.

You'll find examples below of creating lists that contain different types 
of values.
**/

ArrayList<Integer> list = new ArrayList<>();
list.add(1);

ArrayList<Double> list = new ArrayList<>();
list.add(4.2);

ArrayList<Boolean> list = new ArrayList<>();
list.add(true);

ArrayList<String> list = new ArrayList<>();
list.add("String is a reference-type variable");

/** 
 * Once a list has been created, ArrayList assumes that all the variables 
 * contained in it are reference types. Java automatically converts an int 
 * variable into Integer when one is added to a list, and the same occurs when
 *  a variable is retrieved from a list. The same conversion occurs for 
 * double-type variables, which are converted to Double. This means that even 
 * though a list is defined to contain Integer-type variables, variables of 
 * type int can also be added to it.**/

ArrayList<Integer> integers = new ArrayList<>();
int integer = 1;
integers.add(integer);

ArrayList<Double> doubles = new ArrayList<>();
double d = 4.2;
doubles.add(d);

// ADDING TO A LIST AND RETRIEVING A VALUE FROM A SPECIFIC PLACE

/** 
 * The next example demonstrates the addition of a few strings into an ArrayList
 *  containing strings. Addition is done with the list method add, which takes 
 * the value to be added as a parameter. We then print the value at position 
 * zero. To retrieve a value from a certain position, you use the list method 
 * get, which is given the place of retrieval as a parameter.

To call a list method you first write the name of the variable describing the 
list, followed by a dot and the name of the method.
**/

// import list so that the program can use it
import java.util.ArrayList;

public class WordListExample {

    public static void main(String[] args) {
        // create the word list for storing strings
        ArrayList<String> wordList = new ArrayList<>();

        // add two values to the word list
        wordList.add("First");
        wordList.add("Second");

        // retrieve the value from position 0 of the word list, and print it
        System.out.println(wordList.get(0));  // prints: First
    }
}
