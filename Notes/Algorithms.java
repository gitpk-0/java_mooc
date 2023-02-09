/* Algorithms */

// Sorting Information -- see Sorting folder part 7

// //

// Static or not 

/* At the start of the course, all of our methods included the static modifier, 
but when we started using objects, use of the static modifier was banned.

Methods in Java can be divided into two groups, based on whether they have the
static modifier or not. Methods without the static modifier are instance
methods. Methods with the static modifier are class methods.

Instance methods are methods that are associated with an object, can process the
objects variables and can call the object's other methods. Instance methods
specifically CAN use the this modifier, which refers to the variables
associated with the specific object, that is calling the instance method. 

Class methods can't use the this modifier, meaning that they can only access the
variables they are given as parameters or that they create themselves.

In reality class methods can also access class variable, among other things.
However, these things are outside the scope of this course. */

// //

// Built-in Sorting Algorithms in Java

/* Java offers a significant amount of ready to use sorting algorithms. Arrays can
be sorted (into their natural order) using the class method sort of the
Arrays-class. Lists can be sorted (into their natural order) using the class
method sort of the Collections class. */

int[] numbers = {8, 3, 7, 9, 1, 2, 4};
System.out.println(Arrays.toString(numbers));
Arrays.sort(numbers);
System.out.println(Arrays.toString(numbers));
// Sample output:
// [8, 3, 7, 9, 1, 2, 4]
// [1, 2, 3, 4, 7, 8, 9]

ArrayList<Integer> numbers = new ArrayList<>();
numbers.add(8);
numbers.add(3);
numbers.add(7);
System.out.println(numbers);
Collections.sort(numbers);
System.out.println(numbers);
// Sample output:
// [8, 3, 7]
// [3, 7, 8]

/* Java's built-in sorting algorithms work with value type variables and some of
Java's built-in reference type variables, like String. In order for our own
classes to be sorted, we need to provide Java with some tips on how to do that,
because the classes themselves don't contain information on how objects created
from them should be ordered. We'll get back to ordering objects created from
classes we made ourselves in the advanced course in programming. */

// //

/* Information Retrieval */
// algorithms meant for info retrieval

// Linear Search

/* Linear search is a search algorithm that searches for information in an array
   by going through every value in the array one by one. When the value that
   was searched for is found, its index is immediately returned. If the
   requested value cannot be found, linear search returns the information that
   the value was not found — typically this means returning -1 instead of a
   valid index. */

public class Algorithms {

    public static int linearSearch(int[] array, int searched) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == searched) {
                return i;
            }
        }

        return -1;
    }
}

/* In the worst case scenario, i.e when the value searched for isn't found, the
   algorithm has to do as many comparisons as there are values in the array. In
   an array containing, say, 10 million values, this means 10 million
   comparisons. If we are doing more than one search, it makes sense to try and
   improve efficiency. */

//

// Binary Search (aka half-interval search or logarithmic search)

/* When the data searched is in order, searching can be implemented a lot more
   efficiently than in linear search. The idea behind Binary Search is to start
   looking for the searched value in the middle index of the array (or list),
   compare the value found there to the searched value, and if needed(i.e, when
   the value isn't found there) eliminate half of the search area. */