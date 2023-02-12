/* MULTIDIMENSIONAL DATA */

/*Previously we have used one dimensional arrays, where the index tells us the
location of a value in the only dimension. We can also create multidimensional
arrays. Then we need the indexes of a value in each dimension to access the
value. This comes handy when our data is multidimensional, for example when
dealing with coordinates.

A two dimensional array with two rows and three columns can be created like so:*/

int rows = 2;
int columns = 3;
int[][] twoDimensionalArray = new int[rows][columns];

/*In the array we created above, each row refers to an array with a certain number
of columns. We can iterate over a two dimensional array using two nested for
loops like so:*/

int rows = 2;
int columns = 3;
int[][] twoDimensionalArray = new int[rows][columns];

System.out.println("row, column, value");
for (int row = 0; row < twoDimensionalArray.length; row++) {
    for (int column = 0; column < twoDimensionalArray[row].length; column++) {
        int value = twoDimensionalArray[row][column];
        System.out.println("" + row + ", " + column + ", " + value);
    }
}

// The program output is as follows:

// Sample output
// row, column, value
// 0, 0, 0
// 0, 1, 0
// 0, 2, 0
// 1, 0, 0
// 1, 1, 0
// 1, 2, 0

/*We can see that the default value of variables type int is 0.

We can change the values in the array just like before. Below we set new values
to three elements of the array.*/

int rows = 2;
int columns = 3;
int[][] twoDimensionalArray = new int[rows][columns];

twoDimensionalArray[0][1] = 4;
twoDimensionalArray[1][1] = 1;
twoDimensionalArray[1][0] = 8;

System.out.println("row, column, value");
for (int row = 0; row < twoDimensionalArray.length; row++) {
    for (int column = 0; column < twoDimensionalArray[row].length; column++) {
        int value = twoDimensionalArray[row][column];
        System.out.println("" + row + ", " + column + ", " + value);
    }
}
// The program output is as follows:

// Sample output
// row, column, value
// 0, 0, 0
// 1, 0, 4
// 2, 0, 0
// 0, 1, 8
// 1, 1, 1
// 2, 1, 0

// //
/*
// Array vs. Hash table
We can implement the same functionality using a hash table. Wouldn't a hash
table be a better option, since we do not have to worry about increasing its
size at any point?

When we search for a value of a key from a hash table, we use the hashCode
method to find the index to search from. There can be multiple values at the
same index (on a list). Then we have to compare the key we want to find the
value for to the key of each key-value pair on the list using the equals
method.

When we search for a value of a key — or index — in an array, we do not have to
do any of that.

An array either contains a certain value or it does not, so there is a small
performance beneft on using arrays.

This performance benefit comes with some added workload and proneness to errors.
Hash tables have tested and proven functionality for increasing the size of the
table. Arrays do not come with this benefit, and when implementing a new
functionality we might cause errors which increases the workload. However,
errors are accepted and natural part of software development.

When we consider the memory usage, hash tables might — in some situations — have
some benefits. When an array is created, enough memory for the whole array is
allocated for it. If we do not have values in each element of the array, some
of the memory stays unused. With hash tables this does not happen — the size of
the hash table is increased only when necessary.*/